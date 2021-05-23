package bryan.travelAPP.repository;

import bryan.travelAPP.domain.Flight;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;

public interface FlightRepository extends CrudRepository<Flight, Integer> {
    List<Flight> findAll(Sort sort);
    List<Flight> findByAirline_Name (String nameAirline);
    List<Flight> findByFlightNumber(String flightNumber);
    List<Flight> findByDepartureDateEquals(Timestamp departureDate);
    List<Flight> findByArrivalDateEquals(Timestamp arrivalDate);
    //List<Flight> findByAirport_Departure_Code(String codeAirportDeparture);
}
