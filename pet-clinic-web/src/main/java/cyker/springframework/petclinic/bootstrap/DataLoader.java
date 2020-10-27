package cyker.springframework.petclinic.bootstrap;

import cyker.springframework.petclinic.model.*;
import cyker.springframework.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);

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

        Visit catVisit = new Visit();
        catVisit.setPet(janasCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);

        System.out.println("Loading owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Ana");
        vet1.setLastName("Crynya");
        vet1.getSpecialities().add(savedRadiology);


        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("Cry");
        vet2.setLastName("Ban");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loading Vets....");
    }
}
