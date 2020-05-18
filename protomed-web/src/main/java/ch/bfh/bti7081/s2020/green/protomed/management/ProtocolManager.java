package ch.bfh.bti7081.s2020.green.protomed.management;

import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

public class ProtocolManager {

    @Getter
    private List<Protocol> protocols;

    // Singleton
    private static ProtocolManager instance;

    public static ProtocolManager getInstance() {
        if (instance == null) {
            // lazy initialization
            instance = new ProtocolManager();
        }
        return instance;
    }

    private ProtocolManager() {
        protocols = PersistenceManager.getInstance().loadProtocols();
    }

    public List<Protocol> getProtocols() {
        return protocols;
    }

    public List<Protocol> getProtocolsByHealthClientID(int id) {
        return protocols.stream().filter(protocol -> protocol.getHealthClient().getPersonId() == id).collect(Collectors.toList());
    }

    public List<Protocol> getProtocolsByHealthVisitorID(int id) {
        return protocols.stream().filter(protocol -> protocol.getHealthVisitor().getPersonId() == id).collect(Collectors.toList());
    }

}
