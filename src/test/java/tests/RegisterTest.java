package tests;

import org.testng.annotations.Test;

public class RegisterTest extends BaseTest{

    @Test(description = "1. Registration")
    public void registerNewUserTest(){
        registerSteps.registerUserAndCheckRegisterMessage(faker.internet().emailAddress(),
                faker.internet().password(),
                faker.animal().name());
    }
}
