package ch.bfh.bti7081.s2020.green.protomed.view;

import ch.bfh.bti7081.s2020.green.protomed.model.FAQEntry;

import java.util.List;

public interface HelpView {

    interface HelpViewListener {
        void setSearchValue(String value);

        void setGeneralValue(Boolean value);

        void setDepressionValue(Boolean value);

        void setApprenticesValue(Boolean value);
    }

    public void updateFAQEntryList(List<FAQEntry> faqEntries);

    public void addListener(HelpViewListener listener);

    public boolean generalSelected();

    public boolean depressionSelected();

    public boolean apprenticesSelected();

}
