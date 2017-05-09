package com.example.evgeny.testtask;

import com.example.evgeny.testtask.Validate.NumberValidator;

import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by palevo on 04.05.2017.
 */

public class NumberValidatorTest {
    private NumberValidator numberValidator;

    @BeforeClass
    public void initData() {
        numberValidator = new NumberValidator();
    }

    @DataProvider
    public Object[][] ValidNumberProvider() {
        return new Object[][] {
                {
                        new String[] {
                                "7978458",
                                "00000",
                                "1256465",
                        }
                }
        };
    }

    @DataProvider
    public Object[][] InvalidNumberProvider() {
        return new Object[][] {
                {
                        new String[] {
                                "-79139139134",
                                "88",
                                "adsa",
                        }
                }
        };
    }

    @Test(dataProvider = "ValidNumberProvider")
    public void ValidNumberTest(String[] Email) {

        for (String temp : Email) {
            boolean valid = numberValidator.validate(temp);
            System.out.println("Email: " + temp + " -> " + valid);
            Assert.assertEquals(valid, true);
        }

    }

    @Test(dataProvider = "InvalidNumberProvider", dependsOnMethods = "ValidNumberTest")
    public void InValidNumberTest(String[] Email) {

        for (String temp : Email) {
            boolean valid = numberValidator.validate(temp);
            System.out.println("Email: " + temp + " -> " + valid);
            Assert.assertEquals(valid, false);
        }
    }
}
