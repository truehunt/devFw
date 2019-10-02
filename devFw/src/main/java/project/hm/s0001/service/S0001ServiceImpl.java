package project.hm.s0001.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import project.hm.s0001.dao.S0001DAO;
import project.hm.s0001.vo.S0001VO;

@Service("s0001Service")
@Transactional(propagation = Propagation.REQUIRED)
public class S0001ServiceImpl implements S0001Service {
	@Autowired
	private S0001DAO s0001DAO;

	@Override
	public List<S0001VO> searchList(Map<String, Object> searchMap) throws DataAccessException {
		List<S0001VO> list =  s0001DAO.searchList(searchMap); 
		return list;
	}

	@Override
	public void saveData(Map<String, String[]> dataMap)  throws DataAccessException  {
		String[] status = dataMap.get("STATUS");
		int length = status.length; // row수
		int i = 0;
		
		for(String str : status) {
			Map<String, String> row = getRow(dataMap, length, i); // 현재 Index의 Row Map
			if("I".equals(str)) { // 추가
				s0001DAO.insertData(row);
			}else if("U".equals(str)) { // 수정
				s0001DAO.updateData(row);
			}else if("D".equals(str)) { // 삭제
				s0001DAO.deleteData(row);
			}
			i++;
		}
	}
	
	private Map getRow(Map<String, String[]> dataMap, int length, int index) {
		Map<String, String> row = new HashMap<String, String>();
		for(String name : dataMap.keySet()) {
			String[] data = dataMap.get(name);
			if(length == data.length) {
				row.put(name, data[index]);
			}
		}		
		return row;
	}	
}
