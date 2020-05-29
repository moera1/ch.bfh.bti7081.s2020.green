package ch.bfh.bti7081.s2020.green.protomed.management.mock;

import ch.bfh.bti7081.s2020.green.protomed.model.FAQEntry;

import java.util.ArrayList;
import java.util.List;

public class FAQMock {

    public static List<FAQEntry> getFAQEntries(){
        List<FAQEntry> faqEntries = new ArrayList<>();

        String question = null;
        String answer = null;
        String tags = null;
        FAQEntry.Category category = null;

        question = "Kann ich bei SPITEX BERN eine Ausbildung machen?";
        answer = "Wir bilden Lernende Fachfrau/Fachmann Gesundheit (FaGe) aus. Das Aufnahmeverfahren beginnt jeweils ab Mitte August. Beachten Sie dazu die Inserate in der Tagespresse und den Lehrstellennachweis der Erziehungsdirektion www.erz.be.ch/lena.\n" +
                "                Die auf zwei Jahre verkürzte Ausbildung FaGe-Erwachsene steht zurzeit nur den Mitarbeitenden von SPITEX BERN offen.\n" +
                "                Zudem sind wir Praktikumsort für die Ausbildung Höhere Fachschule Pflege am Berner Bildungszentrum Pflege.";
        tags = "FaGe, Bildungszentrum";
        category = FAQEntry.Category.CATEGORY_APPRENTICES;
        faqEntries.add(new FAQEntry(question, answer, tags, category));

        question = "Bietet SPITEX BERN Praktikumsplätze an?";
        answer = "Wir bieten verschiedene Einblick Praktika an (Dauer 1, 4 und 14 Tage) melden sie sich via www.myoda.ch an und wir organisieren dies mit Ihnen gemeinsam.";
        tags = "Praktika, Praktikum, Praktikumsstelle";
        category = FAQEntry.Category.CATEGORY_APPRENTICES;
        faqEntries.add(new FAQEntry(question, answer, tags, category));

        question = "Ich mache den Kurs PflegehelferIn beim SRK. Kann ich bei SPITEX BERN das Praktikum von 30 Tagen absolvieren?";
        answer = "Wenn Sie ein besonderes Interesse am Versorgungsbereich Spitex haben, dann dürfen Sie sich gerne für eine Praktikumsstelle bewerben.";
        tags = "Praktika, Praktikum, Praktikumsstelle";
        category = FAQEntry.Category.CATEGORY_APPRENTICES;
        faqEntries.add(new FAQEntry(question, answer, tags, category));


        return faqEntries;
    }
}
