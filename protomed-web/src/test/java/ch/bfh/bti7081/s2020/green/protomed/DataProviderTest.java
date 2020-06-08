package ch.bfh.bti7081.s2020.green.protomed;

import ch.bfh.bti7081.s2020.green.protomed.management.HealthClientManager;
import ch.bfh.bti7081.s2020.green.protomed.management.HealthServiceManager;
import ch.bfh.bti7081.s2020.green.protomed.management.HealthVisitorManager;
import ch.bfh.bti7081.s2020.green.protomed.management.KadexInitializer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataProviderTest {
    @BeforeAll
    static void setup() {
        new KadexInitializer();
    }

    @Test
    void initHealthClients(){
        assertEquals(3, HealthClientManager.getInstance().getHealthClients().size());
    }

    @Test
    void initHealthVisitors(){
        assertEquals(3, HealthVisitorManager.getInstance().getHealthVisitors().size());
    }

    @Test
    void initHealthServices(){
        assertEquals(8, HealthServiceManager.getInstance().getHealthServices().size());
    }
}
