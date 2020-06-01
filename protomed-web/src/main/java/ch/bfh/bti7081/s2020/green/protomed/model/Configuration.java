package ch.bfh.bti7081.s2020.green.protomed.model;

import ch.bfh.bti7081.s2020.green.protomed.management.PersistenceManager;

public class Configuration {

    private String version;

    private String kSqliteUrl;
    private String kMemoryUrl;
    private PersistenceManager.PersistenceStrategy strategy;

    private String healthClientProviderUrl;
    private String healthClientProviderEndpoint;

    private String healthServiceProviderUrl;
    private String healthServiceProviderEndpoint;

    private String healthVisitorProviderUrl;
    private String healthVisitorProviderEndpoint;
    private String healthVisitorAuthEndpoint;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getkSqliteUrl() {
        return kSqliteUrl;
    }

    public void setkSqliteUrl(String kSqliteUrl) {
        this.kSqliteUrl = kSqliteUrl;
    }

    public String getkMemoryUrl() {
        return kMemoryUrl;
    }

    public void setkMemoryUrl(String kMemoryUrl) {
        this.kMemoryUrl = kMemoryUrl;
    }

    public PersistenceManager.PersistenceStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(PersistenceManager.PersistenceStrategy strategy) {
        this.strategy = strategy;
    }

    public String getHealthClientProviderUrl() {
        return healthClientProviderUrl;
    }

    public void setHealthClientProviderUrl(String healthClientProviderUrl) {
        this.healthClientProviderUrl = healthClientProviderUrl;
    }

    public String getHealthClientProviderEndpoint() {
        return healthClientProviderEndpoint;
    }

    public void setHealthClientProviderEndpoint(String healthClientProviderEndpoint) {
        this.healthClientProviderEndpoint = healthClientProviderEndpoint;
    }

    public String getHealthServiceProviderUrl() {
        return healthServiceProviderUrl;
    }

    public void setHealthServiceProviderUrl(String healthServiceProviderUrl) {
        this.healthServiceProviderUrl = healthServiceProviderUrl;
    }

    public String getHealthServiceProviderEndpoint() {
        return healthServiceProviderEndpoint;
    }

    public void setHealthServiceProviderEndpoint(String healthServiceProviderEndpoint) {
        this.healthServiceProviderEndpoint = healthServiceProviderEndpoint;
    }

    public String getHealthVisitorProviderUrl() {
        return healthVisitorProviderUrl;
    }

    public void setHealthVisitorProviderUrl(String healthVisitorProviderUrl) {
        this.healthVisitorProviderUrl = healthVisitorProviderUrl;
    }

    public String getHealthVisitorProviderEndpoint() {
        return healthVisitorProviderEndpoint;
    }

    public void setHealthVisitorProviderEndpoint(String healthVisitorProviderEndpoint) {
        this.healthVisitorProviderEndpoint = healthVisitorProviderEndpoint;
    }

    public String getHealthVisitorAuthEndpoint() {
        return healthVisitorAuthEndpoint;
    }

    public void setHealthVisitorAuthEndpoint(String healthVisitorAuthEndpoint) {
        this.healthVisitorAuthEndpoint = healthVisitorAuthEndpoint;
    }

}
