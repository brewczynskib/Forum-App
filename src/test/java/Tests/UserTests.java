package Tests;

import brewczynskib.Configuration.ConfigurationClass;
import brewczynskib.Configuration.SpringWebsiteInitializer;
import brewczynskib.Controllers.WebController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes ={ ConfigurationClass.class, SpringWebsiteInitializer.class})
@WebAppConfiguration
public class UserTests {


    @Autowired
    WebController controller;


    @Test
    public void controllerTest()
    {

    }

}
