package ch.bfh.bti7081.s2020.green.protomed.presenter;

import ch.bfh.bti7081.s2020.green.protomed.management.ApplicationModelManager;
import ch.bfh.bti7081.s2020.green.protomed.model.*;
import ch.bfh.bti7081.s2020.green.protomed.view.protocol.ProtocolEditView;
import ch.bfh.bti7081.s2020.green.protomed.view.protocol.edit.ProtocolEditViewImplementation;
import ch.bfh.bti7081.s2020.green.protomed.view.protocol.main.ProtocolMainView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.notification.Notification;

public class ProtocolEditPresenter implements ProtocolEditView.ProtocolEditViewListener {
	private ProtocolEditViewImplementation view;
	private Protocol model;

	public ProtocolEditPresenter(ProtocolEditViewImplementation view, Protocol model) {
		System.out.println("--> ProtocolEditPresenter Testing | Received Protocol Model:");
		System.out.println(model);
		System.out.println(model.getServiceIds());
		this.view = view;
		this.model = model;
		view.addListener(this);
		view.loadProtocolData(model);

//		System.out.println(((BesuchProtocol) protMock).getServiceList());
	}

	@Override
	public void updateProtocol(Protocol protocol) {
		System.out.println(protocol);
		if (ApplicationModelManager.getInstance().saveProtocol(protocol)) {
			UI.getCurrent().navigate("protocols/" + protocol.getId());
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
		UI.getCurrent().navigate("protocols/" + protocol.getId());
	}

}
