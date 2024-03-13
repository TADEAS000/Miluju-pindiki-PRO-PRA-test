package cz.spsmb.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "test-person-table")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "default_id")
    long id;
    String name;
    int age;

    @OneToMany(mappedBy = "person")
    List<Car> car;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "garage_id", referencedColumnName = "id")
    Garage garage;

    public Person(){}

    public Person(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
