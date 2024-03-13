package cz.spsmb.view;

import cz.spsmb.dao.CarRepository;
import cz.spsmb.model.Car;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;


import java.util.List;

@Named
@RequestScoped
public class CarTestView {

    @Inject
    CarRepository carRepository;


    List<Car> carList;
    String brand;
    String model;
    int yearOfManufacture;
    int price;

    @PostConstruct
    public void init() {
        carList = carRepository.listAll();
    }

    public CarRepository getCarRepository() {
        return carRepository;
    }

    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Transactional
    public void saveCar() {
        Car car = new Car(brand, model, yearOfManufacture, price);
        carRepository.persist(car);
        carList.add(car);
        System.out.println("Saved " + car);
    }
}
