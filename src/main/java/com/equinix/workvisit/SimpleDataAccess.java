package com.equinix.workvisit;

import java.io.Serializable;

import com.equinix.workvisit.model.AbstractEntity;


public interface SimpleDataAccess<S extends AbstractEntity, ID extends Serializable> {

	public <T extends AbstractEntity> S create(final S s);

	public <T extends AbstractEntity> S update(final S s);

	public <T extends AbstractEntity> S find(final Integer id);

	public boolean delete(final Integer id);

}
