package com.kassandra.job;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by onur on 17.07.17.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CurrencyJobTest {

    @Autowired
    private CurrencyJob currencyJob;

    @Test
    public void execute() throws Exception {
        currencyJob.execute();
    }

}