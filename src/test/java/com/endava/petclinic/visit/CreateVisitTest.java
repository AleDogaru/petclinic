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

public class CreateVisitTest extends TestBaseClass{

    @Test
    public void shouldCreateVisit () {

        //GIVEN
        Owner owner = fixture.createOwner().getOwner();

        PetType petType = new PetType();
        petType.setId(1L);
        Pet pet = testDataProvider.getPet(owner, petType);
        Response createPetResponse = petClient.createPet(pet);
        createPetResponse.then().statusCode (HttpStatus.SC_CREATED);
        long petId = createPetResponse.body().jsonPath().getLong("id");
        pet.setId(petId);
        Visit visit = testDataProvider.getVisit(owner, pet);

        //WHEN
        Response response = visitClient.createVisit(visit);

        //THEN
        response.then().statusCode (HttpStatus.SC_CREATED);

    }

    @Test
    public void shouldFailCreateVisitGivenEmptyDate () {

        //GIVEN
        Owner owner = fixture.createOwner().getOwner();

        PetType petType = new PetType();
        petType.setId(1L);
        Pet pet = testDataProvider.getPet(owner, petType);
        Response createPetResponse = petClient.createPet(pet);
        createPetResponse.then().statusCode (HttpStatus.SC_CREATED);
        long petId = createPetResponse.body().jsonPath().getLong("id");
        pet.setId(petId);
        Visit visit = testDataProvider.getVisit(owner, pet);
        visit.setDate("");

        //WHEN
        Response response = visitClient.createVisit(visit);

        //THEN
        response.then().statusCode (HttpStatus.SC_BAD_REQUEST);

    }

    @Test
    public void shouldFailCreateVisitGivenEmptyDescription () {

        //GIVEN
        Owner owner = fixture.createOwner().getOwner();

        PetType petType = new PetType();
        petType.setId(1L);
        Pet pet = testDataProvider.getPet(owner, petType);
        Response createPetResponse = petClient.createPet(pet);
        createPetResponse.then().statusCode (HttpStatus.SC_CREATED);
        long petId = createPetResponse.body().jsonPath().getLong("id");
        pet.setId(petId);
        Visit visit = testDataProvider.getVisit(owner, pet);
        visit.setDescription("");

        //WHEN
        Response response = visitClient.createVisit(visit);

        //THEN
        response.then().statusCode (HttpStatus.SC_BAD_REQUEST);

    }

    @Test
    public void shouldFailCreateVisitGivenPastDate () {

        //GIVEN
        Owner owner = fixture.createOwner().getOwner();

        PetType petType = new PetType();
        petType.setId(1L);
        Pet pet = testDataProvider.getPet(owner, petType);
        Response createPetResponse = petClient.createPet(pet);
        createPetResponse.then().statusCode (HttpStatus.SC_CREATED);
        long petId = createPetResponse.body().jsonPath().getLong("id");
        pet.setId(petId);
        Visit visit = testDataProvider.getVisit(owner, pet);
        visit.setDate("2021/08/03");

        //WHEN
        Response response = visitClient.createVisit(visit);

        //THEN
        response.then().statusCode (HttpStatus.SC_BAD_REQUEST);

    }

    @Test
    public void shouldFailCreateVisitGivenNoDate () {

        //GIVEN
        Owner owner = fixture.createOwner().getOwner();

        PetType petType = new PetType();
        petType.setId(1L);
        Pet pet = testDataProvider.getPet(owner, petType);
        Response createPetResponse = petClient.createPet(pet);
        createPetResponse.then().statusCode (HttpStatus.SC_CREATED);
        long petId = createPetResponse.body().jsonPath().getLong("id");
        pet.setId(petId);
        Visit visit = testDataProvider.getVisit(owner, pet);
        visit.setDate("");

        //WHEN
        Response response = visitClient.createVisit(visit);

        //THEN
        response.then().statusCode (HttpStatus.SC_BAD_REQUEST);

    }
}
