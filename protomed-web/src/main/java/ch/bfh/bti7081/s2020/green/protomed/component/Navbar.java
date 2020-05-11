package ch.bfh.bti7081.s2020.green.protomed.component;

import ch.bfh.bti7081.s2020.green.protomed.MainView;
import ch.bfh.bti7081.s2020.green.protomed.view.DashboardMainView;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.RouterLink;

public class Navbar extends VerticalLayout {

    public Navbar(String width) {
        Label navTitle = new Label("Protomed");
        setClassName("navbar-container");

        setWidth(width);
        setSpacing(true);

        Tabs tabs = new Tabs();
        Tab tab1 = new Tab(new RouterLink("Dashboard", DashboardMainView.class));
        Tab tab2 = new Tab(new RouterLink("Termine", DashboardMainView.class));
        Tab tab3 = new Tab(new RouterLink("Protokolle", DashboardMainView.class));
        Tab tab4 = new Tab(new RouterLink("Klienten", DashboardMainView.class));
        Tab tab5 = new Tab(new RouterLink("FAQ", MainView.class));
        tabs.add(tab1, tab2, tab3, tab4, tab5);
        tabs.setOrientation(Tabs.Orientation.VERTICAL);


        add(tabs);

    }


}
