package com.novawind.test;

import com.novawind.mourn.app.App;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Jeremy Xiong<br>
 * 2018-01-05 09:17
 */
@SpringBootTest(classes = App.class)
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class JunitTestConfig {
}
