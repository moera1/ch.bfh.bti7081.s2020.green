package ch.bfh.bti7081.s2020.green.protomed.controller;

import ch.bfh.bti7081.s2020.green.protomed.model.Adress;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthClient;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HealthClientController {

    @GetMapping("/api/healthClient")
    public HealthClient getHealthClient(@RequestParam(value = "id", defaultValue = "1") String id) {
        Adress adress = new Adress("Bahnhofstrasse 2", "Biel", "2502", "Switzerland");
        HealthService healthService = new HealthService("service-01", "This is a test service");
        List<HealthService> healthServiceList = new ArrayList<HealthService>();
        healthServiceList.add(healthService);
        return HealthClient.builder()
                .adress(adress)
                .birthdate(LocalDate.of(1995, 04, 28))
                .clientID(BigInteger.ONE)
                .firstname("Yannis")
                .name("Biasutti")
                .phoneNumber("+41891234567")
                .insuredServices(healthServiceList)
                .build();
    }

}
