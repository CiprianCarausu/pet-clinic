package cyker.springframework.petclinic.services;

import cyker.springframework.petclinic.model.Owner;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);


}
