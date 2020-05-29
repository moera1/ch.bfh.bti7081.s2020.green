package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.component.AppointmentListItem;
import ch.bfh.bti7081.s2020.green.protomed.component.FAQEntryListItem;
import ch.bfh.bti7081.s2020.green.protomed.model.Appointment;
import ch.bfh.bti7081.s2020.green.protomed.model.FAQEntry;
import com.github.appreciated.card.Card;
import com.github.appreciated.card.ClickableCard;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HelpViewImplementation extends VerticalLayout implements HelpView {

    private List<HelpViewListener> listeners = new ArrayList<HelpViewListener>();
    private HorizontalLayout contactList;
    private VerticalLayout faqEntryList;

    public HelpViewImplementation() {

        //add(new H2("Kontakte"));

        //contactList = new HorizontalLayout();
        //contactList.setWidthFull();
        //contactList.setMargin(false);
        //contactList.setPadding(false);

        add(new H2("FAQ"));

        TextField search = new TextField();

        search.setPlaceholder("Suche");
        search.setAutoselect(true);
        search.addValueChangeListener(e -> {
            for (HelpView.HelpViewListener listener : listeners) {
                listener.setSearchValue(e.getValue().toString());
            }
        });
        search.setWidthFull();

        add(search);

        faqEntryList = new VerticalLayout();
        faqEntryList.setWidthFull();
        faqEntryList.setMargin(false);
        faqEntryList.setPadding(false);
        add(faqEntryList);

        addClassName("help-container");
    }

    @Override
    public void updateFAQEntryList(List<FAQEntry> faqEntries) {
        faqEntryList.removeAll();
        for (FAQEntry faqEntry : faqEntries) {
            Card faqEntryCard = new Card(new FAQEntryListItem(faqEntry));
            faqEntryCard.setWidthFull();
            faqEntryList.add(faqEntryCard);
        }
    }

    @Override
    public void addListener(HelpViewListener listener) {

    }
}
