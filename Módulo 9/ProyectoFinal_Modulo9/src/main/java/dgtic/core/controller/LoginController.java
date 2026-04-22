package dgtic.core.controller;

import dgtic.core.model.entity.Usuarios;
import dgtic.core.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    /*@PostMapping("/login")
    public String procesarLogin(@RequestParam("email") String email,
                                @RequestParam("password") String password,
                                HttpSession session,
                                Model model) {

        // Buscamos al usuario real en la base de datos
        Usuarios usuario = usuarioService.autenticarUsuario(email, password);

        if (usuario != null) {
            // Si existe, guardamos su ID y Nombre en la sesión
            session.setAttribute("usuarioId", usuario.getId());

            String apellido = usuario.getApellido() != null ? " " + usuario.getApellido() : "";
            session.setAttribute("usuarioLogueado", usuario.getNombre() + apellido);

            // Verificamos el ID de su rol según tus INSERTS
            // 1=Admin, 2=Profesor, 3=Alumno, 4=Padre
            Integer idRol = usuario.getRol().getId();

            if (idRol == 1) {
                session.setAttribute("rol", "ADMIN");
            } else if (idRol == 2) {
                session.setAttribute("rol", "PROFESOR");
            } else if (idRol == 3) {
                session.setAttribute("rol", "ALUMNO");
            } else if (idRol == 4) {
                session.setAttribute("rol", "PADRE");
            }

            // Lo mandamos a la pantalla de bienvenida
            return "redirect:/principal";
        }

        // Si la consulta a la BD no trajo nada
        model.addAttribute("error", "Credenciales inválidas. Verifica tu correo y contraseña.");
        return "login";
    }

    @GetMapping("/logout")
    public String cerrarSesion(HttpSession session) {
        session.invalidate();
        return "redirect:/login?logout";
    }*/
}