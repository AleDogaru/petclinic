package com.endava.petclinic.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class Pet {

    private String birthDate;
    private Long id ;
    private String name;
    private PetType type;
    private Owner owner;

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString( this );
        } catch (JsonProcessingException e) {
            return super.toString();
        }
    }
}
