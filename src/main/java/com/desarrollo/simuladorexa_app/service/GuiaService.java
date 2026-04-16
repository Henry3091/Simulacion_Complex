package com.desarrollo.simuladorexa_app.service;

import com.desarrollo.simuladorexa_app.model.Guia;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class GuiaService {

    public Guia obtenerGuia(String archivo) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            ClassPathResource resource = new ClassPathResource(archivo);

            try (InputStream is = resource.getInputStream()) {
                return mapper.readValue(is, Guia.class);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}