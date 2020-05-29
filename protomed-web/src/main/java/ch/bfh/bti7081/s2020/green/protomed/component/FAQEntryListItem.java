package ch.bfh.bti7081.s2020.green.protomed.component;

import ch.bfh.bti7081.s2020.green.protomed.model.FAQEntry;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class FAQEntryListItem extends VerticalLayout {

    public FAQEntryListItem(FAQEntry entry) {
        addClassName("list-item");

        setWidthFull();
        setJustifyContentMode(JustifyContentMode.BETWEEN);

        Div questionBox = new Div();
        questionBox.setWidthFull();
        questionBox.addClassName("question-box");
        questionBox.getStyle().set("font-weight", "bold");
        questionBox.setText("Q.: " + entry.getQuestion());

        Div answerBox = new Div();
        answerBox.setWidthFull();
        answerBox.addClassName("answer-box");
        answerBox.setText("A.: " + entry.getAnswer());

        setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);

        add(questionBox, answerBox);
    }
}
