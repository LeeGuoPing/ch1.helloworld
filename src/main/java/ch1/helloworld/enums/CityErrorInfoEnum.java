package ch1.helloworld.enums;

import ch1.helloworld.result.ErrorInfoInterface;

/**
 * 
 * @author liguoping
 *
 * 2018年4月16日-下午2:53:24
 *
 * @function 业务错误码 案例
 */
public enum CityErrorInfoEnum implements ErrorInfoInterface{
	
	PARAMS_NO_COMPLETE("000001","params no complete"),
	CITY_EXIT("000002","city exit");
		
	private String code;

    private String message;

    CityErrorInfoEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode(){
        return this.code;
    }

    public String getMessage(){
        return this.message;
    }
}
