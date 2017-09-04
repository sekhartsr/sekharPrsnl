package com.equinix.workvisit.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.equinix.workvisit.model.WorkVisit;

/**
 * @author sekhar
 *
 */
@RepositoryRestResource
public interface WorkVisitRepository extends CrudRepository<WorkVisit, Integer> {

	@Query("select u from WorkVisit u where u.workVisitUser = :workVisitUser ")
	public WorkVisit findByUserName(@Param("workVisitUser") String workVisitUser);
}
