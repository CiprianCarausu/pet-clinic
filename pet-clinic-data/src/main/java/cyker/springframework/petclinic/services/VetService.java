package cyker.springframework.petclinic.services;

import cyker.springframework.petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findByLastName(String lastName);
    Vet findById(Long Id);
    Vet save(Vet owner);
    Set<Vet> findAll();
}
