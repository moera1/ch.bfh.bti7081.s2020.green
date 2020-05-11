package ch.bfh.bti7081.s2020.green.protomed.layout;

import ch.bfh.bti7081.s2020.green.protomed.MainView;
import ch.bfh.bti7081.s2020.green.protomed.view.*;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabVariant;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.VaadinServlet;

import java.util.ArrayList;
import java.util.List;

public class MainLayout extends AppLayout {

    private final Tabs menu;

    public MainLayout(){
    Span appName = new Span("Protomed");
    appName.addClassName("hide-on-mobile");

    menu = createMenuTabs();

    this.addToNavbar(appName);
    this.addToNavbar(true, menu);

    getElement().addEventListener("search-focus", e -> {
        getElement().getClassList().add("hide-navbar");
    });

    getElement().addEventListener("search-blur", e -> {
        getElement().getClassList().remove("hide-navbar");
    });
}

    /**
     * This static method is used to create the menu tabs set the orientation and return the tabs.
     * @return Tabs
     */
    private static Tabs createMenuTabs() {
        final Tabs tabs = new Tabs();
        tabs.setOrientation(Tabs.Orientation.HORIZONTAL);
        tabs.add(getAvailableTabs());
        return tabs;
    }

    /**
     * This static method is used to add the tabs to an ArrayList and return the ArrayList.
     * @return Tab[]
     */
    private static Tab[] getAvailableTabs() {
        final List<Tab> tabs = new ArrayList<>(4);

        tabs.add(createTab(VaadinIcon.HOME, "Home",
                DashboardMainView.class));
        tabs.add(createTab(VaadinIcon.CALENDAR, "Termine",
                AppointmentMainView.class));
        tabs.add(createTab(VaadinIcon.USERS, "Klienten",
                ClientMainView.class));
        tabs.add(createTab(VaadinIcon.FILE_TEXT_O, "Protokolle",
                DashboardMainView.class));
        tabs.add(createTab(VaadinIcon.QUESTION_CIRCLE_O, "Hilfe",
                HelpMainView.class));

        final String contextPath = VaadinServlet.getCurrent().getServletContext().getContextPath();
        final Tab logoutTab = createTab(createLogoutLink(contextPath));
        tabs.add(logoutTab);
        return tabs.toArray(new Tab[tabs.size()]);
    }

    /**
     * This static method is used to create the tab in a specific layout and add the new RouterLink.
     * @param icon The VaadinIcon it should show.
     * @param title The String value of the tab.
     * @param viewClass The Class it should forward to.
     * @return Tab
     */
    private static Tab createTab(VaadinIcon icon, String title, Class<? extends Component> viewClass) {
        return createTab(populateLink(new RouterLink(null, viewClass), icon, title));
    }

    private static Tab createTab(Component content) {
        final Tab tab = new Tab();
        tab.addThemeVariants(TabVariant.LUMO_ICON_ON_TOP);
        tab.add(content);
        return tab;
    }

    /**
     * This static method is used to create a Logout link.
     * @param contextPath
     * @return
     */
    private static Anchor createLogoutLink(String contextPath) {
        final Anchor a = populateLink(new Anchor(), VaadinIcon.ARROW_RIGHT, "Logout");
        a.setHref(contextPath + "/logout");
        return a;
    }

    /**
     * This static method is usede to populate the Link with an icon and a title.
     * @param a
     * @param icon The VaadinIcon it should show.
     * @param title The String value of the tab.
     * @param <T>
     * @return
     */
    private static <T extends HasComponents> T populateLink(T a, VaadinIcon icon, String title) {
        a.add(icon.create());
        a.add(title);
        return a;
    }
}