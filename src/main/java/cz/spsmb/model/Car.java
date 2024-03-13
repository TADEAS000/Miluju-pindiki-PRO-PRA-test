package cz.spsmb.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "car-tabulka-jak-sviň")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;
    String brand;
    String model;
    int yearOfManufacture;
    int price;

    @ManyToOne(fetch = FetchType.LAZY)
    Person person;

    public Car(){}

    public Car(String brand, String model, int yearOfManufacture, int price){
        this.brand = brand;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", price=" + price +
                '}';
    }
}