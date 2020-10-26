package cyker.springframework.petclinic.bootstrap;

import cyker.springframework.petclinic.model.Owner;
import cyker.springframework.petclinic.model.Pet;
import cyker.springframework.petclinic.model.PetType;
import cyker.springframework.petclinic.model.Vet;
import cyker.springframework.petclinic.services.OwnerService;
import cyker.springframework.petclinic.services.PetTypeService;
import cyker.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {


        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();

        owner1.setFirstName("John");
        owner1.setLastName("Fiona");
        owner1.setAddress("123 Bricker");
        owner1.setCity("Miami");
        owner1.setTelephone("12321241231");

        Pet fionasPet = new Pet();
        fionasPet.setPetType(savedDogPetType);
        fionasPet.setOwner(owner1);
        fionasPet.setBirthDate(LocalDate.now());
        fionasPet.setName("Rosco");
        owner1.getPets().add(fionasPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();

        owner2.setFirstName("Jana");
        owner2.setLastName("Smith");
        owner2.setAddress("123 Bricker");
        owner2.setCity("Miami");
        owner2.setTelephone("12321241231");

        Pet janasCat = new Pet();
        janasCat.setName("Mew");
        janasCat.setOwner(owner2);
        janasCat.setBirthDate(LocalDate.now());
        janasCat.setPetType(savedCatPetType);
        owner2.getPets().add(janasCat);

        ownerService.save(owner2);

        System.out.println("Loading owners....");

        Vet vet1 = new Vet();

        vet1.setFirstName("Ana");
        vet1.setLastName("Crynya");

        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("Cry");
        vet2.setLastName("Ban");

        vetService.save(vet2);

        System.out.println("Loading Vets....");
    }
}
