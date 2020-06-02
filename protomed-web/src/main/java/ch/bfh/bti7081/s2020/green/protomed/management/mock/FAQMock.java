package ch.bfh.bti7081.s2020.green.protomed.management.mock;

import ch.bfh.bti7081.s2020.green.protomed.model.FAQEntry;

import java.util.ArrayList;
import java.util.List;

public class FAQMock {

    public static List<FAQEntry> getFAQEntries() {
        List<FAQEntry> faqEntries = new ArrayList<>();

        String question = null;
        String answer = null;
        String tags = null;
        FAQEntry.Category category = null;

        question = "Kann ich bei SPITEX BERN eine Ausbildung machen?";
        answer = "Wir bilden Lernende Fachfrau/Fachmann Gesundheit (FaGe) aus. Das Aufnahmeverfahren beginnt jeweils ab Mitte August. Beachten Sie dazu die Inserate in der Tagespresse und den Lehrstellennachweis der Erziehungsdirektion www.erz.be.ch/lena.\n" +
                "Die auf zwei Jahre verkürzte Ausbildung FaGe-Erwachsene steht zurzeit nur den Mitarbeitenden von SPITEX BERN offen.\n" +
                "Zudem sind wir Praktikumsort für die Ausbildung Höhere Fachschule Pflege am Berner Bildungszentrum Pflege.";
        tags = "FaGe Bildungszentrum";
        category = FAQEntry.Category.CATEGORY_APPRENTICES;
        faqEntries.add(new FAQEntry(question, answer, tags, category));

        question = "Bietet SPITEX BERN Praktikumsplätze an?";
        answer = "Wir bieten verschiedene Einblick Praktika an (Dauer 1, 4 und 14 Tage) melden sie sich via www.myoda.ch an und wir organisieren dies mit Ihnen gemeinsam.";
        tags = "Praktika Praktikum Praktikumsstelle";
        category = FAQEntry.Category.CATEGORY_APPRENTICES;
        faqEntries.add(new FAQEntry(question, answer, tags, category));

        question = "Ich mache den Kurs PflegehelferIn beim SRK. Kann ich bei SPITEX BERN das Praktikum von 30 Tagen absolvieren?";
        answer = "Wenn Sie ein besonderes Interesse am Versorgungsbereich Spitex haben, dann dürfen Sie sich gerne für eine Praktikumsstelle bewerben.";
        tags = "Praktika Praktikum Praktikumsstelle";
        category = FAQEntry.Category.CATEGORY_APPRENTICES;
        faqEntries.add(new FAQEntry(question, answer, tags, category));

        question = "Was ist eine Depression?";
        answer = "Eine Depression ist eine Erkrankung, welche den Menschen als Ganzes betrifft: den Körper, die Stimmungslage, das Denken uvm. Die Depression wirkt sich darauf aus, wie man sich fühlt, wie man denkt, schläft und isst.\n" +
                "Einfache Alltagsfunktionen sind je nach Stadium und Verlauf stark beeinträchtigt.\n" +
                "\n" +
                "Zudem wird die Krankheit heute als «systemische» Erkrankung betrachtet, da sie neben der Gefühlswelt und dem Gehirn auch andere Organfunktionen in Mitleidenschaft ziehen kann.\n" +
                "\n" +
                "Die Krankheit ist weit mehr als «Unglücklichsein». Depression ist beständig, dauert Wochen bis Monate an, nicht nur einige Stunden oder Tage. Aber: Sie ist behandelbar. Heute können mehr als 2/3 aller Fälle geheilt werden.";
        tags = "Depression";
        category = FAQEntry.Category.CATEGORY_DEPRESSION;
        faqEntries.add(new FAQEntry(question, answer, tags, category));

        question = "Wie wird eine Depression diagnostiziert?";
        answer = "Mit einer umfassenden Differentialdiagnostik.\n" +
                "Der erste Schritt ist eine körperliche Untersuchung durch einen Arzt. Einige Krankheiten, wie z.B. Virusinfektionen, Mangelzustände oder gewisse Medikamente können dieselben Symptome wie eine Depression hervorrufen. Für eine genaue Diagnose, müssen andere Krankheiten ausgeschlossen werden.\n" +
                "\n" +
                "Dies geschieht durch eine Untersuchung, eine umfassende Anamneseerhebung und Labortests.\n" +
                "\n" +
                "Wird keine körperliche Ursache für die Symptome gefunden, empfiehlt sich eine (neuro-)psychologische Untersuchung, vorzugsweise durch einen Psychologen oder einen Facharzt für Psychiatrie und Psychologie.";
        tags = "Depression Diagnose";
        category = FAQEntry.Category.CATEGORY_DEPRESSION;
        faqEntries.add(new FAQEntry(question, answer, tags, category));

        question = "Gibt es Präventionsmöglichkeiten?";
        answer = "Mit einer umfassenden Differentialdiagnostik.\n" +
                "Eine gewisse Form der Selbstreflexion hilft zumindest, Lebensfragen zu beantworten und einer schweren Erkrankung vorzubeugen. Auch hier kann bereits therapeutische Hilfe in Anspruch genommen werden. Was ist mir wichtig? Wo will ich meine Ressourcen einsetzen? Es hilft, den eigenen Werte-Kompass immer wieder neu zu justieren. Welche Last kann ich tragen? Soziale Teilhabe ist zudem einer der wichtigsten Faktoren, um gesund zu bleiben.\n" +
                "\n" +
                "Vereine und Freiwilligenarbeit tun enorm gut. Man darf übrigens ruhig auch digitale Kontakte pflegen, solange man in Echtzeit kommuniziert. Es geht für viele Menschen um die Frage des sinnhaften Tuns. Macht Arbeit krank oder tut sie einem gut? Zu den weiteren Wirkfaktoren, die aufeinander abgestimmt sein sollten um die persönliche Balance halten zu können, gehören in jedem Fall eine gesunde Ernährung, Licht, ausreichend Schlaf, und Bewegung.";
        tags = "Depression Prävention";
        category = FAQEntry.Category.CATEGORY_DEPRESSION;
        faqEntries.add(new FAQEntry(question, answer, tags, category));

        question = "Welche Kosten übernimmt die Krankenkasse?";
        answer = "Alle Pflege - und Betreuungsleistungen, die vom Arzt verordnet und von allen Krankenkassen anerkannt sind. Die Leistungen im Bereich der Hauswirtschaft fallen, falls vom Arzt verordnet, unter die Zusatzversicherung und werden entsprechend des Deckungsumfangs übernommen.";
        tags = "Kosten Krankenkasse Dienstleistung";
        category = FAQEntry.Category.CATEGORY_GENERAL;
        faqEntries.add(new FAQEntry(question, answer, tags, category));

        question = "Welche Kosten können der Ergänzungsleistung übertragen werden?";
        answer = "Nach dem Grundsatz der sozialen Sicherheit soll jedem Einwohner und jeder Einwohnerin unabhängig von Stellung, Tätigkeit oder Alter in allen Wechselfällen des Lebens der Lebensunterhalt angemessen gewährleistet werden. Decken die von den Sozialversicherungen ausgerichteten Renten das Existenzminimum nicht, schliessen die Ergänzungsleistungen und Zuschüsse die bestehende finanzielle Lücke (Lebensunterhalt, Pflege- und Betreuungsleistungen, Hilfsmittel etc.). Für weitere Auskünfte wenden Sie sich an das Alters- und Versicherungsamt der Stadt Bern.";
        tags = "Kosten Ergänzungsleistungen";
        category = FAQEntry.Category.CATEGORY_GENERAL;
        faqEntries.add(new FAQEntry(question, answer, tags, category));

        question = "In welchem Zeitraum findet das Dienstleistungsangebot statt?";
        answer = "SPITEX BERN bietet mit ihren spezifisch qualifizierten Mitarbeitenden professionelle Pflege rund um die Uhr - von Montag bis Sonntag (7 x 24 Stunden) - an.";
        tags = "Zeit Dienstleistung";
        category = FAQEntry.Category.CATEGORY_GENERAL;
        faqEntries.add(new FAQEntry(question, answer, tags, category));

        question = "Übernehmen Sie auch Reinigungsarbeiten und Umzüge?";
        answer = "Seit 1. April 2014 werden die hauswirtschaftlichen und sozialbetreuerischen Leistungen wiefolgt erbracht:\n" +
                "\n" +
                "        Hauswirtschaftseinsätze (HW; „Wochenkehr“, Monatsreinigung): Diese Einsätze werden durch die BelleVie Suisse AG, ein Unternehmen der SPITEX BERN, erbracht.\n" +
                "        Hauswirtschaftliche und sozialbetreuerische Leistungen (HWSL), welche täglich anfallen, weniger als eine Stunde dauern und mit Grund- oder Behandlungspflege kombiniert werden müssen: Diese Einsätze werden weiterhin durch die SPITEX BERN erbracht.\n" +
                "                Für individuelle Wünsche oder Umzüge steht Ihnen unsere Tochterfirma BelleVie gerne zur Verfügung.";
        tags = "Reinigung Umzug";
        category = FAQEntry.Category.CATEGORY_GENERAL;
        faqEntries.add(new FAQEntry(question, answer, tags, category));

        question = "Wie rasch kann die Betreuung übernommen werden?";
        answer = "Jeweils innerhalb von 24 Stunden.";
        tags = "Zeit Betreuung";
        category = FAQEntry.Category.CATEGORY_GENERAL;
        faqEntries.add(new FAQEntry(question, answer, tags, category));

        question = "Wie muss ich mich anmelden? Ablauf? Was passiert nach meiner Anmeldung?";
        answer = "Sie können Ihre Anmeldung per Telefon oder E-Mail tätigen. Als Zuweiser steht Ihnen die Online-Patientenanmeldung (OPAN) zur Verfügung. Die administrative Anmeldung wird an den betreuenden Betrieb weitergeleitet. Der Betrieb vereinbart den ersten Termin mit dem Kunden.";
        tags = "Zeit Anmeldung";
        category = FAQEntry.Category.CATEGORY_GENERAL;
        faqEntries.add(new FAQEntry(question, answer, tags, category));

        question = "Wer kümmert sich um das Bedarfsmeldeformular?";
        answer = "Die SPITEX BERN ermittelt den Bedarf und bereitet das Formular vor. Anschliessend schickt sie es an den Arzt zum Unterschreiben und danach an die zuständige Krankenkasse.";
        tags = "Bedarfsmeldeformular";
        category = FAQEntry.Category.CATEGORY_GENERAL;
        faqEntries.add(new FAQEntry(question, answer, tags, category));

        question = "Vermieten wir Hilfsmittel?";
        answer = "Nein, aber wir können Ihnen gerne entsprechende Adressen angeben.";
        tags = "Hilfsmittel";
        category = FAQEntry.Category.CATEGORY_GENERAL;
        faqEntries.add(new FAQEntry(question, answer, tags, category));

        question = "Bieten wir Fahrdienste an?";
        answer = "Nein, aber wir können Ihnen gerne entsprechende Adressen angeben.";
        tags = "Fahrdienst";
        category = FAQEntry.Category.CATEGORY_GENERAL;
        faqEntries.add(new FAQEntry(question, answer, tags, category));

        return faqEntries;
    }
}
