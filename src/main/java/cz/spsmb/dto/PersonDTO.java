package cz.spsmb.dto;

public class PersonDTO {

    String name;
    int age;
    String garage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGarage() {
        return garage;
    }

    public void setGarage(String garage) {
        this.garage = garage;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", garage='" + garage + '\'' +
                '}';
    }
}
