package ua.olexii.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "house")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String streetName;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "house")
    private List<Apartment> apartments;

    public House() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", streetName='" + streetName + '\'' +
                '}';
    }
}
