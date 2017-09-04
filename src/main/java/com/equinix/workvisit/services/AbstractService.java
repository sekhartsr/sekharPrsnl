package com.equinix.workvisit.services;

import java.sql.Timestamp;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.equinix.workvisit.GenericRepository;
import com.equinix.workvisit.SimpleDataAccess;
import com.equinix.workvisit.model.AbstractEntity;


@EnableTransactionManagement(mode=AdviceMode.PROXY,proxyTargetClass=true)
@Transactional
public abstract class AbstractService<S extends AbstractEntity,name> implements SimpleDataAccess<S,String>{

	protected static final String HEADER_MESSAGE_ID = "X-Message-Id";
	protected static final String HEADER_AUTHORIZATION = "Authorization";	
	
	public abstract GenericRepository<S> primaryDao();
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public <T extends AbstractEntity>S create(S s) {
		this.primaryDao().saveAndFlush(s);
		return s;
	}

	@Modifying(clearAutomatically = true)	
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public <T extends AbstractEntity>S update(S s) {
		this.primaryDao().saveAndFlush(s);
		return s;
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public <T extends AbstractEntity>S find(java.lang.Integer id) {
		return this.primaryDao().findOne(id);
	}

	@Modifying(clearAutomatically = true)
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public boolean delete(java.lang.Integer id) {
		try {
			this.primaryDao().delete(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	protected Timestamp getSQLTimestamp() {
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		return currentTimestamp;
	}
}
