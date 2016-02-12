package hr.pbz.sirius.admin.app.model.content;

import hr.pbz.sirius.admin.app.model.AbstractEntity;

import java.util.Date;

/**
 * Created by matija on 05.12.15..
 */
public abstract class BasicContent extends AbstractEntity {
    public enum ContentType {
        FOOTER,
        HEADER,
        GENERAL,
        ACCOUNTS
    };



    private ContentType type;
    private Date date;
    private Long maxCaloriesPerDay;

    public ContentType getType() {
        return type;
    }

    public void setType(ContentType type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getMaxCaloriesPerDay() {
        return maxCaloriesPerDay;
    }

    public void setMaxCaloriesPerDay(Long maxCaloriesPerDay) {
        this.maxCaloriesPerDay = maxCaloriesPerDay;
    }
}
