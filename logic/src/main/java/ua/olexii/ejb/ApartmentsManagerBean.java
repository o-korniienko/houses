package ua.olexii.ejb;

import ua.olexii.domain.Apartment;
import ua.olexii.domain.House;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class ApartmentsManagerBean {

    @PersistenceContext(unitName = "myExamplePU")
    private EntityManager entityManager;

    public Apartment creatApartment(String owner, int apartmentNumber, int area, int floor, int numberOfRooms, House house){
        Apartment apartment = new Apartment();
        apartment.setApartmentNumber(apartmentNumber);
        apartment.setArea(area);
        apartment.setFloor(floor);
        apartment.setOwner(owner);
        apartment.setNumberOfRooms(numberOfRooms);
        apartment.setHouse(house);
        entityManager.persist(apartment);

        return apartment;
    }

    public List<Apartment> getApartments(){
        TypedQuery<Apartment> query = entityManager.createQuery("select c from Apartment c", Apartment.class);
        return query.getResultList();
    }
}
