package pages;

import constants.IConstants;
import elements.Button;
import elements.Checkbox;
import elements.DatePicker;
import elements.Input;
import waiters.Waiter;

public class BasePage implements IConstants {
    Input input = new Input();
    Button button = new Button();
    Waiter waiter = new Waiter();
    DatePicker datePicker = new DatePicker();

    public BasePage(){
    }
}
