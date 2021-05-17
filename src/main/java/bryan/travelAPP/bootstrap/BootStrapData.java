package bryan.travelAPP.bootstrap;

import bryan.travelAPP.domain.Airline;
import bryan.travelAPP.domain.Airport;
import bryan.travelAPP.repository.AirlineRepository;
import bryan.travelAPP.repository.AirportRepository;
import org.springframework.boot.CommandLineRunner;

public class BootStrapData implements CommandLineRunner {
    private final AirlineRepository airlineRepository;
    private final AirportRepository airportRepository;

    public BootStrapData(AirlineRepository airlineRepository, AirportRepository airportRepository) {
        this.airlineRepository = airlineRepository;
        this.airportRepository = airportRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Airline airline = new Airline("Ryanair");
        Airline airline1 = new Airline("Vueling");
        Airline airline2 = new Airline("KLM");
        Airline airline3 = new Airline("Iberia");
        Airline airline4 = new Airline("Qatar Airways");
        Airline airline5 = new Airline("Air Canada");
        Airline airline6 = new Airline("Emirates");
        Airline airline7 = new Airline("TAP Portugal");
        Airline airline8 = new Airline("AirEuropa");
        Airline airline9 = new Airline("EasyJet");

        Airport airport = new Airport("ALC", "El Altet Airport");
        Airport airport1 = new Airport("BCN", "El Prat Airport");
        Airport airport29 = new Airport("MAD", "Barajar Airport");
        Airport airport2 = new Airport("IBZ", "Ibiza Airport");
        Airport airport3 = new Airport("AGP", "Malaga Airport");
        Airport airport4 = new Airport("LHR", "Heathrow Airport");
        Airport airport5 = new Airport("CDG", "Charles de Gaulle Airport");
        Airport airport6 = new Airport("AMS", "Amsterdam Airport");
        Airport airport7 = new Airport("FRA", "Frankfurt Airport");
        Airport airport8 = new Airport("SIN", "Singapore Changi Airport");
        Airport airport9 = new Airport("SFO", "San Francisco International Airport");
        Airport airport10 = new Airport("YYZ", "Toronto Pearson Airport");
        Airport airport11 = new Airport("MEX", "Benito Suarez International Airport");
        Airport airport12 = new Airport("LGW", "London Gatwick Airport");
        Airport airport13 = new Airport("HND", "Tokyo Haneda Airport");
        Airport airport14 = new Airport("DXB", "Dubai International Airport");
        Airport airport15 = new Airport("BRU", "Brussels Airport");
        Airport airport16 = new Airport("SOF", "Sofia Airport");
        Airport airport17 = new Airport("ORY", "Paris Orly Airport");
        Airport airport18 = new Airport("BER", "Berlin Brandenburg Airport");
        Airport airport19 = new Airport("MUC", "Munich Airport");
        Airport airport20 = new Airport("BUD", "Budapest Airport");
        Airport airport21 = new Airport("DUB", "Dublin Airport");
        Airport airport22 = new Airport("NAP", "Naples Airport");
        Airport airport23 = new Airport("VCE", "Venice Airport");
        Airport airport24 = new Airport("MLA", "Malta Airport");
        Airport airport25 = new Airport("LIS", "Lisbos Airport");
        Airport airport26 = new Airport("OPO", "Porto Airport");
        Airport airport27 = new Airport("ZRH", "Zurich Airport");
        Airport airport28 = new Airport("IST", "Istanbul Airport");



        airlineRepository.save(airline);
        airlineRepository.save(airline1);
        airlineRepository.save(airline2);
        airlineRepository.save(airline3);
        airlineRepository.save(airline4);
        airlineRepository.save(airline5);
        airlineRepository.save(airline6);
        airlineRepository.save(airline7);
        airlineRepository.save(airline8);
        airlineRepository.save(airline9);

        airportRepository.save(airport);
        airportRepository.save(airport1);
        airportRepository.save(airport2);
        airportRepository.save(airport3);
        airportRepository.save(airport4);
        airportRepository.save(airport5);
        airportRepository.save(airport6);
        airportRepository.save(airport7);
        airportRepository.save(airport8);
        airportRepository.save(airport9);
        airportRepository.save(airport10);
        airportRepository.save(airport11);
        airportRepository.save(airport12);
        airportRepository.save(airport13);
        airportRepository.save(airport14);
        airportRepository.save(airport15);
        airportRepository.save(airport16);
        airportRepository.save(airport17);
        airportRepository.save(airport18);
        airportRepository.save(airport19);
        airportRepository.save(airport20);
        airportRepository.save(airport21);
        airportRepository.save(airport22);
        airportRepository.save(airport23);
        airportRepository.save(airport24);
        airportRepository.save(airport25);
        airportRepository.save(airport26);
        airportRepository.save(airport27);
        airportRepository.save(airport28);
        airportRepository.save(airport29);

        System.out.println("Numero de aerolineas: " + airlineRepository.count());
        System.out.println("Numero de aeropuertos: " + airportRepository.count());
    }
}
