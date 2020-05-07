package ch.bfh.bti7081.s2020.green.protomed.controller;

import ch.bfh.bti7081.s2020.green.protomed.data.DataLoader;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HealthVisitorController {

    @Autowired
    private DataLoader data;

    @GetMapping("/api/healthvisitors")
    public List<HealthVisitor> getHealthVisitors() {
        return data.getHealthVisitors();
    }

    @GetMapping("/api/healthvisitor")
    public HealthVisitor getHealthVisitor(@RequestParam(value = "id", defaultValue = "0") String id) {
        return data.getHealthVisitors().get(Integer.parseInt(id));
    }

}
