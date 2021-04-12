package bryan.travelAPP.domain;

import org.apache.tomcat.jni.Address;

import javax.persistence.*;

@Entity
public class Seat {
    /**
     * Un asiento tiene un pasajero.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String number;
    private int aisle;

    /** Relacion uno a uno con pasajero{Passenger}*/
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passenger_id", referencedColumnName = "id")
    private Passenger passenger;

    /** constructor vacio y con atributos**/
    public Seat() {
    }

    public Seat(Integer id, String number, int aisle) {
        this.id = id;
        this.number = number;
        this.aisle = aisle;
    }

    /** getters y setters **/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getAisle() {
        return aisle;
    }

    public void setAisle(int aisle) {
        this.aisle = aisle;
    }
}