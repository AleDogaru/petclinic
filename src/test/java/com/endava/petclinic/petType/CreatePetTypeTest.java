package com.endava.petclinic.petType;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.Owner;
import com.endava.petclinic.model.Pet;
import com.endava.petclinic.model.PetType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.notNullValue;

public class CreatePetTypeTest extends TestBaseClass {

    @Test
    public void shouldCreatePetType () {
        //GIVEN
        PetType petType = testDataProvider.getPetType();

        //WHEN
        Response response = petTypeClient.createPetType(petType);

        //THEN
        response.then().statusCode (HttpStatus.SC_CREATED)
                .body("id" , notNullValue() );
    }

    @Test
    public void shouldFailCreatePetTypeGivenEmptyName () {
        //GIVEN
        PetType petType = testDataProvider.getPetType();
        petType.setName("");

        //WHEN
        Response response = petTypeClient.createPetType(petType);

        //THEN
        response.then().statusCode (HttpStatus.SC_BAD_REQUEST);
    }
}
