package ch.bfh.bti7081.s2020.green.protomed.component;

import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;
import com.github.appreciated.card.ClickableCard;
import com.vaadin.flow.component.UI;

import java.util.List;
import java.util.stream.Collectors;


public class ProtocolsShortList extends ShortList {

    public ProtocolsShortList(List<Protocol> protocols, int filterParameter) {

        super("Protokolle", "protocols/" + Integer.toString(filterParameter), protocols.size());

        for (Protocol protocol : protocols.stream().limit(3).collect(Collectors.toList())) {
            ClickableCard protocolCard = new ClickableCard(
                    onClick -> {
                        UI.getCurrent().navigate("protocol/" + Long.toString(protocol.getId()));
                    },
                    new ProtocolListItem(protocol)
            );
            protocolCard.setWidthFull();
            add(protocolCard);
        }
    }
}
