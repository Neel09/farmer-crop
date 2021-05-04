package org.jai.kissan.service;

import org.jai.kissan.api.farmer.crop.model.Crop;
import org.jai.kissan.api.farmer.crop.model.Farmer;

import reactor.core.publisher.Mono;

public interface FarmerCropService {

	public Mono<String> doFarmerRegistration(Farmer farmer);

	public Mono<String> createCrop(Crop crop);

	public Mono<Farmer> getFarmer(String farmerIdentityCode);

	public Mono<Crop> getCrop(String cropIdentityCode);

	public Mono<Void> deleteFarmer(String farmerIdentityCode);
}
