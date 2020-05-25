package ch.bfh.bti7081.s2020.green.protomed.presenter;

import ch.bfh.bti7081.s2020.green.protomed.management.ApplicationModelManager;
import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;
import ch.bfh.bti7081.s2020.green.protomed.view.protocol.ProtocolDetailsView;
import ch.bfh.bti7081.s2020.green.protomed.view.protocol.details.ProtocolDetailsViewImplementation;

import java.util.Optional;

public class ProtocolDetailPresenter implements ProtocolDetailsView.ProtocolDetailViewListener {

    private Protocol model;
    private ProtocolDetailsViewImplementation view;

    public ProtocolDetailPresenter(Integer id, ProtocolDetailsViewImplementation view) {
        this.model = loadProtocol(id);
        this.view = view;
        view.loadProtocolDetails(model);

    }

    private Protocol loadProtocol(int id) {
        Optional<Protocol> protocolOptional = ApplicationModelManager.getInstance().getProtocolByID(id);
        return protocolOptional.orElse(null);
    }

}
