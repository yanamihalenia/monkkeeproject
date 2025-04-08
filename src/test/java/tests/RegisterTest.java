package tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest{
    Faker faker = new Faker();

    @Test(description = "1. Registration")
    public void registerNewUserTest(){
        registerSteps.registerUser(faker.internet().emailAddress(), faker.internet().password(), faker.animal().name());
    }
}
