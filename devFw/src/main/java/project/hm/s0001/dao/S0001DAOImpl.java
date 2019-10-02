package project.hm.s0001.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import project.hm.s0001.vo.S0001VO;


@Repository("s0001DAO")
public class S0001DAOImpl implements S0001DAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<S0001VO> searchList(Map<String, Object> searchMap) throws DataAccessException {
		List<S0001VO> list = sqlSession.selectList("hm.s0001.searchList", searchMap);
		return list;
	}

	@Override
	public void insertData(Map<String, String> row) throws DataAccessException {
		sqlSession.update("hm.s0001.insertData", row);
	}

	@Override
	public void updateData(Map<String, String> row) throws DataAccessException {
		sqlSession.update("hm.s0001.updateData", row);
	}

	@Override
	public void deleteData(Map<String, String> row) throws DataAccessException {
		sqlSession.update("hm.s0001.deleteData", row);
	}

}
