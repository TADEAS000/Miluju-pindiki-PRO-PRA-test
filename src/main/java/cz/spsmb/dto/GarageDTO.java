package cz.spsmb.dto;

public class GarageDTO {
    String ulice;
    int cisloPopisne;
    String person;

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
