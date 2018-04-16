package ch1.helloworld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch1.helloworld.domain.City;
import ch1.helloworld.service.ICityService;

@Controller
@RequestMapping("/city")
public class CityController {
	
	@Autowired
	private ICityService cityService;
	
	@RequestMapping(value="/api/city/{id}",method=RequestMethod.GET)
	public String findOneCity(Model model,@PathVariable("id") Long id){
		model.addAttribute("city", cityService.findCityById(id));
		return "city";
	}
	
	@RequestMapping(value="/api/allcity",method = RequestMethod.GET)
	public String findAllCity(Model model){
		List<City> cityList = cityService.findAllCity();
		model.addAttribute("cityList",cityList);
		return "cityList";
	}
	
}
