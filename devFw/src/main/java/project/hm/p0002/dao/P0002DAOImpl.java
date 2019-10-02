package project.hm.p0002.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import project.hm.p0002.vo.P0002VO;


@Repository("p0002DAO") 
public class P0002DAOImpl implements P0002DAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<P0002VO> searchMember(Map<String, Object> searchMap) throws DataAccessException {
		List<P0002VO> list = sqlSession.selectList("hm.p0002.searchMember", searchMap);
		return list;
	}

	@Override
	public void updateMember(Map<String, Object> datahMap) throws DataAccessException {
		sqlSession.update("hm.p0002.updateMember", datahMap);
	}

	@Override
	public void insertMember(Map<String, Object> datahMap) throws DataAccessException {
		sqlSession.update("hm.p0002.insertMember", datahMap);
	}

	@Override
	public void deleteMember(Map<String, Object> datahMap) throws DataAccessException {
		sqlSession.update("hm.p0002.deleteMember", datahMap);
	}

}
