package com.endava.petclinic.petType;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.Owner;
import com.endava.petclinic.model.PetType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.withArgs;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

public class GetPetTypeListTest extends TestBaseClass {

   /* @Test
    public void shouldGetPetTypeList() {
        //GIVEN
        PetType petType = testDataProvider.getPetType();

        //WHEN
        Response response = ownerClient.getOwnerList();

        //THEN
        response.then().statusCode(HttpStatus.SC_OK)
                .body("find{ it -> it.id==%s }.name", withArgs(petType), is(petType.getName()));

        Owner actualPetType = response.body().jsonPath().param("id", ).getObject("find{ it -> it.id==id }", PetType.class);
        assertThat(actualPetType, is(petType));

        List<PetType> petTypeList = response.body().jsonPath().getList("", PetType.class);
        assertThat(petTypeList, hasItem(petType));
    }*/
}
