package ch.bfh.bti7081.s2020.green.protomed.view;

import com.github.appreciated.card.ClickableCard;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.QueryParameters;

import ch.bfh.bti7081.s2020.green.protomed.component.CalendarListItem;
import ch.bfh.bti7081.s2020.green.protomed.component.ClientListItem;
import ch.bfh.bti7081.s2020.green.protomed.management.HealthClientManager;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthClient;
import ch.bfh.bti7081.s2020.green.protomed.view.LoginView.LoginViewListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ClientViewImplementation extends VerticalLayout implements ClientView {

    private List<ClientViewListener> listeners = new ArrayList<ClientViewListener>();
	private Set<HealthClient> clients;

    public ClientViewImplementation() {
    	
    	clients = HealthClientManager.getInstance().getHealthClients();

    	add(new H2("Alle Klienten"));
    	
    	for (HealthClient client : clients)
    	{
    		ClickableCard clientCard = new ClickableCard(
                onClick -> {
                	// TODO: Notify presenter that this client has been clicked
                	for (ClientViewListener listener : listeners)
                        listener.selectClient(client);
                },
                new ClientListItem(client)
            );
    		clientCard.setWidthFull();
    		add(clientCard);
    	}
    }

    public void navigateToClientProfile(int id) {
        UI.getCurrent().navigate("client/" + Integer.toString(id));
    }
    
    @Override
    public void addListener(ClientViewListener listener) {
    	listeners.add(listener);
    }
}
