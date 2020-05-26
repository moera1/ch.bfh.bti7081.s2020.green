package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;

import java.util.List;

public interface ProtocolDetailView {

    interface ProtocolDetailViewListener {
        void editProtocol(Protocol protocol);
    }

    void loadProtocolDetails(Protocol protocol);

    void addListener(ProtocolDetailViewListener listener);

    List<ProtocolDetailViewListener> getListeners();

    void navigateToEditProtocol(Long id);
}
