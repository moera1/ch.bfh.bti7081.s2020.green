package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.component.ProtocolListItem;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthClient;
import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;
import com.github.appreciated.card.ClickableCard;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

import java.util.ArrayList;
import java.util.List;

public class ProtocolViewImplementation extends VerticalLayout implements ProtocolView {

    private List<ProtocolViewListener> listeners = new ArrayList<>();
    private VerticalLayout protocolList;

    public ProtocolViewImplementation() {
        addClassName("protocol-container");

        add(new H2("Alle Protokolle"));

        TextField search = new TextField();

        search.setPlaceholder("Suche Protokoll");
        search.setAutoselect(true);
        search.addValueChangeListener(e -> {
            for (ProtocolViewListener listener : listeners){
                listener.setSearchValue(e.getValue());
            }
        });
        search.setWidthFull();

        add(search);

        protocolList = new VerticalLayout();
        protocolList.setWidthFull();
        protocolList.setMargin(false);
        protocolList.setPadding(false);
        add(protocolList);
    }
    
    public ProtocolViewImplementation(HealthClient client) {

        addClassName("protocol-container");

        add(new H2("Alle Protokolle (" + client.getFullName() + ")"));

        TextField search = new TextField();

        search.setPlaceholder("Suche Protokoll");
        search.setAutoselect(true);
        search.addValueChangeListener(e -> {
            for (ProtocolViewListener listener : listeners){
                listener.setSearchValue(e.getValue());
            }
        });
        search.setWidthFull();

        add(search);

        protocolList = new VerticalLayout();
        protocolList.setWidthFull();
        protocolList.setMargin(false);
        protocolList.setPadding(false);
        add(protocolList);
    }

    public void updateProtocolList(List<Protocol> protocols){
        protocolList.removeAll();
        for (Protocol protocol : protocols){
            ClickableCard protocolCard = new ClickableCard(
                    onClick -> {
                        for (ProtocolViewListener listener : listeners)
                            listener.selectProtocol(protocol);
                    },
                    new ProtocolListItem(protocol)
            );
            protocolCard.setWidthFull();
            protocolList.add(protocolCard);
        }
    }

    public void navigateToProtocol(Long id) {
        UI.getCurrent().navigate("protocol/" + id);
    }

    @Override
    public void addListener(ProtocolViewListener listener) {
        listeners.add(listener);
    }
}
