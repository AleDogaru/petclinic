package com.endava.petclinic.client;

import com.endava.petclinic.filters.AuthenticationFilter;
import com.endava.petclinic.filters.LogFilter;
import com.endava.petclinic.model.PetType;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.endava.petclinic.util.EnvReader.*;
import static com.endava.petclinic.util.EnvReader.getBasePath;
import static io.restassured.RestAssured.given;

public class PetTypeClient extends BaseClient {
    public Response createPetType(PetType petType) {
        return getBasicRestConfig()
                .contentType(ContentType.JSON)
                .body(petType)
                .post("/api/pettypes");
    }

    public Response getPetTypeById(Long petTypeId){
        return getBasicRestConfig()
                .pathParams("petTypeId", petTypeId)
                .get("/api/pettypes/{petTypeId}");
    }

    public Response getPetTypeList() {
        return getBasicRestConfig()
                .get("api/pettypes");
    }

    public Response deletePetTypeById(Long petTypeId) {
        return getBasicRestConfig()
                .pathParams("petTypeId", petTypeId)
                .delete("/api/pettypes/{petTypeId}");
    }
}
