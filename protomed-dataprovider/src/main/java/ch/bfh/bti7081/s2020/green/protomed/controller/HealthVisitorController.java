package ch.bfh.bti7081.s2020.green.protomed.controller;

import ch.bfh.bti7081.s2020.green.protomed.data.DataLoader;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class HealthVisitorController {

    @Autowired
    private DataLoader data;

    @GetMapping("/api/healthvisitors")
    public ResponseEntity<List<HealthVisitor>> getHealthVisitors() {
        return new ResponseEntity<>(data.getHealthVisitors(), HttpStatus.OK);
    }

    @GetMapping("/api/healthvisitor")
    public ResponseEntity<HealthVisitor> getHealthVisitor(@RequestParam(value = "id", defaultValue = "0") String id) {
        return new ResponseEntity<>(data.getHealthVisitors().get(Integer.parseInt(id)), HttpStatus.OK);
    }

    @GetMapping("/api/auth")
    public ResponseEntity<HealthVisitor> authHealthVisitor(@RequestParam(value = "email") String requestEmail, @RequestParam(value = "password") String requestPassword) {
        Optional<HealthVisitor> healthVisitor = data.getHealthVisitorByEMailOrEmpty(requestEmail);
        if(healthVisitor.isPresent() && healthVisitor.get().getPassword().equals(requestPassword)){
            return new ResponseEntity<>(healthVisitor.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }

}
