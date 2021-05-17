package bryan.travelAPP.domain;

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
    // ESTE CODIGO A DE SER UNICO "ALC" de alicante
    private String code;
    // EL NOMBRE NO PUEDE SER NULO
    private String name;

    /**
     * Relacion uno a muchos (un aeropuerto) (muchos vuelos)
     * se hace la lista de que un aeropuerto tiene muchos vuelos de llegada
     */
    @OneToMany()
    @JoinColumn(name = "flight_id")
    List<Flight> flight_arrival;

    /**
     * Relacion uno a muchos (un aeropuerto) (muchos vuelos)
     * se hace la lista de que un aeropuerto tiene muchos vuelos de salida
     */
    @OneToMany()
    @JoinColumn(name = "flight_id")
    List<Flight> flight_departure;

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

    public List<Flight> getFlight_arrival() {
        return flight_arrival;
    }

    public void setFlight_arrival(List<Flight> flight_arrival) {
        this.flight_arrival = flight_arrival;
    }

    public List<Flight> getFlight_departure() {
        return flight_departure;
    }

    public void setFlight_departure(List<Flight> flight_departure) {
        this.flight_departure = flight_departure;
    }

}
