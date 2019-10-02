package project.hm.s0001.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import project.hm.s0001.vo.S0001VO;

public interface S0001DAO {
	 public List<S0001VO> searchList(Map<String, Object> searchMap) throws DataAccessException;

	public void insertData(Map<String, String> row) throws DataAccessException;

	public void updateData(Map<String, String> row) throws DataAccessException;

	public void deleteData(Map<String, String> row) throws DataAccessException;
	 
}
