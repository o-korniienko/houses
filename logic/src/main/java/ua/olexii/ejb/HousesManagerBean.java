package ua.olexii.ejb;

import ua.olexii.domain.Apartment;
import ua.olexii.domain.House;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

@Stateless
@LocalBean
public class HousesManagerBean {

    @PersistenceContext(unitName = "myExamplePU")
    private EntityManager entityManager;

    public House createHouse(String streetName) {
        House house = new House();
        house.setStreetName(streetName);
        entityManager.persist(house);
        return house;
    }

    public boolean addToHouse(Apartment apartment, long houseId ) {
        House house = entityManager.find(House.class, houseId);
        if (house == null) {
            return false;
        }
        house.getApartments().add(apartment);
        return true;
    }

    public List<Apartment> getApartmentsInHouse(long id) {
        House house = entityManager.find(House.class, id);
        if (house == null) {
            return Collections.emptyList();
        }
        return house.getApartments();
    }

    public List<House> getHouses() {
        TypedQuery<House> query = entityManager.createQuery("select c from House c", House.class);
        return query.getResultList();
    }


}
