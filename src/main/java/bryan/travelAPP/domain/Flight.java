package bryan.travelAPP.domain;

import javax.persistence.*;
import java.sql.Time;
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
    // 2 LETRAS + 4 NUMEROS Y ES UNICO, EJEMPLO : IB7340
    /**
     * NINGUNO DE ESTOS VALORES PUEDE SER NULO A LA HORA DE AÑADIR UN VUELO
     */
    private String flightNumber;
    private Date departureDate;
    private Date arrivalDate;
    private Time departureTime;
    private Time arrivalTime;
    private int duration;
    private double price;

    /**
     * aeropuerto de origen
     */
    @ManyToOne
    @JoinColumn(name = "aiport_id")
    private Airport airport_Arrival;

    /**
     * aeropuerto de destino
     */
    @ManyToOne
    @JoinColumn(name = "aiport_id")
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
    @JoinColumn(name = "Passenger_id")
    private Set<Passenger> passengerSet = new HashSet<>();

    /**
     * CONSTRUCTORES
     */
    public Flight() {
    }

    public Flight(String flightNumber, Date departureDate, Date arrivalDate, Time departureTime, Time arrivalTime, int duration, double price, Airline airline) {
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.duration = duration;
        this.price = price;
        this.airline = airline;
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
