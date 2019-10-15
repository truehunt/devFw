package hr.p0001.controller;

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

import hr.p0001.service.P0001Service;
import hr.p0001.vo.P0001VO;
import project.util.IBSheetUtil;

@Controller("p0001Controller")
public class P0001ControllerImpl implements P0001Controller {
	private static final Logger logger = LoggerFactory.getLogger(P0001ControllerImpl.class);
	@Autowired
	P0001Service p0001Service;
	@Autowired
	P0001VO p0001VO;
	
	@Override
	@RequestMapping(value = "/hr/p0001/searchInit.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView searchInit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		viewName = "/hr/p0001/searchInit";
		request.setCharacterEncoding("utf-8");
		//ModelAndView main = new ModelAndView("hr/p0001_init");
		ModelAndView main = new ModelAndView(viewName);
		return main;
	}
	
	@Override
	@RequestMapping(value = "/hr/p0001/searchList.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView searchList(@RequestParam(value="p_id", required=false) String p_id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		Map<String, Object> searchMap = new HashMap<String, Object>();
		searchMap.put("p_id", p_id);	 
		
		List list = p0001Service.searchList(searchMap);
		
		ModelAndView main = new ModelAndView("hr/p0001_search");
		main.addObject("searchList", list);
		return main;
	}
	
	@Override
	@RequestMapping(value = "/hr/p0001/searchMod.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView searchMod(@RequestParam(value="p_mod_id", required=false) String p_id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		Map<String, Object> searchMap = new HashMap<String, Object>();
		searchMap.put("p_id", p_id);
		
		List list = p0001Service.searchList(searchMap);
		if(!list.isEmpty()) {
			p0001VO = (P0001VO)list.get(0);
		}
		
		ModelAndView main = new ModelAndView("hr/p0001_mod");
		main.addObject("p0001VO", p0001VO);
		main.addObject("command", "modSearch");
		return main;
	}
	
	@Override
	@RequestMapping(value = "/hr/p0001/searchInsert.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView searchInsert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		ModelAndView main = new ModelAndView("hr/p0001_mod");
		main.addObject("command", "addSearch");
		return main;
	}

	@Override
	@RequestMapping(value = "/hr/p0001/updateMember.do", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public ResponseEntity updateMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Enumeration enu = request.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String value = request.getParameter(name);
			dataMap.put(name, value);
		}

		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders(); // 헤더변경 시 사용
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");		
		try {
			p0001Service.updateMember(dataMap);
			
			RequestDispatcher dispatch = request.getRequestDispatcher("/hm/p0001/searchList.do");
			dispatch.forward(request, response);
		} catch (Exception e) {
			message = " <script>";
			message += " alert('오류가 발생했습니다. 다시 시도해 주세요');";
			message += " location.href='" + request.getContextPath() + "/hm/p0001/searchInit.do'; ";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}		
		return resEnt;
	}
	
	@Override
	@RequestMapping(value = "/hr/p0001/insertMember.do", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public ResponseEntity insertMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Enumeration enu = request.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String value = request.getParameter(name);
			dataMap.put(name, value);
		}

		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders(); // 헤더변경 시 사용
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");		
		try {
			p0001Service.insertMember(dataMap);
			
			RequestDispatcher dispatch = request.getRequestDispatcher("/hr/p0001/searchList.do");
			dispatch.forward(request, response);
		} catch (Exception e) {
			message = " <script>";
			message += " alert('오류가 발생했습니다. 다시 시도해 주세요');";
			message += " location.href='" + request.getContextPath() + "/hr/p0001/searchInit.do'; ";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}		
		return resEnt;
	}	
	
	@RequestMapping(value = "/common/ajaxTest", produces="application/json", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> ajaxTest() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "hong");
		map.put("name", "홍길동");
		return map;
	}
	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String viewName = uri.substring(begin, end);
		if (viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
		}
		if (viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/",1), viewName.length());
		}
		return viewName;
	}
}
