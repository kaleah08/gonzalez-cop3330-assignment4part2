package ucf.assignments;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalItem {
    private String description;
    private LocalDate date;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        String localDate = DateTimeFormatter.ISO_DATE.format(date);
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalItem(LocalDate date, String description){
        this.setDate(date);
        this.setDescription(description);
    }
    @Override
    public String toString(){
        return this.getDate() + " : " + this.getDescription();
    }
}
