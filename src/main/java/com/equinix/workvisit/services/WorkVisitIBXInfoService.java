package com.equinix.workvisit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.equinix.workvisit.model.WorkVisitIBXInfo;
import com.equinix.workvisit.repositories.WorkVisitIBXRepository;

/**
 * @author Sekhar
 *
 */
@Service("wvIBXService")
@Scope("prototype")
@Qualifier("wvIBXService")
@Transactional
public class WorkVisitIBXInfoService {

	@Autowired
	private WorkVisitIBXRepository workVisitIBXDao;

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public List<WorkVisitIBXInfo> findAll() {
		return (List<WorkVisitIBXInfo>) workVisitIBXDao.findAll();
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public List<WorkVisitIBXInfo> findByIbx(String ibx) {
		return (List<WorkVisitIBXInfo>) workVisitIBXDao.findByIbx(ibx);
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public List<WorkVisitIBXInfo> findByCage(String cage) {
		return (List<WorkVisitIBXInfo>) workVisitIBXDao.findByCage(cage);
	}
}