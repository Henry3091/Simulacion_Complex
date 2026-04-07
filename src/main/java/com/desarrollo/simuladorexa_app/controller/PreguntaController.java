package com.desarrollo.simuladorexa_app.controller;

import com.desarrollo.simuladorexa_app.model.Pregunta;
import com.desarrollo.simuladorexa_app.service.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PreguntaController {

    @Autowired
    private PreguntaService preguntaService;

    private List<Pregunta> preguntas;
    private int indice = 0;
    private int puntaje = 0;

    private boolean mostrarResultado = false;
    private boolean ultimaCorrecta = false;

    // 👇 AQUÍ eliges el banco
    @GetMapping("/")
    public String iniciar(
            @RequestParam(defaultValue = "preguntas1.json") String banco,
            Model model) {

        preguntas = preguntaService.obtenerPreguntas(banco);

        indice = 0;
        puntaje = 0;
        mostrarResultado = false;

        model.addAttribute("pregunta", preguntas.get(indice));
        model.addAttribute("indice", indice);
        model.addAttribute("mostrarResultado", false);

        return "index";
    }

    @PostMapping("/validar")
    public String validarRespuesta(@RequestParam String seleccion, Model model) {

        Pregunta actual = preguntas.get(indice);

        ultimaCorrecta = seleccion.equals(actual.getRespuestaCorrecta());

        if (ultimaCorrecta) {
            puntaje++;
        }

        mostrarResultado = true;

        model.addAttribute("pregunta", actual);
        model.addAttribute("indice", indice);
        model.addAttribute("correcta", ultimaCorrecta);
        model.addAttribute("respuestaCorrecta", actual.getRespuestaCorrecta());
        model.addAttribute("mostrarResultado", true);

        return "index";
    }

    @PostMapping("/siguiente")
    public String siguientePregunta(Model model) {

        indice++;
        mostrarResultado = false;

        if (indice >= preguntas.size()) {
            model.addAttribute("final", true);
            model.addAttribute("puntaje", puntaje);
            return "index";
        }

        model.addAttribute("pregunta", preguntas.get(indice));
        model.addAttribute("indice", indice);
        model.addAttribute("mostrarResultado", false);

        return "index";
    }
}