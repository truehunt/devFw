package project.hm.p0001.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import project.hm.p0001.vo.P0001VO;

public interface P0001DAO {
	 public List<P0001VO> searchList(Map<String, Object> searchMap) throws DataAccessException;
	 public List<P0001VO> searchMod(Map<String, Object> searchMap) throws DataAccessException;
	 public List<P0001VO> searchAdd() throws DataAccessException;
	 
	 public void updateMember(Map<String, Object> datahMap) throws DataAccessException;
	 public void insertMember(Map<String, Object> datahMap) throws DataAccessException;
	 public void deleteMember(Map<String, Object> datahMap) throws DataAccessException;
	 
}
