package ch.bfh.bti7081.s2020.green.protomed.data;

import ch.bfh.bti7081.s2020.green.protomed.model.Address;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthClient;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthService;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthVisitor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Getter
@Component
public class DataLoader {

    private List<HealthVisitor> healthVisitors;
    private List<HealthClient> healthClients;

    private List<Address> addresses;
    private List<HealthService> services;

    @Autowired
    public DataLoader() {
        this.healthClients = new ArrayList<>();
        this.healthVisitors = new ArrayList<>();
        initAdresses();
        initServices();
        loadHealthClients();
        loadHealthVisitors();
    }

    public Optional<HealthVisitor> getHealthVisitorByEMailOrEmpty(String email) {
        Optional<HealthVisitor> visitor = healthVisitors.stream().filter(healthVisitor -> healthVisitor.getEmail().equals(email)).findFirst();
        if(visitor.isPresent()) {
            return visitor;
        }
        return Optional.empty();
    }

    private void loadHealthClients() {
        // Test client 01
        healthClients.add(HealthClient.builder()
                .address(addresses.get(0))
                .birthdate(LocalDate.of(1995, 4, 28))
                .clientID(BigInteger.valueOf(1))
                .healthVisitorID(2)
                .firstname("Daniel")
                .name("Müller")
                .phoneNumber("+41891234567")
                .insuredServices(services)
                .build());

        // Test client 02
        healthClients.add(HealthClient.builder()
                .address(addresses.get(1))
                .birthdate(LocalDate.of(1980, 5, 1))
                .clientID(BigInteger.valueOf(2))
                .healthVisitorID(3)
                .firstname("Thomas")
                .name("Berger")
                .phoneNumber("+41891234567")
                .insuredServices(services)
                .build());

        // Test client 03
        healthClients.add(HealthClient.builder()
                .address(addresses.get(2))
                .birthdate(LocalDate.of(1960, 8, 8))
                .clientID(BigInteger.valueOf(3))
                .healthVisitorID(1)
                .firstname("Lars")
                .name("Imhof")
                .phoneNumber("+41891234567")
                .insuredServices(services)
                .build());

    }

    private void loadHealthVisitors() {
        // Test visitor 01
        healthVisitors.add(HealthVisitor.builder()
                .address(addresses.get(3))
                .birthdate(LocalDate.of(1992, 7, 27))
                .email("laura.meyer@bfh-test.ch")
                .password("1234")
                .employeeID(BigInteger.valueOf(0))
                .firstname("Laura")
                .name("Meyer")
                .phoneNumber("+41891234567")
                .superVisorID(1)
                .build());

        // Test visitor 02
        healthVisitors.add(HealthVisitor.builder()
                .address(addresses.get(4))
                .birthdate(LocalDate.of(1950, 2, 15))
                .email("trudi@bfh-test.ch")
                .password("1234")
                .employeeID(BigInteger.valueOf(1))
                .firstname("Gertrud")
                .name("Sigentaler")
                .phoneNumber("+41891234567")
                .build());

        // Test visitor 03
        healthVisitors.add(HealthVisitor.builder()
                .address(addresses.get(5))
                .birthdate(LocalDate.of(1970, 7, 12))
                .email("max.kummer@bfh-test.ch")
                .password("1234")
                .employeeID(BigInteger.valueOf(2))
                .firstname("Max")
                .name("Kummer")
                .phoneNumber("+41891234567")
                .build());
    }

    private void initAdresses() {
        addresses = Arrays.asList(
                new Address("Bahnhofstrasse 1", "Biel", "2502", "Switzerland"),
                new Address("Bahnhofstrasse 2", "Biel", "2502", "Switzerland"),
                new Address("Nidaugasse 1", "Biel", "2502", "Switzerland"),
                new Address("Bahnhofplatz 7", "Biel", "2501", "Switzerland"),
                new Address("Brünnenstrasse 10", "Bern", "3008", "Switzerland"),
                new Address("Bahnhofstrasse 2", "Bern", "3012", "Switzerland")
        );
    }

    private void initServices() {
        services = Arrays.asList(
                new HealthService("service-01", "This is a test service"),
                new HealthService("service-02", "This is a test service"),
                new HealthService("service-03", "This is a test service")
        );
    }



}
