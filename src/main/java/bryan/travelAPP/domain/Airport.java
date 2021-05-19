package bryan.travelAPP.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Airport {
    /**
     * Un aeropuerto tiene muchos vuelos (flights)
     * - tiene muchos vuelos de salida (departureDate) origen
     * - Tiene muchos vuelos de entrada (arrivalDate) destination
     * los vuelos tiene una fecha y una hora de llegada y una fecha y una hora de salida
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String code;
    @Column(nullable = false)
    private String name;

    /**
     * Relacion uno a muchos (un aeropuerto) (muchos vuelos)
     * se hace la lista de que un aeropuerto tiene muchos vuelos de llegada
     */
    @OneToMany(mappedBy = "airport_Arrival")
    @JsonIgnore
    List<Flight> flights_arrival;

    /**
     * Relacion uno a muchos (un aeropuerto) (muchos vuelos)
     * se hace la lista de que un aeropuerto tiene muchos vuelos de salida
     */
    @OneToMany(mappedBy = "airport_Departure")
    @JsonIgnore
    List<Flight> flights_departure;

    /**
     * constructor vacio y con atributos
     **/
    public Airport() {
    }

    public Airport(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * getters y setters
     **/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Flight> getFlights_arrival() {
        return flights_arrival;
    }

    public void setFlights_arrival(List<Flight> flights_arrival) {
        this.flights_arrival = flights_arrival;
    }

    public List<Flight> getFlights_departure() {
        return flights_departure;
    }

    public void setFlights_departure(List<Flight> flights_departure) {
        this.flights_departure = flights_departure;
    }

}
