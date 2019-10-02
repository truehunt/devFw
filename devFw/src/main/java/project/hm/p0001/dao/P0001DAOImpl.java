package project.hm.p0001.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import project.hm.p0001.vo.P0001VO;


@Repository("p0001DAO")
public class P0001DAOImpl implements P0001DAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<P0001VO> searchList(Map<String, Object> searchMap) throws DataAccessException {
		List<P0001VO> list = sqlSession.selectList("hm.p0001.searchList", searchMap);
		return list;
	}

	@Override
	public List<P0001VO> searchMod(Map<String, Object> searchMap) throws DataAccessException {
		List<P0001VO> list = sqlSession.selectList("hm.p0001.searchMod", searchMap);
		return list;
	}

	@Override
	public List<P0001VO> searchAdd() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMember(Map<String, Object> datahMap) throws DataAccessException {
		sqlSession.update("hm.p0001.updateMember", datahMap);
	}

	@Override
	public void insertMember(Map<String, Object> datahMap) throws DataAccessException {
		sqlSession.update("hm.p0001.insertMember", datahMap);
	}

	@Override
	public void deleteMember(Map<String, Object> datahMap) throws DataAccessException {
		sqlSession.update("hm.p0001.deleteMember", datahMap);
	}

}
