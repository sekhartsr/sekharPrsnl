package com.equinix.workvisit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.equinix.workvisit.GenericRepository;
import com.equinix.workvisit.model.WorkVisitIBXInfo;
import com.equinix.workvisit.repositories.WorkVisitIBXRepository;

@Service("wvIBXService")
@Scope("prototype")
@Qualifier("wvIBXService")
@Transactional
public class WorkVisitIBXInfoService extends AbstractService<WorkVisitIBXInfo, Integer> {

	@Autowired
	private WorkVisitIBXRepository workVisitIBXDao;

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public List<WorkVisitIBXInfo> findAll() {
		return (List<WorkVisitIBXInfo>) workVisitIBXDao.findAll();
	}
/*
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public List<WorkVisitIBXInfo> findAllSector() {
		return workVisitIBXDao.findAllSubSectorBySectorId(0);
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public List<WorkVisitIBXInfo> findBySectorCode(String sectorCode) {
		return workVisitIBXDao.findBySectorCode(sectorCode);
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public WorkVisitIBXInfo findSectorBySectorCode(String sectorCode) {
		return workVisitIBXDao.findSectorBySectorCode(sectorCode);
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public WorkVisitIBXInfo findSubSectorBySectorCode(String sectorCode) {
		return workVisitIBXDao.findSubSectorBySectorCode(sectorCode);
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public List<WorkVisitIBXInfo> findAllSubSectorBySectorId(int sectorPid) {
		return workVisitIBXDao.findAllSubSectorBySectorId(sectorPid);
	}*/

	public boolean delete(Integer id) {
		return super.delete(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public GenericRepository<WorkVisitIBXInfo> primaryDao() {
		return (GenericRepository<WorkVisitIBXInfo>) workVisitIBXDao;
	}

}