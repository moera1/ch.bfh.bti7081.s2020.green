package ch.bfh.bti7081.s2020.green.protomed.controller;

import ch.bfh.bti7081.s2020.green.protomed.model.Adress;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthVisitor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.time.LocalDate;

@RestController
public class HealthVisitorController {

    @GetMapping("/api/healthVisitor")
    public HealthVisitor getHealthVisitor(@RequestParam(value = "id", defaultValue = "1") String id) {
        Adress adress = new Adress("Bahnhofstrasse 1", "Biel", "2502", "Switzerland");
        return HealthVisitor.builder()
                .adress(adress)
                .birthdate(LocalDate.of(1995, 04, 28))
                .email("yannis@biasutti.ch")
                .employeeID(BigInteger.ONE)
                .firstname("Yannis")
                .name("Biasutti")
                .phoneNumber("+41891234567")
                .isSupervisor(false)
                .build();
    }

}
