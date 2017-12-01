package com.api.zSpringBootApi.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.zSpringBootApi.model.ReqJson;
import com.api.zSpringBootApi.model.ResJson;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
@RestController
//@Controller // 차이점을 찾아보자.
public class CommonController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@RequestMapping("/hello")
	public String helloWorld() {
		return "helloWorld";
	}
	
	//Controller 기본 json방식
	@RequestMapping(value="/getBaseJsonData", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResJson jsonReturn(@RequestBody  String param) {
		System.out.println("param : " + param);
		try {
			ObjectMapper mapper = new ObjectMapper();
			//json 파라미터를 맵 형식으로 전환 Class 형식도 가능
			Map<String, Object> paramMap = mapper.readValue(param, new TypeReference<Map<String, Object>>(){});
			String test1 = (String) paramMap.get("test");
			
			System.out.println("test1 : " + test1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ResJson  ret = new ResJson();
		ret.setAge(20);
		ret.setName("kim");
		return ret;
	}
	
	//@RestController 기본 json방식
	@RequestMapping(value="/getRestJsonData") //@ResponseBody 없어도 기본 json방식으로 리턴함
	public ResJson restJsonReturn(@RequestBody ReqJson reqJson) {
		System.out.println("reqJson : " + reqJson.toString());
		
		ResJson  ret = new ResJson();
		ret.setAge(20);
//		ret.setName("홍길동");
		return ret;
	}
}
