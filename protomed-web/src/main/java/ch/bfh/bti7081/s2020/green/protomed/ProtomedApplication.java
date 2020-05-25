package ch.bfh.bti7081.s2020.green.protomed;

import ch.bfh.bti7081.s2020.green.protomed.management.KadexInitializer;
import com.vaadin.flow.component.dependency.CssImport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
@CssImport("./styles/global.css")
@CssImport("./styles/components.css")
@CssImport("./styles/layout.css")
public class ProtomedApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProtomedApplication.class, args);
        initializeApplication();
    }

    private static void initializeApplication() {
        new KadexInitializer();
    }

}
