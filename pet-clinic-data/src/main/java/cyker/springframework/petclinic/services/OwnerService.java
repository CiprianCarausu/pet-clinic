package cyker.springframework.petclinic.services;

import cyker.springframework.petclinic.model.Owner;
import org.springframework.stereotype.Repository;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);


}
