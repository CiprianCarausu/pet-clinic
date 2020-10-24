package cyker.springframework.petclinic.services;

import cyker.springframework.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findByLastName(String lastName);
    Pet findById(Long Id);
    Pet save(Pet owner);
    Set<Pet> findAll();
}
