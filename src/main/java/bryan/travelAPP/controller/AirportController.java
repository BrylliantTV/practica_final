package bryan.travelAPP.controller;

import bryan.travelAPP.repository.AirportRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AirportController {
    private final AirportRepository airportRepository;

    public AirportController(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @RequestMapping("/view/airports")
    public String getAirports(Model model) {
        model.addAttribute("airports", airportRepository.findAll());
        return "airport/listAirport";
    }
}
