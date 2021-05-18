package bryan.travelAPP.controller;

import bryan.travelAPP.repository.PassengerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PassengerController {
    private final PassengerRepository passengerRepository;

    public PassengerController(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @RequestMapping("/view/passengers")
    public String getPassenger(Model model) {
        model.addAttribute("passengers", passengerRepository.findAll());
        return "passenger/listpassenger";
    }
}
