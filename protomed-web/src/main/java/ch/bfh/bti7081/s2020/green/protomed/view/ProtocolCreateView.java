package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;

public interface ProtocolCreateView {

    interface ProtocolCreateViewListener {
        void save(Protocol protocol);

        void cancel(Protocol protocol);

        void createProtocol(Protocol protocol);
    }

    void addListener(ProtocolCreateViewListener listener);

    void loadProtocolData(Protocol protocol);

    void navigateToCreateProtocol(Long id);
}
