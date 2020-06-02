package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.component.ClientListItem;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthClient;
import com.github.appreciated.card.ClickableCard;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ClientViewImplementation extends VerticalLayout implements ClientView {

    private List<ClientViewListener> listeners = new ArrayList<ClientViewListener>();
    private VerticalLayout healthClientList;

    public ClientViewImplementation() {

        add(new H2("Alle Klienten"));

        TextField search = new TextField();
        search.setPlaceholder("Suche Klient");
        search.setAutoselect(true);
        search.addValueChangeListener(e -> {
            for (ClientViewListener listener : listeners)
                listener.setSearchValue(e.getValue().toString());
        });
        search.setWidthFull();

        add(search);

        healthClientList = new VerticalLayout();
        healthClientList.setWidthFull();
        healthClientList.setMargin(false);
        healthClientList.setPadding(false);
        add(healthClientList);

    }

    public void updateHealthClientList(Set<HealthClient> clients) {
        healthClientList.removeAll();
        for (HealthClient client : clients) {
            ClickableCard clientCard = new ClickableCard(
                    onClick -> {
                        for (ClientViewListener listener : listeners)
                            listener.selectClient(client);
                    },
                    new ClientListItem(client)
            );
            clientCard.setWidthFull();
            healthClientList.add(clientCard);
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
