package com.equinix.workvisit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import com.equinix.workvisit.model.AbstractEntity;

@NoRepositoryBean
public interface GenericRepository<T extends AbstractEntity> extends JpaRepository<T, Integer>, JpaSpecificationExecutor<T> {
	
}