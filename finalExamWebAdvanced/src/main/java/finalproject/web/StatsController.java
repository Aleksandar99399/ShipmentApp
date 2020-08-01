package finalproject.web;

import finalproject.interceptors.service.StatService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class StatsController {

    private final StatService statService;

    public StatsController(StatService statService) {
        this.statService = statService;
    }

    @GetMapping("/stats")
    public String stats(Model model){
        model.addAttribute("requestCount",statService.getRequestCount());
        model.addAttribute("startedOn",statService.getStartedOn());
        return "statInter";
    }
}