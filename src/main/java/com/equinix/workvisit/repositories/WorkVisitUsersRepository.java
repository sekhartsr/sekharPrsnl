package com.equinix.workvisit.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.equinix.workvisit.model.WorkVisitUsers;

/**
 * @author sekhar
 *
 */
@RepositoryRestResource
public interface WorkVisitUsersRepository extends CrudRepository<WorkVisitUsers, Integer> {

	/*
	 * List<Task> findByTaskArchived(@Param("archivedfalse") int
	 * taskArchivedFalse); List<Task> findByTaskStatus(@Param("status") String
	 * taskStatus);
	 */
}
