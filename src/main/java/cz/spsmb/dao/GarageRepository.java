package cz.spsmb.dao;
import cz.spsmb.model.Garage;
import cz.spsmb.model.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;


@ApplicationScoped
public class GarageRepository implements PanacheRepository<Garage> {
    public List<Garage> listByName(String ulice){
        return find("ulice", ulice).list();
    }
    public Garage listById(Long id){
        return findById(id);
    }
}