package bryan.travelAPP.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Airline {
    /**
     * Una aerolinea tiene muchos vuelos (flights)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String name;

    /** Relacion - Una aerolinea{Airline} tiene muchos vuelos(Flight)*/
    @OneToMany()
    @JoinColumn(name = "Airline_id")
    @JsonIgnore
    private Set<Flight> flightsSet = new HashSet<>();

    /**
     * CONSTRUCTORES
     */
    public Airline() {
    }

    public Airline(String name) {
        this.name = name;
    }

    public Airline(String name, Set<Flight> flightsSet) {
        this.name = name;
        this.flightsSet = flightsSet;
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

    public Set<Flight> getFlightsSet() {
        return flightsSet;
    }

    public void setFlightsSet(Set<Flight> flightsSet) {
        this.flightsSet = flightsSet;
    }

}
