package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.model.HealthClient;

import java.util.Set;

public interface ClientView {

    interface ClientViewListener {

        void selectClient(HealthClient client);

        void setSearchValue(String value);

    }

    public void navigateToClientProfile(int id);


    public void updateHealthClientList(Set<HealthClient> clients);


    public void addListener(ClientViewListener listener);
}
