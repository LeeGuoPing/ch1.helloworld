package ch1.helloworld.test.spi;

import java.util.Iterator;
import java.util.ServiceLoader;
/**
 * 
 * @author liguoping
 *
 * 2018年5月24日-下午5:42:22
 *
 * @function SPI 测试
 */
public class ServiceMain {
	public static void main(String[] args) {
		ServiceLoader<DubboService> spiLoader = ServiceLoader.load(DubboService.class);  
        Iterator<DubboService>  iteratorSpi=spiLoader.iterator();  
        while (iteratorSpi.hasNext()){  
            DubboService dubboService=iteratorSpi.next();  
            dubboService.sayHello();  
        }  
	}
}
