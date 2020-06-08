package ch.bfh.bti7081.s2020.green.protomed.presenter;

import ch.bfh.bti7081.s2020.green.protomed.management.ApplicationModelManager;
import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;
import ch.bfh.bti7081.s2020.green.protomed.view.ProtocolCreateView;
import ch.bfh.bti7081.s2020.green.protomed.view.ProtocolCreateViewImplementation;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.notification.Notification;

public class ProtocolCreatePresenter implements ProtocolCreateView.ProtocolCreateViewListener {

    public ProtocolCreatePresenter(ProtocolCreateViewImplementation view, Protocol model) {
        view.addListener(this);
        view.loadProtocolData(model);
    }

    @Override
    public void save(Protocol protocol) {
        if (ApplicationModelManager.getInstance().createProtocol(protocol)) {
            UI.getCurrent().navigate("protocol/" + protocol.getId());
            Notification.show("Protokoll erfolgreich gespeichert");
        } else {
            Notification.show("Protokoll konnte nicht gespeichert werden");
        }
    }

    @Override
    public void cancel(Protocol protocol) {
        UI.getCurrent().navigate("protocol/" + protocol.getId());
    }
}
