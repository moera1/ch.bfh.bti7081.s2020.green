package ch.bfh.bti7081.s2020.green.protomed.presenter;

import ch.bfh.bti7081.s2020.green.protomed.model.Protocol;
import ch.bfh.bti7081.s2020.green.protomed.view.ProtocolDetailView;
import ch.bfh.bti7081.s2020.green.protomed.view.ProtocolDetailViewImplementation;

public class ProtocolDetailPresenter implements ProtocolDetailView.ProtocolDetailViewListener {

    private Protocol model;
    private ProtocolDetailViewImplementation view;

    public ProtocolDetailPresenter(Protocol model, ProtocolDetailViewImplementation view) {
        this.model = model;
        this.view = view;
    }

}
