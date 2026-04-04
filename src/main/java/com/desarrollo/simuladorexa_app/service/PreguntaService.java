package com.desarrollo.simuladorexa_app.service;

import com.desarrollo.simuladorexa_app.model.Pregunta;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class PreguntaService {

    public List<Pregunta> obtenerPreguntas() {
        List<Pregunta> todas = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            Resource[] resources = new PathMatchingResourcePatternResolver()
                    .getResources("classpath:preguntas/*.json");

            for (Resource resource : resources) {
                try (InputStream is = resource.getInputStream()) {
                    List<Pregunta> lista = mapper.readValue(
                            is, new TypeReference<List<Pregunta>>() {}
                    );
                    todas.addAll(lista);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return todas;
    }
}