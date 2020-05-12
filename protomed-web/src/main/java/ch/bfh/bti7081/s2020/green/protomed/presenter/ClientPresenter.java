package ch.bfh.bti7081.s2020.green.protomed.presenter;

import java.util.Set;

import ch.bfh.bti7081.s2020.green.protomed.management.HealthClientManager;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthClient;
import ch.bfh.bti7081.s2020.green.protomed.view.ClientView;

public class ClientPresenter implements ClientView.ClientViewListener {
	private ClientView view;


    public ClientPresenter(ClientView view) {
        this.view = view;
        view.addListener(this);
    }
    
    public void selectClient(HealthClient client) {
    	
    }
}
