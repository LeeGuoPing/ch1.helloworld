package ch1.helloworld.controller;

import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch1.helloworld.domain.City;
import ch1.helloworld.enums.CityErrorInfoEnum;
import ch1.helloworld.result.GlobalErrorInfoException;
import ch1.helloworld.result.ResultBody;

@RestController
public class ErrorJsonController {

	/**
     * 获取城市接口
     *
     * @param cityName
     * @return
     * @throws GlobalErrorInfoException
     */
    @RequestMapping(value = "/api/city/error", method = RequestMethod.GET)
    public ResultBody findOneCity(ModelMap modelMap,@RequestParam("cityName") String cityName) throws GlobalErrorInfoException {
    	System.out.println(modelMap.get("author"));
        // 入参为空
        if (StringUtils.isEmpty(cityName)) {
            throw new GlobalErrorInfoException(CityErrorInfoEnum.PARAMS_NO_COMPLETE);
        }
        return new ResultBody(new City(1L,2L,"温岭","是我的故乡"));
    }
}
