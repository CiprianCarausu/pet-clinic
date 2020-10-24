package cyker.springframework.petclinic.services.map;

import cyker.springframework.petclinic.model.Vet;
import cyker.springframework.petclinic.services.CrudService;

import java.util.Set;

public class VetService extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long> {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void deleteById(Long object) {

    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
