package ch1.helloworld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch1.helloworld.domain.City;
import ch1.helloworld.service.ICityService;

@RestController
public class CityRestController {
	
	@Autowired
	private ICityService cityService;
	
	@RequestMapping(value="/api/city/{id}",method=RequestMethod.GET)
	public City findOneCity(@PathVariable("id") long id){
		return cityService.findCityById(id);
	}
	
	@RequestMapping(value="/api/allcity",method=RequestMethod.GET)
	public List<City> findAllCity(){
		return cityService.findAllCity();
	}
	
    @RequestMapping(value = "/api/city", method = RequestMethod.POST)
    public void createCity(@RequestBody City city) {
        cityService.saveCity(city);
    }
    
    @RequestMapping(value = "/api/city", method = RequestMethod.PUT)
    public void modifyCity(@RequestBody City city) {
        cityService.updateCity(city);
    }
    
    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.DELETE)
    public void modifyCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
    }
}
