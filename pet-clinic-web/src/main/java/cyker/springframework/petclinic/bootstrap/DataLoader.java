package cyker.springframework.petclinic.bootstrap;

import cyker.springframework.petclinic.model.Owner;
import cyker.springframework.petclinic.model.Vet;
import cyker.springframework.petclinic.services.OwnerService;
import cyker.springframework.petclinic.services.VetService;
import cyker.springframework.petclinic.services.map.OwnerServiceMap;
import cyker.springframework.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();

        owner1.setFirstName("John");
        owner1.setLastName("Fiona");

        ownerService.save(owner1);

        Owner owner2 = new Owner();

        owner2.setFirstName("Jana");
        owner2.setLastName("Smith");

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
