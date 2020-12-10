package io.xream.demo;


import io.xream.demo.controller.HeatSupplyController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AppTest {

    @Autowired
    private HeatSupplyController controller;

    @Test
    public void testAll(){

        controller.create();

    }

}
