package cz.spsmb.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "garage_pyčo")
public class Garage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;
    String ulice;
    int cisloPopisne;

    @OneToOne(mappedBy = "garage")
    Person person;

    public Garage(){}

    public Garage(String ulice, int cisloPopisne) {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Garage{" +
                "id=" + id +
                ", ulice='" + ulice + '\'' +
                ", cisloPopisne=" + cisloPopisne +
                '}';
    }
}