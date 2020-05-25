package ch.bfh.bti7081.s2020.green.protomed.controller;

import ch.bfh.bti7081.s2020.green.protomed.data.DataLoader;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HealthServiceController {

    @Autowired
    private DataLoader data;

    @GetMapping("/api/healthservices")
    public List<HealthService> getHealthServices() {
        return data.getServices();
    }

}
