package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.model.HealthClient;

public interface ClientView {

    interface ClientViewListener {

		void selectClient(HealthClient client);
		
    }
    
    public void navigateToClientProfile(int id);

    public void addListener(ClientViewListener listener);
}
