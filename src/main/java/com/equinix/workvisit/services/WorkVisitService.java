package com.equinix.workvisit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.equinix.workvisit.model.WorkVisit;
import com.equinix.workvisit.repositories.WorkVisitRepository;

/**
 * @author Sekhar
 *
 */
@Service("wvService")
@Scope("prototype")
@Qualifier("wvService")
@Transactional
public class WorkVisitService {

	@Autowired
	private WorkVisitRepository WorkVisitDao;

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public List<WorkVisit> findAll() {
		return (List<WorkVisit>) WorkVisitDao.findAll();
	}
	
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public WorkVisit findByUserName(String workVisitUser) {
		return WorkVisitDao.findByUserName(workVisitUser);
	}

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public WorkVisit save(WorkVisit workVisit) {
		return WorkVisitDao.save(workVisit);
	}
}