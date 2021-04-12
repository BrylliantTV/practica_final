package bryan.travelAPP.bootstrap;

import bryan.travelAPP.domain.Airline;
import bryan.travelAPP.repository.AirlineRepository;
import org.springframework.boot.CommandLineRunner;

public class BootStrapData implements CommandLineRunner {
    private final AirlineRepository airlineRepository;

    public BootStrapData(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
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

    }
}
