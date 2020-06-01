package ch.bfh.bti7081.s2020.green.protomed.management;

import ch.bfh.bti7081.s2020.green.protomed.model.Configuration;
import lombok.Getter;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigurationManager {

    private static ConfigurationManager instance = null;

    public static final String FILENAME = "config.yaml";

    @Getter
    private Configuration configuration;

    public static ConfigurationManager getInstance() {
        if (ConfigurationManager.instance == null) {
            ConfigurationManager.instance = new ConfigurationManager();
        }
        return ConfigurationManager.instance;
    }

    public ConfigurationManager() {
    }

    public void loadConfigurations() {
        try (InputStream input = Files.newInputStream( Paths.get(ConfigurationManager.FILENAME) )) {
            configuration = new Yaml().loadAs( input, Configuration.class );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
