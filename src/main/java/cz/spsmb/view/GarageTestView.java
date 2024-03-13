package cz.spsmb.view;

import cz.spsmb.dao.GarageRepository;
import cz.spsmb.model.Car;
import cz.spsmb.model.Garage;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;

import java.util.List;

@Named
@RequestScoped
public class GarageTestView {
    @Inject
    GarageRepository garageRepository;


    List<Garage> garageList;
    String ulice;
    int cisloPopisne;

    public GarageRepository getGarageRepository() {
        return garageRepository;
    }

    public void setGarageRepository(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    public List<Garage> getGarageList() {
        return garageList;
    }

    public void setGarageList(List<Garage> garageList) {
        this.garageList = garageList;
    }

    public String getUlice() {
        return ulice;
    }

    public void setUlice(String ulice) {
        this.ulice = ulice;
    }

    public int getCisloPopisne() {
        return cisloPopisne;
    }

    public void setCisloPopisne(int cisloPopisne) {
        this.cisloPopisne = cisloPopisne;
    }

    @Transactional
    public void saveGarage() {
        Garage garage = new Garage(ulice, cisloPopisne);
        garageRepository.persist(garage);
        garageList.add(garage);
        System.out.println("Saved " + garage);
    }
}
