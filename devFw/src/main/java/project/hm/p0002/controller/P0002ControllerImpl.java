package project.hm.p0002.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import project.hm.p0002.service.P0002Service;
import project.hm.p0002.vo.P0002VO;

@Controller("p0002Controller")
public class P0002ControllerImpl implements P0002Controller {
	private static final Logger logger = LoggerFactory.getLogger(P0002ControllerImpl.class);
	@Autowired
	P0002Service p0002Service;
	@Autowired
	P0002VO p0002VO;
	
	@Override
	@RequestMapping(value = "/hm/p0002/searchInit.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView searchInit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView("hm/p0002_ajax");
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/hm/p0002/searchMember.do", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> searchMember(@RequestParam(value="p_id", required=false) String p_id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		Map<String, Object> searchMap = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		searchMap.put("p_id", p_id);	 
		
		List list = null;
		try {
			list = p0002Service.searchMember(searchMap);
			if(!list.isEmpty()) {
				p0002VO = (P0002VO)list.get(0);
				resultMap = BeanUtils.describe(p0002VO);
				resultMap.put("error_yn", "N");				
			}else {
				resultMap.put("error_yn", "Y");
				resultMap.put("error_text", "존재하지 않습니다");
			}
		}catch(Exception e) {
			resultMap.put("error_yn", "Y");
			resultMap.put("error_text", "에러발생");
			e.printStackTrace();
		}
		
		System.out.println("=======================>>"+resultMap.toString());
		return resultMap;
	}
	
	@Override
	public ModelAndView searchInsert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value = "/hm/p0002/updateMember.do", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> updateMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Enumeration enu = request.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String value = request.getParameter(name);
			dataMap.put(name, value);
		}
		
		System.out.println("=======================>>"+dataMap.toString());
		
		try {
			p0002Service.updateMember(dataMap);
			resultMap.put("error_yn", "N");	
		} catch (Exception e) {
			resultMap.put("error_yn", "Y");
			resultMap.put("error_text", "에러발생");
			e.printStackTrace();
		}		
		return resultMap;
	}
	
	@RequestMapping(value = "/ajaxTest")
	@ResponseBody
	public Map<String, Object> ajaxTest() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "hong");
		map.put("name", "홍길동");
		return map;
	}
}
