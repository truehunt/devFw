package project.hm.s0001.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import project.hm.s0001.vo.S0001VO;

public interface S0001Service {
	 public List<S0001VO> searchList(Map<String, Object> searchMap) throws DataAccessException;

	public void saveData(Map<String, String[]> dataMap)  throws DataAccessException ;
}
