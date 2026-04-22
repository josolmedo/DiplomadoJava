package com.ejercicio_dos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/public/info")
    public String publicInfo() {
        return "Acceso libre: Información que toda persona puede ver.";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "Acceso restringido: Bienvenido al Dashboard de Administrador.";
    }
}