package cyker.springframework.petclinic.repositories;

import cyker.springframework.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}

