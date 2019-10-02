package project.hm.p0002.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import project.hm.p0002.dao.P0002DAO;
import project.hm.p0002.vo.P0002VO;

@Service("p0002Service")
@Transactional(propagation = Propagation.REQUIRED)
public class P0002ServiceImpl implements P0002Service {
	@Autowired
	private P0002DAO p0002DAO;

	@Override
	public List<P0002VO> searchMember(Map<String, Object> searchMap) throws DataAccessException {
		List<P0002VO> list =  p0002DAO.searchMember(searchMap);
		return list;
	}

	@Override
	public void updateMember(Map<String, Object> datahMap) throws Exception {
		p0002DAO.updateMember(datahMap);
	}

	@Override
	public void insertMember(Map<String, Object> datahMap) throws Exception {
		p0002DAO.insertMember(datahMap);
	}

	@Override
	public void deleteMember(Map<String, Object> datahMap) throws Exception {
		p0002DAO.deleteMember(datahMap);
	}

}
