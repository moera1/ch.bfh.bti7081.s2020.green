package ch.bfh.bti7081.s2020.green.protomed.presenter;

import ch.bfh.bti7081.s2020.green.protomed.management.HealthClientManager;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthClient;
import ch.bfh.bti7081.s2020.green.protomed.view.client.ClientView;

import java.util.HashSet;
import java.util.Set;

public class ClientPresenter implements ClientView.ClientViewListener {
    private ClientView view;
    private Set<HealthClient> clients;


    public ClientPresenter(ClientView view) {
        this.view = view;
        view.addListener(this);
        clients = HealthClientManager.getInstance().getHealthClients();
        view.updateHealthClientList(clients);
    }

    public void selectClient(HealthClient client) {
        view.navigateToClientProfile(client.getPersonId());
    }

    public void setSearchValue(String value) {
        Set<HealthClient> filteredClients = new HashSet<>();
        for (HealthClient client : clients) {
            if (client.toString().toLowerCase().contains(value.toLowerCase())) {
                filteredClients.add(client);
            }
        }
        view.updateHealthClientList(filteredClients);
    }
}
