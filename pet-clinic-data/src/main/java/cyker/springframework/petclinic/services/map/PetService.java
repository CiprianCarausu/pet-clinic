package cyker.springframework.petclinic.services.map;

import cyker.springframework.petclinic.model.Pet;
import cyker.springframework.petclinic.services.CrudService;

import java.util.Set;

public class PetService extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);

    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void deleteById(Long object) {
     super.deleteByid(object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
