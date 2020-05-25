package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.component.ProtocolForm;
import ch.bfh.bti7081.s2020.green.protomed.model.*;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

public class ProtocolEditViewImplementation extends VerticalLayout implements ProtocolEditView  {

	private List<ProtocolEditViewListener> listeners = new ArrayList<>();
	private ProtocolForm protocolForm;

	public ProtocolEditViewImplementation() {

		add(new H2("Protokoll bearbeiten"));

		protocolForm = new ProtocolForm(this);

		add(protocolForm);
		addClassName("protocol-container");

	}

	public List<ProtocolEditViewListener> getListeners(){
		return listeners;
	}
	
	@Override
	public void addListener(ProtocolEditViewListener listener) {
		listeners.add(listener);
	}

	@Override
	public void loadProtocolData(Protocol protocol) {
		protocolForm.loadProtocolData(protocol);
	}

}
