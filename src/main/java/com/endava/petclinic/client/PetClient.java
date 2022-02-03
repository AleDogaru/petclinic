package com.endava.petclinic.client;

import com.endava.petclinic.filters.AuthenticationFilter;
import com.endava.petclinic.filters.LogFilter;
import com.endava.petclinic.model.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.endava.petclinic.util.EnvReader.*;
import static io.restassured.RestAssured.given;

public class PetClient extends BaseClient{

    public Response createPet(Pet pet) {
        return getBasicRestConfig()
                .contentType(ContentType.JSON)
                .body(pet)
                .post("/api/pets");
    }

    public Response getPetById(Long petId) {
        return getBasicRestConfig()
                .pathParams("petId", petId)
                .get("/api/pets/{petId}");
    }

    public Response getPetList() {
        return getBasicRestConfig()
                .get("api/pets");
    }

    public Response deletePetById(Long petId) {
        return getBasicRestConfig()
                .pathParams("petId", petId)
                .delete("/api/pets/{petId}");
    }
}
