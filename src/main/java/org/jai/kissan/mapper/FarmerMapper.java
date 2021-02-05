package org.jai.kissan.mapper;

import org.jai.kissan.api.farmer.crop.model.Farmer;
import org.jai.kissan.persistence.entities.FarmerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FarmerMapper {

    FarmerEntity apiModelToEntityMapper(Farmer farmer);

    Farmer entityToApiModelMapper(FarmerEntity farmerEntity);
}
