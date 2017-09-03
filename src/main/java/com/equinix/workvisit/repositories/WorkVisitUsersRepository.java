package com.equinix.workvisit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.equinix.workvisit.model.WorkVisitUsers;

/**
 * @author sekhar
 *
 */
@RepositoryRestResource
public interface WorkVisitUsersRepository extends CrudRepository<WorkVisitUsers, Integer> {
	
}
