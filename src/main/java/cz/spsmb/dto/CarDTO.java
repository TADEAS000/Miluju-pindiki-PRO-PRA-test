package cz.spsmb.dto;

public class CarDTO {
    String brand;
    String model;
    String yearOfManufacture;
    String price;
    String person;

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

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", yearOfManufacture='" + yearOfManufacture + '\'' +
                ", price='" + price + '\'' +
                ", person='" + person + '\'' +
                '}';
    }
}
