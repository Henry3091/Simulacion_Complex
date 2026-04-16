package com.desarrollo.simuladorexa_app.controller;

import org.springframework.web.bind.annotation.RequestParam;
import com.desarrollo.simuladorexa_app.model.Guia;
import com.desarrollo.simuladorexa_app.service.GuiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuiaController {

    @Autowired
    private GuiaService guiaService;

    @GetMapping("/guia")
    public String guia(
            @RequestParam(defaultValue = "guia1.json") String archivo,
            Model model) {

        Guia guia = guiaService.obtenerGuia("preguntas/" + archivo);

        model.addAttribute("guia", guia);
        model.addAttribute("archivoActual", archivo);

        return "guia";
    }
}
