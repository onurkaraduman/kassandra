package com.kassandra.job;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by onur on 07.08.17.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class NewsJobTest {


    @Autowired
    @Qualifier("newsJob")
    private Job newsJob;

    @Test
    public void execute() throws Exception {
        newsJob.execute();
    }

}