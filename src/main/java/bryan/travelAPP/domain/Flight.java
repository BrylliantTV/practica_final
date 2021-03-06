package bryan.travelAPP.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Time;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Flight {
    /**
     * Un vuelo tiene un aeropuerto de salida y de llegada.
     * Un vuelo tiene muchos pasajeros
     * Un vuelo tiene una aerolinea asociada
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String flightNumber;
    @Column(nullable = false)
    private Date departureDate;
    @Column(nullable = false)
    private Date arrivalDate;
    @Column(nullable = false)
    private Time departureTime;
    @Column(nullable = false)
    private Time arrivalTime;
    @Column(nullable = false)
    private int duration;
    @Column(nullable = false)
    private double price;

    /**
     * aeropuerto de origen
     */
    @ManyToOne
    @JoinColumn(name = "airport_arrival_id")
    private Airport airport_Arrival;

    /**
     * aeropuerto de destino
     */
    @ManyToOne
    @JoinColumn(name = "airport_departure_id")
    private Airport airport_Departure;
    /**
     * Relacion muchos a uno de vuelo{Flight} a aerolinea{Airline}
     */
    @ManyToOne
    @JoinColumn(name = "airline_id")
    private Airline airline;

    /**
     * Relacion uno a muchos de Flight{Flight} a Pasajeros{Passenger}
     */
    @OneToMany()
    @JoinColumn(name = "Flight_id", referencedColumnName = "id")
    private Set<Passenger> passengerSet = new HashSet<>();

    /**
     * CONSTRUCTORES
     */
    public Flight() {
    }

    public Flight(String flightNumber, Date departureDate, Date arrivalDate, Time departureTime, Time arrivalTime, int duration, double price) {
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.duration = duration;
        this.price = price;
    }

    /**
     * GETTERS & SETTERS
     **/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Set<Passenger> getPassengerSet() {
        return passengerSet;
    }

    public void setPassengerSet(Set<Passenger> passengerSet) {
        this.passengerSet = passengerSet;
    }

    public Airport getAirport_Arrival() {
        return airport_Arrival;
    }

    public void setAirport_Arrival(Airport airport_Arrival) {
        this.airport_Arrival = airport_Arrival;
    }

    public Airport getAirport_Departure() {
        return airport_Departure;
    }

    public void setAirport_Departure(Airport airport_Departure) {
        this.airport_Departure = airport_Departure;
    }
}
