package bryan.travelAPP.controller;

import bryan.travelAPP.repository.AirlineRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class AirlineController {
    private final AirlineRepository airlineRepository;

    public AirlineController(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    @GetMapping("/")
    public String showIndex(Model model) {
        return "index";
    }

    @RequestMapping("/view/airlines")
    public String getAirlines(Model model) {
        model.addAttribute("airlines", airlineRepository.findAll());
        return "airline/listAirline";
    }

}
