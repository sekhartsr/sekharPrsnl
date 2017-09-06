package com.equinix.workvisit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.equinix.workvisit.model.WorkVisitUsers;
import com.equinix.workvisit.repositories.WorkVisitUsersRepository;

/**
 * @author Sekhar
 *
 */
@Service("wvUsersService")
@Scope("prototype")
@Qualifier("wvUsersService")
@Transactional
public class WorkVisitUsersService {

	@Autowired
	private WorkVisitUsersRepository WorkVisitUsersDao;

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public List<WorkVisitUsers> findAll() {
		return (List<WorkVisitUsers>) WorkVisitUsersDao.findAll();
	}

}