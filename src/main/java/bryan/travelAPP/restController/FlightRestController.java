package bryan.travelAPP.restController;

import bryan.travelAPP.domain.Airport;
import bryan.travelAPP.domain.Flight;
import bryan.travelAPP.repository.AirportRepository;
import bryan.travelAPP.repository.FlightRepository;
import bryan.travelAPP.restController.exception.FlightNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class FlightRestController {

    private final FlightRepository flightRepository;
    private final AirportRepository airportRepository;

    public FlightRestController(FlightRepository flightRepository, AirportRepository airportRepository) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
    }

    @GetMapping("/flight/flights")
    public List<Flight> getAll() {
        List<Flight> flights = (List<Flight>) flightRepository.findAll();
        if (flights.isEmpty()) {
            throw new FlightNotFoundException("No hay vuelos");
        }
        return flights;
    }

    @GetMapping("/flight/flightsOrderByPrice")
    public List<Flight> orderByPrice() {
        List<Flight> flights = flightRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
        if (flights.isEmpty()) {
            throw new FlightNotFoundException("No hay vuelos para ordenar por precio");
        }
        return flights;
    }
    @GetMapping("/flight/cheapest")
    public Flight showCheapestFlight () {
        List<Flight> flights = flightRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
        if (flights.isEmpty()) {
            throw new FlightNotFoundException("No hay vuelos para poder mostrar el vuelo más barato");
        }
        return flights.get(0);
    }

    //EJEMPLO PARA PROBAR http://localhost:8080/airports/Rayanair
    @GetMapping("/airports/location/{airline}")
    public List<Airport> listAirports (@PathVariable String airline) {
        List<Flight> flights = flightRepository.findByAirline_Name(airline);
        List<Airport> airports = new ArrayList<>();
        if (airline.isEmpty()) {
         throw new FlightNotFoundException("Error al indicar aerolinea" + airline);
        } else {
            for (int i = 0; i < flights.size(); i++) {
                airports.add(flights.get(i).getAirport_Arrival());
                airports.add(flights.get(i).getAirport_Departure());
            }
        }
        return airports;
    }

    @GetMapping("/flights/{nameAirline}")
    public List<Flight> listFlightsAirportAirlineIds (@PathVariable String nameAirline){
        List<Flight> flights = flightRepository.findByAirline_Name(nameAirline);
        List<Flight> flightList = new ArrayList<>();
        for (int i = 0; i < flights.size(); i++) {
            flightList.add(flights.get(i));
        }

        return flightList;
    }
//    @GetMapping("/flights/{nameAirline}/{codeAirport}")
//    public List<Flight> listFlightsAirportAirlineIds (@PathVariable String nameAirline, @PathVariable String codeAirport){
//        List<Flight> flights = flightRepository.findByAirline_Name(nameAirline);
//        List<Airport> airportList = airportRepository.findByCode(codeAirport);
//        List<Flight> flightList = new ArrayList<>();
//        for (int i = 0; i < flights.size(); i++) {
//            flightList.add(flights.get(i));
//        }
//        for (int i = 0; i < airportList.size(); i++) {
//            flightList.add((Flight) airportList.get(i).getFlights_arrival());
//            flightList.add((Flight) airportList.get(i).getFlights_departure());
//        }
//
//        return flightList;
//    }

    @GetMapping("/flights/occupation/{flightNumber}")
    public int seatsFlightNumber(@PathVariable String flightNumber){
        List<Flight> flights = flightRepository.findByFlightNumber(flightNumber);
        Set numeroPasajeros = null;
        for (int i = 0; i < flights.size(); i++) {
            numeroPasajeros = flights.get(i).getPassengerSet();
        }
        int total_seats = numeroPasajeros.size();
        return total_seats;
    }
    @GetMapping("/flights/date/{fecha}")
    public List<Flight> findByDepartureDateAndArrivalDateEquals(@PathVariable String fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.parse(fecha, formatter);
        List<Flight> departureFlights = flightRepository.findByDepartureDateEquals(Timestamp.valueOf(date));
        List<Flight> arrivalFlights = flightRepository.findByArrivalDateEquals(Timestamp.valueOf(date));
        List<Flight> totalFlights = new ArrayList<>();
        for (int i = 0; i < departureFlights.size(); i++) {
            totalFlights.add(departureFlights.get(i));
        }
        for (int i = 0; i < arrivalFlights.size(); i++) {
            totalFlights.add(arrivalFlights.get(i));
        }
        return totalFlights;
    }
}
