package dgtic.core.controller;

import dgtic.core.model.dto.AsistenciasDTO;
import dgtic.core.model.dto.InscripcionesDTO;
import dgtic.core.model.entity.Inscripciones;
import dgtic.core.service.AsistenciaService;
import dgtic.core.service.InscripcionService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/profesores")
public class ProfesoresController {

    @Autowired
    private InscripcionService inscripcionService;

    @Autowired
    private AsistenciaService asistenciaService;

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
}