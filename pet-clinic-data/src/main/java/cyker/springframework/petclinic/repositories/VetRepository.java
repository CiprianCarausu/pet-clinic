package cyker.springframework.petclinic.repositories;

import cyker.springframework.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
