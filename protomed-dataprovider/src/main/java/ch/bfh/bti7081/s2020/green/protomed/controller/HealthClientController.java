package ch.bfh.bti7081.s2020.green.protomed.controller;

import ch.bfh.bti7081.s2020.green.protomed.data.DataLoader;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HealthClientController {

    @Autowired
    private DataLoader data;

    @GetMapping("/api/healthclients")
    public List<HealthClient> getHealthClients() {
        return data.getHealthClients();
    }

    @GetMapping("/api/healthclient")
    public HealthClient getHealthClient(@RequestParam(value = "id", defaultValue = "0") String id) {
        return data.getHealthClients().get(Integer.parseInt(id));
    }

}
