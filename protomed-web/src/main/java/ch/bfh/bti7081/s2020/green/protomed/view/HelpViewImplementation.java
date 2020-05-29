package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.component.FAQEntryListItem;
import ch.bfh.bti7081.s2020.green.protomed.model.FAQEntry;
import com.github.appreciated.card.Card;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

import java.util.ArrayList;
import java.util.List;

public class HelpViewImplementation extends VerticalLayout implements HelpView {

    private List<HelpViewListener> listeners = new ArrayList<HelpViewListener>();
    private HorizontalLayout contactList;
    private VerticalLayout faqEntryList;

    private Checkbox generalCB;
    private Checkbox depressionCB;
    private Checkbox apprenticesCB;

    public HelpViewImplementation() {

        //add(new H2("Kontakte"));

        //contactList = new HorizontalLayout();
        //contactList.setWidthFull();
        //contactList.setMargin(false);
        //contactList.setPadding(false);

        add(new H2("FAQ"));

        HorizontalLayout checkboxes = new HorizontalLayout();
        generalCB = new Checkbox();
        generalCB.setLabel("Generele Fragen");
        generalCB.setValue(true);
        generalCB.addValueChangeListener(e -> {
            for (HelpView.HelpViewListener listener : listeners) {
                listener.setGeneralValue(e.getValue());
            }
        });
        checkboxes.add(generalCB);

        depressionCB = new Checkbox();
        depressionCB.setLabel("Depression");
        depressionCB.setValue(true);
        depressionCB.addValueChangeListener(e -> {
            for (HelpView.HelpViewListener listener : listeners) {
                listener.setDepressionValue(e.getValue());
            }
        });
        checkboxes.add(depressionCB);

        apprenticesCB = new Checkbox();
        apprenticesCB.setLabel("Für Lernende");
        apprenticesCB.setValue(false);
        apprenticesCB.addValueChangeListener(e -> {
            for (HelpView.HelpViewListener listener : listeners) {
                listener.setApprenticesValue(e.getValue());
            }
        });
        checkboxes.add(apprenticesCB);

        add(checkboxes);

        TextField search = new TextField();

        search.setPlaceholder("Suche");
        search.setAutoselect(true);
        search.addValueChangeListener(e -> {
            for (HelpView.HelpViewListener listener : listeners) {
                listener.setSearchValue(e.getValue());
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
        this.listeners.add(listener);
    }

    @Override
    public boolean generalSelected() {
        return generalCB.getValue();
    }

    @Override
    public boolean depressionSelected() {
        return depressionCB.getValue();
    }

    @Override
    public boolean apprenticesSelected() {
        return apprenticesCB.getValue();
    }
}
