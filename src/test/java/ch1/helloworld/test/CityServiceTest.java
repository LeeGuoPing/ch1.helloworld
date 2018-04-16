package ch1.helloworld.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch1.helloworld.domain.City;
import ch1.helloworld.service.ICityService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
// @DirtiesContext
public class CityServiceTest {
	
	@Autowired
	private ICityService cityService;		
	
	
	@Test
	public void test01(){
		List<City> citys = cityService.findAllCity();
		System.out.println(citys.size());
	}
}
