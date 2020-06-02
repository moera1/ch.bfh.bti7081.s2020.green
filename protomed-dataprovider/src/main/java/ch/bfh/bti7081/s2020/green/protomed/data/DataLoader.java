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
        if (visitor.isPresent()) {
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
                .healthVisitorID(3)
                .firstname("Daniel")
                .name("Müller")
                .phoneNumber("+41891234567")
                .profilePicture("/images/profile/daniel.png")
                .insuredServices(services)
                .build());

        // Test client 02
        healthClients.add(HealthClient.builder()
                .address(addresses.get(1))
                .birthdate(LocalDate.of(1980, 5, 1))
                .clientID(BigInteger.valueOf(2))
                .healthVisitorID(1)
                .firstname("Thomas")
                .name("Berger")
                .phoneNumber("+41891234567")
                .profilePicture("/images/profile/thomas.png")
                .insuredServices(services)
                .build());

        // Test client 03
        healthClients.add(HealthClient.builder()
                .address(addresses.get(2))
                .birthdate(LocalDate.of(1960, 8, 8))
                .clientID(BigInteger.valueOf(3))
                .healthVisitorID(2)
                .firstname("Lars")
                .name("Imhof")
                .phoneNumber("+41891234567")
                .profilePicture("/images/profile/lars.png")
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
                .employeeID(BigInteger.valueOf(1))
                .firstname("Laura")
                .name("Meyer")
                .phoneNumber("+41891234567")
                .profilePicture("/images/profile/laura.png")
                .superVisorID(1)
                .build());

        // Test visitor 02
        healthVisitors.add(HealthVisitor.builder()
                .address(addresses.get(4))
                .birthdate(LocalDate.of(1950, 2, 15))
                .email("trudi.sigenthaler@bfh-test.ch")
                .password("1234")
                .employeeID(BigInteger.valueOf(2))
                .firstname("Gertrud")
                .name("Sigentaler")
                .phoneNumber("+41891234567")
                .profilePicture("/images/profile/gertrud.png")
                .build());

        // Test visitor 03
        healthVisitors.add(HealthVisitor.builder()
                .address(addresses.get(5))
                .birthdate(LocalDate.of(1970, 7, 12))
                .email("max.kummer@bfh-test.ch")
                .password("1234")
                .employeeID(BigInteger.valueOf(3))
                .firstname("Max")
                .name("Kummer")
                .phoneNumber("+41891234567")
                .profilePicture("/images/profile/max.png")
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
                new HealthService("Abklärung Pflegebedarf", "Lorem ipsum dolor sit amet."),
                new HealthService("Beratung zu Angeboten", "Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat."),
                new HealthService("Unterstützung Körperpflege", "Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat."),
                new HealthService("Unterstützung Mobilisation", "At vero eos et accusam et justo duo dolores et ea rebum."),
                new HealthService("Unterstützung Haushalt", "Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet."),
                new HealthService("Zubereitung Mahlzeit", "This is a test service"),
                new HealthService("Reinigung", "Lorem ipsum dolor sit amet, consetetur"),
                new HealthService("Schmerzbehandlung", " Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.")
        );
    }


}
