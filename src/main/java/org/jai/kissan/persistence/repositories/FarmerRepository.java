package org.jai.kissan.persistence.repositories;

import org.jai.kissan.persistence.entities.FarmerEntity;
import org.springframework.data.repository.CrudRepository;

public interface FarmerRepository extends CrudRepository<FarmerEntity, String> {

	FarmerEntity findByIdentityCode(String farmerIdentityCode);

	void deleteByIdentityCode(String farmerIdentityCode);
}
