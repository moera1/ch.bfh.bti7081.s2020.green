package ch.bfh.bti7081.s2020.green.protomed.component;

import java.util.List;
import java.util.stream.Collectors;

import com.github.appreciated.card.ClickableCard;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;


public class ProtocolsShortList extends ShortList {

	public ProtocolsShortList(List<Protocol> protocols) {
		
		super("Protokolle", "protocols", protocols.size());
		
    	for (Protocol protocol : protocols.stream().limit(3).collect(Collectors.toList()))
    	{
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
