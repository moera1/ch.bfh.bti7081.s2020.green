package ch.bfh.bti7081.s2020.green.protomed.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;

import ch.bfh.bti7081.s2020.green.protomed.component.PersonContactCard;
import ch.bfh.bti7081.s2020.green.protomed.management.HealthClientManager;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthClient;

public class ClientProfileViewImplementation extends VerticalLayout implements ClientProfileView  {
	private List<ClientProfileViewListener> listeners = new ArrayList<ClientProfileViewListener>();
	private HealthClient client;
	private String clientName;
	
	public ClientProfileViewImplementation(HealthClient client) {
		this.client = client;
		
		Image photo = new Image();
		add(photo);
		
		add(new PersonContactCard(client));
		
		
	}
	
	@Override
	public void addListener(ClientProfileViewListener listener) {
		listeners.add(listener);
	}
	
	

}
