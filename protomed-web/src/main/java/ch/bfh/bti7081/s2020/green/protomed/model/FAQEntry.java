package ch.bfh.bti7081.s2020.green.protomed.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;

@DatabaseTable(tableName = "faq_entry")
public class FAQEntry {

    public enum Category {
        CATEGORY_GENERAL,
        CATEGORY_APPRENTICES,
        CATEGORY_DEPRESSION,
    }

    @DatabaseField(generatedId = true) private Long id;

    @Getter @DatabaseField(columnDefinition = "VARCHAR(800)")
    private String question;

    @Getter @DatabaseField(columnDefinition = "VARCHAR(800)")
    private String answer;

    @Getter @DatabaseField
    private String tags;

    @Getter @DatabaseField(dataType = DataType.ENUM_INTEGER)
    private Category category;

    /// open scope no-argument constructor required for ORMLite
    public FAQEntry(){
        //
    }

    public FAQEntry(String question, String answer, String tags, Category category){
        this.question = question;
        this.answer = answer;
        this.tags = tags;
        this.category = category;
    }
}
