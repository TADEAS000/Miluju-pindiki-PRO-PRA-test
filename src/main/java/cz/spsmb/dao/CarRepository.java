package cz.spsmb.dao;
import cz.spsmb.model.Car;
import cz.spsmb.model.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;


@ApplicationScoped
public class CarRepository implements PanacheRepository<Car> {
    public List<Car> listByName(String brand){
        return find("brand", brand).list();
    }

    public Car listById(Long id){
        return findById(id);
    }
}