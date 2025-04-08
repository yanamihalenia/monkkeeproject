package pages;

import constants.IConstants;
import elements.Button;
import elements.Checkbox;
import elements.Input;

public class BasePage implements IConstants {
    Input input = new Input();
    Checkbox checkbox = new Checkbox();
    Button button = new Button();

    public BasePage(){
    }
}
