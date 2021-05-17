package bryan.travelAPP.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Airline {
    /**
     * Una aerolinea tiene muchos vuelos (flights)
     */
    // en el diagrama no se ve que tiene un id, pero luego en un archivo con valores para introducir de prueba, tiene id autoincrementable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // nombre UNICO
    private String name;

    /** Relacion - Una aerolinea{Airline} tiene muchos vuelos(Flight)*/
    @OneToMany()
    @JoinColumn(name = "Flight_id")
    private Set<Flight> flightSet = new HashSet<>();

    /**
     * CONSTRUCTORES
     */
    public Airline() {
    }

    public Airline(String name) {
        this.name = name;
    }

    public Airline(String name, Set<Flight> flightSet) {
        this.name = name;
        this.flightSet = flightSet;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Flight> getFlightSet() {
        return flightSet;
    }

    public void setFlightSet(Set<Flight> flightSet) {
        this.flightSet = flightSet;
    }

}
