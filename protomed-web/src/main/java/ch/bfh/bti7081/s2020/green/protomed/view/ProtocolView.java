package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.model.Appointment;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthClient;
import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;

import java.util.List;

public interface ProtocolView {

    interface ProtocolViewListener {
        void selectProtocol(Protocol protocol);

        void setSearchValue(String value);

        void filterByHealthClient(HealthClient client);

        void navigateToProtocolCreateView();
    }

    public void updateProtocolList(List<Protocol> protocols);

    public void navigateToProtocol(Long id);

    public void addListener(ProtocolViewListener listener);

}
