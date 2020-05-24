package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.component.ProtocolDetail;
import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

public class ProtocolDetailViewImplementation extends VerticalLayout implements ProtocolDetailView {

    private List<ProtocolDetailViewListener> listeners = new ArrayList<>();
    private ProtocolDetail protocolDetail;

    public ProtocolDetailViewImplementation() {
        protocolDetail = new ProtocolDetail(this);
        add(protocolDetail);
    }

    @Override
    public void loadProtocolDetails(Protocol protocol) {
        protocolDetail.loadProtocolDetails(protocol);
    }

    @Override
    public void addListener(ProtocolDetailView listener) {

    }
}
