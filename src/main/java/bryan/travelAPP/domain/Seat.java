package bryan.travelAPP.domain;

import javax.persistence.*;

@Entity
public class Seat {
    /**
     * Un asiento tiene un pasajero.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String number;
    private int aisle;

    /** constructor vacio y con atributos**/
    public Seat() {
    }

    public Seat(String number, int aisle) {
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