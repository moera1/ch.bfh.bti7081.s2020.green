package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;

public interface ProtocolDetailView {

    interface ProtocolDetailViewListener {
    }

    void loadProtocolDetails(Protocol protocol);

    void addListener(ProtocolDetailView listener);
}
