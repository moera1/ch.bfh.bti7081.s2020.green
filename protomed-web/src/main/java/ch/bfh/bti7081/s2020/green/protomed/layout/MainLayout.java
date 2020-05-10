package ch.bfh.bti7081.s2020.green.protomed.layout;

import ch.bfh.bti7081.s2020.green.protomed.view.*;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout {

    public MainLayout() {
        final DrawerToggle drawerToggle = new DrawerToggle();
        final RouterLink home = new RouterLink("Home", DashboardMainView.class);
        final RouterLink appointments = new RouterLink("Termine", AppointmentMainView.class);
        final RouterLink clients = new RouterLink("Klienten", ClientMainView.class);
        final RouterLink protocols = new RouterLink("Protokolle", ProtocolMainView.class);
        final RouterLink help = new RouterLink("Hilfe", HelpMainView.class);
        final VerticalLayout menuLayout = new VerticalLayout(home, appointments, clients, protocols, help);

        addToDrawer(menuLayout);
        addToNavbar(drawerToggle);
    }

}