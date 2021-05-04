package org.jai.kissan.service;

import org.jai.kissan.api.exception.CreateDataException;
import org.jai.kissan.api.exception.ReadDataException;
import org.jai.kissan.api.farmer.crop.model.Crop;
import org.jai.kissan.api.farmer.crop.model.Farmer;
import org.jai.kissan.mapper.CropMapper;
import org.jai.kissan.mapper.FarmerMapper;
import org.jai.kissan.persistence.entities.CropEntity;
import org.jai.kissan.persistence.entities.FarmerEntity;
import org.jai.kissan.persistence.repositories.CropRepository;
import org.jai.kissan.persistence.repositories.FarmerRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
@Slf4j
@RequiredArgsConstructor
public class FarmerCropServiceImpl implements FarmerCropService {

	private final FarmerMapper farmerMapper;
	private final CropMapper cropMapper;
	private final FarmerRepository farmerRepository;
	private final CropRepository cropRepository;

	@Override
	public Mono<String> doFarmerRegistration(Farmer farmer) {
		return runFarmerCodeAsync(
				Mono.fromCallable(() -> farmerRepository.save(farmerMapper.apiModelToEntityMapper(farmer))).onErrorMap(
						DataIntegrityViolationException.class,
						(error) -> new CreateDataException("Duplicate farmer!!" + error.getMessage())))
								.map(e -> e.getIdentityCode());
	}

	@Override
	public Mono<String> createCrop(Crop crop) {
		return runCropCodeAsync(Mono.fromCallable(() -> cropRepository.save(cropMapper.apiModelToEntityMapper(crop))))
				.map(e -> e.getIdentityCode());
	}

	@Override
	public Mono<Farmer> getFarmer(String farmerIdentityCode) {
		return runFarmerCodeAsync(Mono.fromCallable(() -> farmerRepository.findByIdentityCode(farmerIdentityCode)))
				.switchIfEmpty(Mono.error(new ReadDataException("Farmer Identity not found!" + farmerIdentityCode)))
				.map(farmerMapper::entityToApiModelMapper);
	}

	@Override
	public Mono<Crop> getCrop(String cropIdentityCode) {
		return runCropCodeAsync(Mono.fromCallable(() -> cropRepository.findByIdentityCode(cropIdentityCode)))
				.switchIfEmpty(Mono.error(new ReadDataException("Crop Identity not found!" + cropIdentityCode)))
				.map(cropMapper::entityToApiModelMapper);
	}

	@Override
	public Mono<Void> deleteFarmer(String farmerIdentityCode) {

		return Mono.fromRunnable(() -> farmerRepository.deleteByIdentityCode(farmerIdentityCode))
				.subscribeOn(Schedulers.boundedElastic()).then();
	}

	private Mono<FarmerEntity> runFarmerCodeAsync(Mono<FarmerEntity> farmerMono) {
		return farmerMono.subscribeOn(Schedulers.boundedElastic());
	}

	private Mono<CropEntity> runCropCodeAsync(Mono<CropEntity> cropMono) {
		return cropMono.subscribeOn(Schedulers.boundedElastic());
	}

}
