package ch.bfh.bti7081.s2020.green.protomed.presenter;

import ch.bfh.bti7081.s2020.green.protomed.management.ApplicationModelManager;
import ch.bfh.bti7081.s2020.green.protomed.management.HealthVisitorManager;
import ch.bfh.bti7081.s2020.green.protomed.model.FAQEntry;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthVisitor;
import ch.bfh.bti7081.s2020.green.protomed.view.HelpView;

import java.util.List;

public class HelpPresenter implements HelpView.HelpViewListener {
    private HelpView view;
    private List<FAQEntry> faqEntries;
    private HealthVisitor currentUser;

    public HelpPresenter(HelpView view){
        this.view = view;
        view.addListener(this);
        currentUser = HealthVisitorManager.getInstance().getCurrentUser();
        faqEntries = ApplicationModelManager.getInstance().getFAQEntries();
        view.updateFAQEntryList(faqEntries);
    }

    @Override
    public void setSearchValue(String value) {

    }
}
