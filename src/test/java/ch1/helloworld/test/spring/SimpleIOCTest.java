package ch1.helloworld.test.spring;

import org.junit.Test;

/**
 * @author: liguoping
 * @Date: 2019/6/16 14:43
 * @Description:
 */
public class SimpleIOCTest {

    @Test
    public void loadBeans() throws Exception {
        String location = SimpleIOC.class.getClassLoader().getResource("ioc.xml").getFile();
        System.out.println(location);
        SimpleIOC bf = new SimpleIOC(location);
        Wheel wheel = (Wheel) bf.getBean("wheel");
        System.out.println(wheel);
        Car car = (Car) bf.getBean("car");
        System.out.println(car);
    }
}
