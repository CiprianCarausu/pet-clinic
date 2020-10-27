package cyker.springframework.petclinic.services.springdatajpa;

import cyker.springframework.petclinic.model.Visit;
import cyker.springframework.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import repositories.VisitRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {
    private final VisitRepository visitrepository;

    public VisitSDJpaService(VisitRepository visitrepository) {
        this.visitrepository = visitrepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitrepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitrepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitrepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitrepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        visitrepository.deleteById(aLong);
    }
}
