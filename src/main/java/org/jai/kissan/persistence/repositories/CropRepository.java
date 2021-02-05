package org.jai.kissan.persistence.repositories;

import org.jai.kissan.persistence.entities.CropEntity;
import org.springframework.data.repository.CrudRepository;

public interface CropRepository extends CrudRepository<CropEntity, String> {

    CropEntity findByIdentityCode(String cropIdentityCode);
}
