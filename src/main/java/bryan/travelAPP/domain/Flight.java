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
    private Long id;
    private String flightNumber;
    private Date departureDate;
    private Date arrivalDate;
    private Time departureTime;
    private Time arrivalTime;
    private int duration;
    private double price;

    /** Relacion muchos a uno de vuelo{Fligh} a aerolinea{Airline}*/
    @ManyToOne
    private Airline airline;

    /** Relacion uno a muchos de Flight{Flight} a Pasajeros{Passenger}*/
    @OneToMany()
    @JoinColumn(name = "Pasenger_id")
    private Set<Passenger> passengerSet = new HashSet<>();

    /** constructor vacio y con atributos**/
    public Flight() {
    }

    public Flight(String flightNumber, Date departureDate, Date arrivalDate, Time departureTime, Time arrivalTime, int duration, double price, Airline airline) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.duration = duration;
        this.price = price;
        this.airline = airline;
    }

    /** getters y setters **/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightNumber='" + flightNumber + '\'' +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", duration=" + duration +
                ", price=" + price +
                ", airline=" + airline +
                ", passengerSet=" + passengerSet +
                '}';
    }
}
