package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.management.ApplicationModelManager;
import ch.bfh.bti7081.s2020.green.protomed.management.HealthVisitorManager;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthClient;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthVisitor;
import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;
import com.vaadin.flow.component.UI;

import java.util.ArrayList;
import java.util.List;

public class ProtocolPresenter implements ProtocolView.ProtocolViewListener {
    private ProtocolView view;
    private List<Protocol> protocols;
    private HealthVisitor currentUser;

    public ProtocolPresenter(ProtocolViewImplementation view) {
        this.view = view;
        view.addListener(this);
        currentUser = HealthVisitorManager.getInstance().getCurrentUser();
        protocols = ApplicationModelManager.getInstance().getProtocolsByHealthVisitorID(currentUser.getPersonId());
        view.updateProtocolList(protocols);
        view.loadCreateProtocolViewFromProtocol();
    }

    @Override
    public void selectProtocol(Protocol protocol) {
        view.navigateToProtocol(protocol.getId());
    }

    @Override
    public void setSearchValue(String value) {
        List<Protocol> filteredProtocols = new ArrayList<>();
        for (Protocol protocol : protocols) {
            if (protocol.getHealthClient().toString().toLowerCase().contains(value.toLowerCase())) {
                filteredProtocols.add(protocol);
            }
        }
        view.updateProtocolList(filteredProtocols);
    }

    @Override
    public void filterByHealthClient(HealthClient client) {
        protocols = ApplicationModelManager.getInstance().getProtocolsByHealthVisitorIDAndHealthClientID(currentUser.getPersonId(), client.getPersonId());
        view.updateProtocolList(protocols);
    }

    @Override
    public void navigateToProtocolCreateView() {
        UI.getCurrent().navigate("protocol-create/1");
    }
}
