package bryan.travelAPP.controller;

import bryan.travelAPP.repository.FlightRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FlightController {
    private final FlightRepository flightRepository;

    public FlightController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @RequestMapping("/view/flights")
    public String getFlights(Model model) {
        model.addAttribute("flights", flightRepository.findAll());
        return "flight/listFlight";
    }
}
