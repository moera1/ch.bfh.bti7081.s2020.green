package ch.bfh.bti7081.s2020.green.protomed.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;

import ch.bfh.bti7081.s2020.green.protomed.model.HealthClient;

public class ClientProfileViewImplementation extends VerticalLayout implements ClientProfileView, HasUrlParameter<String>  {
	private List<ClientProfileViewListener> listeners = new ArrayList<ClientProfileViewListener>();
	private HealthClient client;
	
	public ClientProfileViewImplementation() {
		add(new H2("Klient"));
	}
	
	@Override
	public void addListener(ClientProfileViewListener listener) {
		listeners.add(listener);
	}
	
	@Override
	public void setParameter(BeforeEvent event, String parameter) {
		// TODO Get the client
		
	}

}
