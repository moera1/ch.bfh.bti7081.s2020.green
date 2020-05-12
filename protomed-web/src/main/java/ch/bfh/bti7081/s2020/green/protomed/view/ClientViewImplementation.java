package ch.bfh.bti7081.s2020.green.protomed.view;

import com.github.appreciated.card.ClickableCard;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HasUrlParameter;

import ch.bfh.bti7081.s2020.green.protomed.component.CalendarListItem;
import ch.bfh.bti7081.s2020.green.protomed.component.ClientListItem;
import ch.bfh.bti7081.s2020.green.protomed.management.HealthClientManager;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthClient;

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
                },
                new ClientListItem(client)
            );
    		clientCard.setWidthFull();
    		add(clientCard);
    	}
    }

    @Override
    public void addListener(ClientViewListener listener) {

    }
}
