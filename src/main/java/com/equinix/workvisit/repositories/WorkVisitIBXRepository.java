package com.equinix.workvisit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.equinix.workvisit.model.WorkVisitIBXInfo;


/**
 * @author sekhar
 *
 */
@RepositoryRestResource
public interface WorkVisitIBXRepository extends CrudRepository<WorkVisitIBXInfo, Integer> {


	@Query("select u from WorkVisitIBXInfo u where u.ibx = :ibx ")
	public List<WorkVisitIBXInfo> findByIbx(@Param("ibx") String ibx);
	
	@Query("select u from WorkVisitIBXInfo u where u.cage = :cage ")
	public List<WorkVisitIBXInfo> findByCage(@Param("cage") String cage);
}
