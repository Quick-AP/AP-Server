package com.ap.apserver.unitTest;

import com.ap.apserver.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class MenuTest {
    @Autowired
    private MenuService menuService;

    @Test
    public void testMenu(){
        System.out.println(menuService.queryFoodMenu());
    }
}
