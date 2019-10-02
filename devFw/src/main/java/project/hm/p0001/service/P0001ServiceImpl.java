package project.hm.p0001.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import project.hm.p0001.dao.P0001DAO;
import project.hm.p0001.vo.P0001VO;

@Service("p0001Service")
@Transactional(propagation = Propagation.REQUIRED)
public class P0001ServiceImpl implements P0001Service {
	@Autowired
	private P0001DAO p0001DAO;

	@Override
	public List<P0001VO> searchList(Map<String, Object> searchMap) throws DataAccessException {
		List<P0001VO> list =  p0001DAO.searchList(searchMap); 
		return list;
	}

	@Override
	public List<P0001VO> searchMod(Map<String, Object> searchMap) throws DataAccessException {
		List<P0001VO> list =  p0001DAO.searchMod(searchMap);
		return list;
	}

	@Override
	public List<P0001VO> searchAdd() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMember(Map<String, Object> datahMap) throws Exception {
		p0001DAO.updateMember(datahMap);
	}

	@Override
	public void insertMember(Map<String, Object> datahMap) throws Exception {
		p0001DAO.insertMember(datahMap);
	}

	@Override
	public void deleteMember(Map<String, Object> datahMap) throws Exception {
		p0001DAO.deleteMember(datahMap);
	}

}
