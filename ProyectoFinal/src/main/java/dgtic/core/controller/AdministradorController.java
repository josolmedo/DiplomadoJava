package dgtic.core.controller;

import dgtic.core.model.dto.AsignaturasDTO;
import dgtic.core.model.dto.UsuariosDTO;
import dgtic.core.service.AsignaturaService;
import dgtic.core.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    private AsignaturaService asignaturaService;

    @Autowired
    private UsuarioService usuarioService;

    // LECTURA
    @GetMapping("/asignaturas")
    public String listarAsignaturas(HttpSession session, Model model) {
        if (!"ADMIN".equals(session.getAttribute("rol"))) return "redirect:/login";

        model.addAttribute("contenido", "Gestión de Asignaturas");
        model.addAttribute("asignaturas", asignaturaService.obtenerTodas());
        return "administrador/lista-asignaturas-admin";
    }

    // CREACIÓN
    @GetMapping("/asignaturas/nueva")
    public String mostrarFormularioNueva(HttpSession session, Model model) {
        if (!"ADMIN".equals(session.getAttribute("rol"))) return "redirect:/login";

        model.addAttribute("contenido", "Nueva Asignatura");
        model.addAttribute("asignaturaDTO", new AsignaturasDTO());
        return "administrador/formulario-asignatura";
    }

    // ACTUALIZACIÓN
    @GetMapping("/asignaturas/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Integer id, HttpSession session, Model model) {
        if (!"ADMIN".equals(session.getAttribute("rol"))) return "redirect:/login";

        model.addAttribute("contenido", "Editar Asignatura");
        model.addAttribute("asignaturaDTO", asignaturaService.obtenerPorId(id));
        return "administrador/formulario-asignatura";
    }

    // GUARDAR
    @PostMapping("/asignaturas/guardar")
    public String guardarAsignatura(@Valid @ModelAttribute("asignaturaDTO") AsignaturasDTO dto,
                                    BindingResult result, HttpSession session, Model model) {
        if (!"ADMIN".equals(session.getAttribute("rol"))) return "redirect:/login";

        if (result.hasErrors()) {
            model.addAttribute("contenido", dto.getId() == null ? "Nueva Asignatura" : "Editar Asignatura");
            return "administrador/formulario-asignatura";
        }

        try {
            asignaturaService.guardar(dto);
            return "redirect:/administrador/asignaturas?exito";

        } catch (IllegalStateException e) {
            // Mostramos error de duplicado
            model.addAttribute("error", e.getMessage());
            model.addAttribute("contenido", dto.getId() == null ? "Nueva Asignatura" : "Editar Asignatura");
            return "administrador/formulario-asignatura";
        }
    }

    // ELIMINACIÓN
    @GetMapping("/asignaturas/eliminar/{id}")
    public String eliminarAsignatura(@PathVariable("id") Integer id, HttpSession session) {
        if (!"ADMIN".equals(session.getAttribute("rol"))) return "redirect:/login";

        try {
            asignaturaService.eliminar(id);
            return "redirect:/administrador/asignaturas?eliminado";
        } catch (Exception e) {
            // Falla si la asignatura ya tiene grupos asignados (Integridad referencial)
            return "redirect:/administrador/asignaturas?error";
        }
    }


    @PostMapping("/usuarios/guardar-alumno")
    public String guardarAlumnoAdmin(@Valid @ModelAttribute("usuarioDTO") UsuariosDTO dto,
                                     BindingResult result, HttpSession session, Model model) {
        if (!"ADMIN".equals(session.getAttribute("rol"))) return "redirect:/login";

        if (result.hasErrors()) {
            return "administrador/formulario-alumno";
        }

        try {
            // El 3 es el ID de rol de Alumno
            usuarioService.registrarNuevoUsuario(dto, 3);
            return "redirect:/administrador/agregar-alumno?exito";

        } catch (IllegalStateException e) {
            // Aqui gestiono el duplicado
            model.addAttribute("error", e.getMessage()); // Mandará: "El correo ya está registrado..."
            return "administrador/formulario-alumno";
        }
    }


    @GetMapping("/agregar-alumno")
    public String mostrarFormularioAlumno(HttpSession session, Model model) {
        // Protección de ruta: Solo el ADMIN puede entrar
        if (!"ADMIN".equals(session.getAttribute("rol"))) return "redirect:/login";

        model.addAttribute("usuarioDTO", new UsuariosDTO());
        return "administrador/formulario-alumno";
    }





}