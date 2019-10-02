package project.hm.p0002.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import project.hm.p0002.vo.P0002VO;

public interface P0002DAO {
	 public List<P0002VO> searchMember(Map<String, Object> searchMap) throws DataAccessException;
	 
	 public void updateMember(Map<String, Object> datahMap) throws DataAccessException;
	 public void insertMember(Map<String, Object> datahMap) throws DataAccessException;
	 public void deleteMember(Map<String, Object> datahMap) throws DataAccessException;
	 
}
