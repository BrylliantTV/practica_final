package bryan.travelAPP.domain;

import javax.persistence.*;

@Entity
public class Passenger {
    /**
     * un pasajero tiene un asiento(seat) y muchos pasajeros están en un vuelo (flight)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // dni unico y no nulo
    private String idNumber;
    // no nulo
    private String name;
    // no nulo
    private int age;
    private String email;
    // no puede ser nulo y solo puede tener dos valores, F/M
//    private char gender;
//    private enum Gender {
//        MALE, FEMALE
//    }

    /**
     * Relacion de un pasajero con un asiento
     */
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "seat_id")
    private Seat seat;

    /**
     * CONSTRUCTORES
     */
    public Passenger() {
    }

    public Passenger(String idNumber, String name, int age, String email) {
        this.idNumber = idNumber;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    /**
     * GETTERS & SETTERS
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

}
