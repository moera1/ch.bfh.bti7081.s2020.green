package ch.bfh.bti7081.s2020.green.protomed.view.protocol.details;

import ch.bfh.bti7081.s2020.green.protomed.component.ProtocolDetail;
import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;
import ch.bfh.bti7081.s2020.green.protomed.view.protocol.ProtocolDetailsView;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

public class ProtocolDetailsViewImplementation extends VerticalLayout implements ProtocolDetailsView {

    private List<ProtocolDetailViewListener> listeners = new ArrayList<>();
    private ProtocolDetail protocolDetail;

    public ProtocolDetailsViewImplementation() {
        protocolDetail = new ProtocolDetail(true);
        add(protocolDetail);
    }

    @Override
    public void loadProtocolDetails(Protocol protocol) {
        protocolDetail.loadProtocolDetails(protocol);
    }

    @Override
    public void addListener(ProtocolDetailsView listener) {

    }
}
