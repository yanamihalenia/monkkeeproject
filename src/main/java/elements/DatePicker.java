package elements;

import com.codeborne.selenide.SelenideElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePicker {
    public void selectDate(LocalDate date, SelenideElement selenideElement) {
        String formattedDate = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        selenideElement.setValue(formattedDate);
    }
}
