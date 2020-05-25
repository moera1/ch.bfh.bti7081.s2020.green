package ch.bfh.bti7081.s2020.green.protomed.view.protocol;

import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;

public interface ProtocolDetailsView {

    interface ProtocolDetailViewListener {
    }

    void loadProtocolDetails(Protocol protocol);

    void addListener(ProtocolDetailsView listener);
}
