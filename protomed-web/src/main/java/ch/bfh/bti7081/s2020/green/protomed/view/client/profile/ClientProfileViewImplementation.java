package ch.bfh.bti7081.s2020.green.protomed.view.client.profile;

import ch.bfh.bti7081.s2020.green.protomed.component.AppointmentsShortList;
import ch.bfh.bti7081.s2020.green.protomed.component.NotificationsShortList;
import ch.bfh.bti7081.s2020.green.protomed.component.PersonContactCard;
import ch.bfh.bti7081.s2020.green.protomed.component.ProtocolsShortList;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthClient;
import ch.bfh.bti7081.s2020.green.protomed.view.client.ClientProfileView;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

public class ClientProfileViewImplementation extends VerticalLayout implements ClientProfileView {
    private List<ClientProfileViewListener> listeners = new ArrayList<ClientProfileViewListener>();

    public ClientProfileViewImplementation(HealthClient client) {

        //TODO: Create adjust URL
        add(new Anchor("/protocol/new?client=" + client.getPersonId(), new Icon(VaadinIcon.FILE_ADD)));

        Image photo = new Image();
        add(photo);

        add(new PersonContactCard(client));

        add(new NotificationsShortList());

        add(new AppointmentsShortList());

        add(new ProtocolsShortList());


    }

    @Override
    public void addListener(ClientProfileViewListener listener) {
        listeners.add(listener);
    }


}
