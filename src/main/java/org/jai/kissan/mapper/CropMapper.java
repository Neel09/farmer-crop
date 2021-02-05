package org.jai.kissan.mapper;

import org.jai.kissan.api.farmer.crop.model.Crop;
import org.jai.kissan.persistence.entities.CropEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CropMapper {

    Crop entityToApiModelMapper(CropEntity cropEntity);

    CropEntity apiModelToEntityMapper(Crop crop);
}
