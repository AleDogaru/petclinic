package com.endava.petclinic.client;

import com.endava.petclinic.model.PetType;
import com.endava.petclinic.model.Visit;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class VisitClient extends BaseClient{

    public Response createVisit(Visit visit) {
        return getBasicRestConfig()
                .contentType(ContentType.JSON)
                .body(visit)
                .post("/api/visits");
    }

    public Response getVisitById(Long visitId){
        return getBasicRestConfig()
                .pathParams("petTypeId", visitId)
                .get("/api/visits/{visitId}");
    }

    public Response getVisitList() {
        return getBasicRestConfig()
                .get("api/visits");
    }

    public Response deleteVisitById(Long visitId) {
        return getBasicRestConfig()
                .pathParams("visitId", visitId)
                .delete("/api/visits/{visitId}");
    }
}
