package com.endava.petclinic.visit;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.Owner;
import com.endava.petclinic.model.Pet;
import com.endava.petclinic.model.PetType;
import com.endava.petclinic.model.Visit;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.notNullValue;

public class DeleteVisitTest extends TestBaseClass {

    @Test
    public void shouldDeleteVisit () {
        //GIVEN
        Owner owner = fixture.createOwner().getOwner();

        PetType petType = testDataProvider.getPetType();
        Response createPetTypeResponse = petTypeClient.createPetType(petType);
        createPetTypeResponse.then().statusCode (HttpStatus.SC_CREATED).body("id", notNullValue());
        long petTypeId = createPetTypeResponse.body().jsonPath().getLong("id");
        petType.setId(petTypeId);
        Pet pet = testDataProvider.getPet(owner, petType);
        Response createPetResponse = petClient.createPet(pet);
        createPetResponse.then().statusCode (HttpStatus.SC_CREATED);
        long petId = createPetResponse.body().jsonPath().getLong("id");
        pet.setId(petId);
        Visit visit = testDataProvider.getVisit(owner, pet);
        Response createVisitResponse = visitClient.createVisit(visit);
        createVisitResponse.then().statusCode (HttpStatus.SC_CREATED);
        long visitId = createVisitResponse.body().jsonPath().getLong("id");
        visit.setId(visitId);

        //WHEN
        Response response = visitClient.deleteVisitById(visitId);

        //THEN
        response.then().statusCode (HttpStatus.SC_NO_CONTENT);

    }
}
