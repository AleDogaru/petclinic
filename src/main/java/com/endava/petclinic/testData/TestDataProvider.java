package com.endava.petclinic.testData;

import com.endava.petclinic.model.Owner;
import com.endava.petclinic.model.Pet;
import com.endava.petclinic.model.PetType;
import com.endava.petclinic.model.Visit;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class TestDataProvider {

    private Faker faker = new Faker();

    public Owner getOwner() {
        Owner owner = new Owner();
        owner.setFirstName(faker.name().firstName());
        owner.setLastName(faker.name().lastName());
        owner.setAddress(faker.address().fullAddress());
        owner.setCity(faker.address().city());
        owner.setTelephone(faker.number().digits(faker.number().numberBetween(0,10)));

        return owner;
    }

    public String getNumberWithDigitsBetween(int min, int max) {
        return faker.number().digits(faker.number().numberBetween(min,max));
    }

    public Pet getPet (Owner owner, PetType type)  {

        String birthDate = faker.date().birthday().toInstant().atZone(ZoneId.systemDefault())
                .format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        Pet pet = new Pet ();
        pet.setName(faker.funnyName().name());
        pet.setBirthDate(birthDate);
        pet.setOwner(owner);
        pet.setType(type);
        return pet;
    }

    public PetType getPetType() {
        PetType petType = new PetType();
        petType.setName(faker.animal().name());

        return petType;
    }

    public Visit getVisit (Owner owner, Pet pet) {

        String date = faker.date().future(60, 1, TimeUnit.DAYS ).toInstant().atZone(ZoneId.systemDefault())
                .format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        Visit visit = new Visit ();
        visit.setDate(date);
        visit.setDescription(faker.medical().medicineName());
        visit.setOwner(owner);
        visit.setPet(pet);

        return visit;
    }

}
