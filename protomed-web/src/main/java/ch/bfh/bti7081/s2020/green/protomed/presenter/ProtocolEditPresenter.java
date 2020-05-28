package ch.bfh.bti7081.s2020.green.protomed.presenter;

import ch.bfh.bti7081.s2020.green.protomed.management.ApplicationModelManager;
import ch.bfh.bti7081.s2020.green.protomed.model.*;
import ch.bfh.bti7081.s2020.green.protomed.view.ProtocolEditView;
import ch.bfh.bti7081.s2020.green.protomed.view.ProtocolEditViewImplementation;
import ch.bfh.bti7081.s2020.green.protomed.view.ProtocolMainView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.notification.Notification;

public class ProtocolEditPresenter implements ProtocolEditView.ProtocolEditViewListener {
	private ProtocolEditViewImplementation view;
	private Protocol model;

	public ProtocolEditPresenter(ProtocolEditViewImplementation view, Protocol model) {
		this.view = view;
		this.model = model;
		view.addListener(this);
		view.loadProtocolData(model);
	}

	@Override
	public void updateProtocol(Protocol protocol) {
		if (ApplicationModelManager.getInstance().saveProtocol(protocol)) {
			UI.getCurrent().navigate("protocol/" + protocol.getId());
			Notification.show("Protokoll erfolgreich gespeichert");

		} else {
			Notification.show("Protokoll konnte nicht gespeichert werden");
		}

	}

	@Override
	public void deleteProtocol(Protocol protocol) {
		if (ApplicationModelManager.getInstance().deleteProtocol(protocol)) {
			UI.getCurrent().navigate(ProtocolMainView.class);
			Notification.show("Protokoll erfolgreich gelöscht");

		} else {
			Notification.show("Protokoll konnte nicht gelöscht werden");
		}

	}

	@Override
	public void cancel(Protocol protocol) {
		UI.getCurrent().navigate("protocol/" + protocol.getId());
	}

}
