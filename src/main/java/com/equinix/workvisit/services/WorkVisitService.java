package com.equinix.workvisit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.equinix.workvisit.GenericRepository;
import com.equinix.workvisit.model.WorkVisit;
import com.equinix.workvisit.repositories.WorkVisitRepository;

@Service("wvService")
@Scope("prototype")
@Qualifier("wvService")
@Transactional
public class WorkVisitService extends AbstractService<WorkVisit, Integer> {

	@Autowired
	private WorkVisitRepository WorkVisitDao;

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public List<WorkVisit> findAll() {
		return (List<WorkVisit>) WorkVisitDao.findAll();
	}

	public boolean delete(Integer id) {
		return super.delete(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public GenericRepository<WorkVisit> primaryDao() {
		return (GenericRepository<WorkVisit>) WorkVisitDao;
	}

}