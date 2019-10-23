package hr.system.p0003.service;

import java.util.Date;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import hr.system.p0003.vo.CalendarVO;
import hr.system.p0003.vo.MonthVO;
import hr.system.p0003.vo.SchDetailVO;
import hr.system.p0003.vo.SchVO;
import project.common.Field3VO;
import project.common.SearchVO;
import project.common.Util4calen;

@Service
public class SchSvc {

    @Autowired
    private SqlSessionTemplate sqlSession;    
    @Autowired
    private DataSourceTransactionManager txManager;

    static final Logger LOGGER = LoggerFactory.getLogger(SchSvc.class);
    
    public List<?> selectCalendar(MonthVO param, String userno) {
    	List<?> list = sqlSession.selectList("selectCalendar", param);
        
    	Field3VO fld = new Field3VO();
    	fld.setField1(userno);
    	for (int i=0; i<list.size(); i++){
    		CalendarVO cvo = (CalendarVO) list.get(i);
    		fld.setField2(cvo.getCDDATE());
    		cvo.setLIST( sqlSession.selectList("selectSchList4Calen", fld) );
    	}
        return list;
    }
     
    /** 
     * 리스트.
     */
    public Integer selectSchCount(SearchVO param) {
        return sqlSession.selectOne("selectSchCount", param);
    }
    
    public List<?> selectSchList(SearchVO param) {
        return sqlSession.selectList("selectSchList", param);
    }
    
    /**
     * 저장.
     */
    public void insertSch(SchVO param) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = txManager.getTransaction(def);
        
        try {
            if (param.getSSNO()==null || "".equals(param.getSSNO())) {
                sqlSession.insert("insertSch", param);
            } else {
                sqlSession.update("updateSch", param);
            }
            
            sqlSession.insert("deleteSchDetail", param.getSSNO());

            SchDetailVO param2 = new SchDetailVO();
            param2.setFK_SSNO(param.getSSNO());
            param2.setSDHOUR(param.getSSSTARTHOUR());
            param2.setSDMINUTE(param.getSSSTARTMINUTE());

            Integer inx = 1;
            Date sdate = Util4calen.str2Date(param.getSSSTARTDATE());
            if ("1".equals(param.getSSREPEATTYPE())) {			//반복없음
	            Date edate = Util4calen.str2Date(param.getSSENDDATE());
	            while (!sdate.after(edate)) {  
	                param2.setSDSEQ(inx++);
	                param2.setSDDATE( Util4calen.date2Str(sdate));
	            	sqlSession.insert("insertSchDetail", param2);
	            	sdate = Util4calen.dateAdd(sdate, 1);
	            }
            } else 
            if ("2".equals(param.getSSREPEATTYPE())) {			//주간반복
	            Date edate = Util4calen.str2Date(param.getSSREPEATEND());
	            
	            Integer dayofweek = Integer.parseInt(param.getSSREPEATOPTION()); 
	            while (!sdate.after(edate)) {  
	                if (Util4calen.getDayOfWeek(sdate)==dayofweek) break;
	            	sdate = Util4calen.dateAdd(sdate, 1);
	            }
	            while (!sdate.after(edate)) {  
	                param2.setSDSEQ(inx++);
	                param2.setSDDATE( Util4calen.date2Str(sdate));
	            	sqlSession.insert("insertSchDetail", param2);
	            	sdate = Util4calen.dateAdd(sdate, 7);
	            }
            } else 
            if ("3".equals(param.getSSREPEATTYPE())) {			//월간반복
	            Date edate = Util4calen.str2Date(param.getSSREPEATEND());
	            
	            Integer iYear = Util4calen.getYear(sdate);
	            Integer iMonth = Util4calen.getMonth(sdate);
	            String sday = param.getSSREPEATOPTION();
	            
	            Date ndate = Util4calen.str2Date(iYear + "-" + iMonth + "-" + sday);
	            if (sdate.after(ndate)) 
	                 sdate = Util4calen.str2Date(String.format("%s-%s-%s", iYear, ++iMonth, sday));
	            else sdate = ndate;
	            
	            while (!sdate.after(edate)) {
	                param2.setSDSEQ(inx++); 
	                param2.setSDDATE( Util4calen.date2Str(sdate));
	            	sqlSession.insert("insertSchDetail", param2);
	                sdate = Util4calen.str2Date(String.format("%s-%s-%s", iYear, ++iMonth, sday));
	            }            
	        }
            	
            txManager.commit(status);
        } catch (TransactionException ex) {
            txManager.rollback(status);
            LOGGER.error("insertSch");
        }            
    }

    /**
     * 읽기.
     */
    public SchVO selectSchOne(SchVO param) {
        return sqlSession.selectOne("selectSchOne", param);
    }
    
    public SchVO selectSchOne4Read(SchVO param) {
        return sqlSession.selectOne("selectSchOne4Read", param);
    }
    /**
     * 삭제.
     */
    public void deleteSch(SchVO param) {
        sqlSession.update("deleteSch", param);
    }
}
