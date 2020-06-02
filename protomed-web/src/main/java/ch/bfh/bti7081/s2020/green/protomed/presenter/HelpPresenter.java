package ch.bfh.bti7081.s2020.green.protomed.presenter;

import ch.bfh.bti7081.s2020.green.protomed.management.ApplicationModelManager;
import ch.bfh.bti7081.s2020.green.protomed.management.HealthVisitorManager;
import ch.bfh.bti7081.s2020.green.protomed.model.FAQEntry;
import ch.bfh.bti7081.s2020.green.protomed.model.HealthVisitor;
import ch.bfh.bti7081.s2020.green.protomed.view.HelpView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HelpPresenter implements HelpView.HelpViewListener {
    private HelpView view;
    private List<FAQEntry> faqEntries;
    private HealthVisitor currentUser;
    private boolean showGeneral = false;
    private boolean showDepression = false;
    private boolean showApprentices = false;

    public HelpPresenter(HelpView view, boolean general, boolean depression, boolean apprentices) {
        this.view = view;
        this.showGeneral = general;
        this.showDepression = depression;
        this.showApprentices = apprentices;
        view.addListener(this);
        currentUser = HealthVisitorManager.getInstance().getCurrentUser();
        faqEntries = ApplicationModelManager.getInstance().getFAQEntries(showGeneral, showDepression, showApprentices);
        view.updateFAQEntryList(faqEntries);
    }

    @Override
    public void setSearchValue(String value) {
        faqEntries = ApplicationModelManager.getInstance().getFAQEntries(showGeneral, showDepression, showApprentices);
        Iterator<FAQEntry> it = faqEntries.iterator();
        List<FAQEntry> newList = new ArrayList<>();
        whileloop:
        while (it.hasNext()) {
            FAQEntry entry = it.next();
            for (String tag : entry.getTagList()) {
                tag = tag.toLowerCase();
                if (tag.startsWith(value.toLowerCase())) {
                    newList.add(entry);
                    continue whileloop;
                }
            }
        }
        view.updateFAQEntryList(newList);
    }

    @Override
    public void setGeneralValue(Boolean value) {
        showGeneral = value;
        faqEntries = ApplicationModelManager.getInstance().getFAQEntries(showGeneral, showDepression, showApprentices);
        view.updateFAQEntryList(faqEntries);
    }

    @Override
    public void setDepressionValue(Boolean value) {
        showDepression = value;
        faqEntries = ApplicationModelManager.getInstance().getFAQEntries(showGeneral, showDepression, showApprentices);
        view.updateFAQEntryList(faqEntries);
    }

    @Override
    public void setApprenticesValue(Boolean value) {
        showApprentices = value;
        faqEntries = ApplicationModelManager.getInstance().getFAQEntries(showGeneral, showDepression, showApprentices);
        view.updateFAQEntryList(faqEntries);
    }
}
