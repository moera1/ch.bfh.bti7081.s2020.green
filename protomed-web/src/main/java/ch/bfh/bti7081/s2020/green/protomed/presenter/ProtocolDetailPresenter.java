package ch.bfh.bti7081.s2020.green.protomed.presenter;

import ch.bfh.bti7081.s2020.green.protomed.management.ApplicationModelManager;
import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;
import ch.bfh.bti7081.s2020.green.protomed.view.ProtocolDetailView;
import ch.bfh.bti7081.s2020.green.protomed.view.ProtocolDetailViewImplementation;

import java.util.Optional;

public class ProtocolDetailPresenter implements ProtocolDetailView.ProtocolDetailViewListener {

    private Protocol model;
    private ProtocolDetailViewImplementation view;

    public ProtocolDetailPresenter(Integer id, ProtocolDetailViewImplementation view) {
        this.model = loadProtocol(id);
        this.view = view;
        view.loadProtocolDetails(model);

    }

    private Protocol loadProtocol(int id) {
        Optional<Protocol> protocolOptional = ApplicationModelManager.getInstance().getProtocolByID(id);
        return protocolOptional.orElse(null);
    }

}
