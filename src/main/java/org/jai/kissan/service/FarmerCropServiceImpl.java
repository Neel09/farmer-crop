package org.jai.kissan.service;

import org.jai.kissan.api.farmer.crop.model.Crop;
import org.jai.kissan.api.farmer.crop.model.Farmer;
import org.jai.kissan.mapper.CropMapper;
import org.jai.kissan.mapper.FarmerMapper;
import org.jai.kissan.persistence.entities.CropEntity;
import org.jai.kissan.persistence.entities.FarmerEntity;
import org.jai.kissan.persistence.repositories.CropRepository;
import org.jai.kissan.persistence.repositories.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service("registrationService")
@Slf4j
public class FarmerCropServiceImpl implements FarmerCropService {

	private final FarmerMapper farmerMapper;
	private final CropMapper cropMapper;
	private final FarmerRepository farmerRepository;
	private final CropRepository cropRepository;

	@Autowired
	public FarmerCropServiceImpl(FarmerMapper farmerMapper, CropMapper cropMapper, FarmerRepository farmerRepository,
			CropRepository cropRepository) {
		this.farmerMapper = farmerMapper;
		this.cropMapper = cropMapper;
		this.farmerRepository = farmerRepository;
		this.cropRepository = cropRepository;
	}

	@Override
	public String doFarmerRegistration(Farmer farmer) {
		return farmerRepository.save(farmerMapper.apiModelToEntityMapper(farmer)).getIdentityCode();
	}

	@Override
	public String createCrop(Crop crop) {
		return cropRepository.save(cropMapper.apiModelToEntityMapper(crop)).getIdentityCode();
	}

	@Override
	public Farmer getFarmer(String farmerIdentityCode) {
		FarmerEntity farmerEntity = farmerRepository.findByIdentityCode(farmerIdentityCode);
		return farmerMapper.entityToApiModelMapper(farmerEntity);
	}

	@Override
	public Crop getCrop(String cropIdentityCode) {
		CropEntity crop = cropRepository.findByIdentityCode(cropIdentityCode);
		return cropMapper.entityToApiModelMapper(crop);
	}

	@Override
	public void deleteFarmer(String farmerIdentityCode) {
		farmerRepository.deleteByIdentityCode(farmerIdentityCode);
	}

}
