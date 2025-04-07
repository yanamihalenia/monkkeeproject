package tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest{
    Faker faker = new Faker();

    @Test(description = "1. Registration")
    public void registerNewUserTest(){
        loginPage.goToRegisterPage();
        registerPage.fillRegisterForm(faker.internet().emailAddress(), faker.internet().password(), faker.animal().name());
        registerPage.confirmRegister();
    }
}
