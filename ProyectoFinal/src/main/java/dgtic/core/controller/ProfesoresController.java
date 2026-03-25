package dgtic.core.controller;

import dgtic.core.model.dto.AsistenciasDTO;
import dgtic.core.model.dto.InscripcionesDTO;
import dgtic.core.model.entity.Asistencias;
import dgtic.core.model.entity.Inscripciones;
import dgtic.core.service.AsistenciaService;
import dgtic.core.service.CorreoService;
import dgtic.core.service.InscripcionService;
import dgtic.core.service.ReportePdfService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/profesores")
public class ProfesoresController {

    @Autowired
    private InscripcionService inscripcionService;

    @Autowired
    private AsistenciaService asistenciaService;

    @Autowired
    private ReportePdfService reportePdfService;
    @Autowired
    private CorreoService correoService;

    // ==========================================
    // 1. MÓDULO DE CALIFICACIONES
    // ==========================================
    @GetMapping("/asignar-calificacion")
    public String mostrarFormularioCalificacion(HttpSession session, Model model) {
        Integer usuarioId = (Integer) session.getAttribute("usuarioId");
        if (usuarioId == null) return "redirect:/login";

        model.addAttribute("inscripcionDTO", new InscripcionesDTO());
        model.addAttribute("listaInscripciones", inscripcionService.obtenerInscripcionesPorProfesor(usuarioId));
        return "profesores/asignar-calificacion";
    }

    @PostMapping("/asignar-calificacion")
    public String guardarCalificacion(@Valid @ModelAttribute("inscripcionDTO") InscripcionesDTO dto,
                                      BindingResult result, HttpSession session, Model model) {
        Integer usuarioId = (Integer) session.getAttribute("usuarioId");

        if (result.hasErrors()) {
            model.addAttribute("listaInscripciones", inscripcionService.obtenerInscripcionesPorProfesor(usuarioId));
            return "profesores/asignar-calificacion";
        }

        inscripcionService.actualizarCalificacion(dto);
        return "redirect:/profesores/asignar-calificacion?exito";
    }

    // ==========================================
    // 2. MÓDULO DE ASISTENCIA
    // ==========================================
    @GetMapping("/registrar-asistencia")
    public String mostrarAsistenciaProfesor(HttpSession session, Model model) {
        Integer usuarioId = (Integer) session.getAttribute("usuarioId");
        if (usuarioId == null) return "redirect:/login";

        model.addAttribute("asistenciaDTO", new AsistenciasDTO());
        // Pasamos la lista de SUS alumnos
        model.addAttribute("misAlumnos", inscripcionService.obtenerInscripcionesPorProfesor(usuarioId));
        return "profesores/registrar-asistencia";
    }

    @PostMapping("/registrar-asistencia")
    public String procesarAsistenciaProfesor(@Valid @ModelAttribute("asistenciaDTO") AsistenciasDTO dto,
                                             BindingResult result, HttpSession session, Model model) {
        Integer usuarioId = (Integer) session.getAttribute("usuarioId");

        if (result.hasErrors()) {
            model.addAttribute("misAlumnos", inscripcionService.obtenerInscripcionesPorProfesor(usuarioId));
            return "profesores/registrar-asistencia";
        }

        try {
            // Buscamos la inscripción seleccionada para extraer al alumno y el grupo exacto
            Inscripciones inscripcion = inscripcionService.obtenerInscripcionesPorProfesor(usuarioId)
                    .stream()
                    .filter(i -> i.getId().equals(dto.getIdInscripcion()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Inscripción no válida"));

            dto.setIdAlumno(inscripcion.getAlumno().getId());
            dto.setIdGrupo(inscripcion.getGrupo().getId());

            // Usamos el mismo servicio que el alumno, así aplicamos la regla de "NO DUPLICADOS"
            asistenciaService.guardarAsistencia(dto);

        } catch (IllegalStateException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("misAlumnos", inscripcionService.obtenerInscripcionesPorProfesor(usuarioId));
            return "profesores/registrar-asistencia";
        } catch (Exception e) {
            model.addAttribute("error", "Ocurrió un error al guardar.");
            model.addAttribute("misAlumnos", inscripcionService.obtenerInscripcionesPorProfesor(usuarioId));
            return "profesores/registrar-asistencia";
        }

        return "redirect:/profesores/registrar-asistencia?exito";
    }

    @GetMapping("/descargar-asistencias/{idInscripcion}")
    public ResponseEntity<byte[]> descargarAsistenciasProfesor(@PathVariable Integer idInscripcion, HttpSession session) {
        Integer usuarioId = (Integer) session.getAttribute("usuarioId");
        if (usuarioId == null) return ResponseEntity.status(401).build();

        Inscripciones inscripcion = obtenerInscripcionSegura(usuarioId, idInscripcion);
        if (inscripcion == null) return ResponseEntity.status(403).build();

        List<Asistencias> asistencias = asistenciaService.obtenerAsistenciasPorAlumnoYGrupo(inscripcion.getAlumno().getId(), inscripcion.getGrupo().getId());
        byte[] pdf = reportePdfService.generarReporteAsistencias(asistencias, inscripcion.getAlumno().getUsuario());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Asistencias_" + inscripcion.getAlumno().getUsuario().getNombre() + ".pdf")
                .contentType(MediaType.APPLICATION_PDF).body(pdf);
    }

    @GetMapping("/enviar-asistencias/{idInscripcion}")
    public String enviarAsistenciasProfesor(@PathVariable Integer idInscripcion, HttpSession session) {
        Integer usuarioId = (Integer) session.getAttribute("usuarioId");
        if (usuarioId == null) return "redirect:/login";

        try {
            Inscripciones inscripcion = obtenerInscripcionSegura(usuarioId, idInscripcion);
            List<Asistencias> asistencias = asistenciaService.obtenerAsistenciasPorAlumnoYGrupo(inscripcion.getAlumno().getId(), inscripcion.getGrupo().getId());
            byte[] pdf = reportePdfService.generarReporteAsistencias(asistencias, inscripcion.getAlumno().getUsuario());

            String cuerpo = "Hola " + inscripcion.getAlumno().getUsuario().getNombre() + ",\n\nTu profesor ha enviado tu historial de asistencias de la materia " + inscripcion.getGrupo().getAsignatura().getNombre() + ".";
            correoService.enviarCorreoConPdf(inscripcion.getAlumno().getUsuario().getEmail(), "Reporte de Asistencias - EscuRed", cuerpo, pdf, "Asistencias.pdf");

            return "redirect:/profesores/registrar-asistencia?correoExito";
        } catch (Exception e) {
            return "redirect:/profesores/registrar-asistencia?correoError";
        }
    }

    @GetMapping("/enviar-calificacion/{idInscripcion}")
    public String enviarCalificacionProfesor(@PathVariable Integer idInscripcion, HttpSession session) {
        Integer usuarioId = (Integer) session.getAttribute("usuarioId");
        if (usuarioId == null) return "redirect:/login";

        try {
            Inscripciones inscripcion = obtenerInscripcionSegura(usuarioId, idInscripcion);

            // Reutilizamos el reporte pasándole solo esta materia en una lista
            byte[] pdf = reportePdfService.generarReporteCalificaciones(Collections.singletonList(inscripcion), inscripcion.getAlumno().getUsuario());

            // 1. Enviar al Alumno
            String correoAlumno = inscripcion.getAlumno().getUsuario().getEmail();
            String cuerpoAlumno = "Hola " + inscripcion.getAlumno().getUsuario().getNombre() + ",\n\nAdjunto tu calificación oficial de la materia " + inscripcion.getGrupo().getAsignatura().getNombre() + ".";
            correoService.enviarCorreoConPdf(correoAlumno, "Tu Calificación - EscuRed", cuerpoAlumno, pdf, "Calificacion.pdf");

            // 2. Enviar al Padre de Familia (Si tiene uno asignado)
            if (inscripcion.getAlumno().getPadre() != null) {
                String correoPadre = inscripcion.getAlumno().getPadre().getUsuario().getEmail();
                String cuerpoPadre = "Estimado padre de familia,\n\nPor este medio le hacemos llegar la calificación de su hijo(a) " + inscripcion.getAlumno().getUsuario().getNombre() + " correspondiente a la materia " + inscripcion.getGrupo().getAsignatura().getNombre() + ".";
                correoService.enviarCorreoConPdf(correoPadre, "Calificación de su hijo(a) - EscuRed", cuerpoPadre, pdf, "Calificacion_Hijo.pdf");
            }

            return "redirect:/profesores/asignar-calificacion?correoExito";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/profesores/asignar-calificacion?correoError";
        }
    }

    @GetMapping("/descargar-calificacion/{idInscripcion}")
    public ResponseEntity<byte[]> descargarCalificacionProfesor(@PathVariable Integer idInscripcion, HttpSession session) {
        Integer usuarioId = (Integer) session.getAttribute("usuarioId");
        if (usuarioId == null) return ResponseEntity.status(401).build();

        Inscripciones inscripcion = obtenerInscripcionSegura(usuarioId, idInscripcion);

        // Reutilizamos el reporte pasándole solo esta materia en una lista
        byte[] pdf = reportePdfService.generarReporteCalificaciones(Collections.singletonList(inscripcion), inscripcion.getAlumno().getUsuario());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Boleta_" + inscripcion.getAlumno().getUsuario().getNombre() + ".pdf")
                .contentType(MediaType.APPLICATION_PDF).body(pdf);
    }

    // Método de seguridad auxiliar para evitar que un profesor consulte alumnos de otros profesores
    private Inscripciones obtenerInscripcionSegura(Integer profesorUsuarioId, Integer idInscripcion) {
        return inscripcionService.obtenerInscripcionesPorProfesor(profesorUsuarioId).stream()
                .filter(i -> i.getId().equals(idInscripcion))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("El alumno no pertenece a los grupos de este profesor"));
    }


}