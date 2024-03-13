package cz.spsmb.dto;

public class GarageDTO {
    String ulice;
    String cisloPopisne;
    String person;

    public String getUlice() {
        return ulice;
    }

    public void setUlice(String ulice) {
        this.ulice = ulice;
    }

    public String getCisloPopisne() {
        return cisloPopisne;
    }

    public void setCisloPopisne(String cisloPopisne) {
        this.cisloPopisne = cisloPopisne;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "GarageDTO{" +
                "ulice='" + ulice + '\'' +
                ", cisloPopisne='" + cisloPopisne + '\'' +
                ", person='" + person + '\'' +
                '}';
    }
}
