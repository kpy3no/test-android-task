package com.example.evgeny.testtask;

/**
 * Created by palevo on 04.05.2017.
 */

import com.example.evgeny.testtask.Validate.EmailValidator;
import com.example.evgeny.testtask.Validate.PhoneValidator;

import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TelephoneValidatorTest {

    private PhoneValidator phoneValidator;

    @BeforeClass
    public void initData() {
        phoneValidator = new PhoneValidator();
    }

    @DataProvider
    public Object[][] ValidPhoneProvider() {
        return new Object[][] {
                {
                        new String[] {
                                "+79139139134",
                                "+79139139135",
                                "+74339139135",
                        }
                }
        };
    }

    @DataProvider
    public Object[][] InvalidPhoneProvider() {
        return new Object[][] {
                {
                        new String[] {
                                "-79139139134",
                                "879139139135",
                                "+7884339139135",
                        }
                }
        };
    }

    @Test(dataProvider = "ValidPhoneProvider")
    public void ValidEmailTest(String[] Email) {

        for (String temp : Email) {
            boolean valid = phoneValidator.validate(temp);
            System.out.println("Email: " + temp + " -> " + valid);
            Assert.assertEquals(valid, true);
        }

    }

    @Test(dataProvider = "InvalidPhoneProvider", dependsOnMethods = "ValidEmailTest")
    public void InValidEmailTest(String[] Email) {

        for (String temp : Email) {
            boolean valid = phoneValidator.validate(temp);
            System.out.println("Email: " + temp + " -> " + valid);
            Assert.assertEquals(valid, false);
        }
    }

}