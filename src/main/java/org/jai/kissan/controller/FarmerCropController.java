package org.jai.kissan.controller;

import org.jai.kissan.api.farmer.crop.controller.IFarmerCropController;
import org.jai.kissan.api.farmer.crop.model.Crop;
import org.jai.kissan.api.farmer.crop.model.Farmer;
import org.jai.kissan.service.FarmerCropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
public class FarmerCropController implements IFarmerCropController {

	private final FarmerCropService farmerCropService;

	@Override
	public Mono<String> doFarmerRegistration(@RequestBody Farmer farmer) {
		
		log.info("Creating Farmer....");
		
		Mono<String> identityCode = farmerCropService.doFarmerRegistration(farmer);
		
		log.info("Farmer will be created when Spring calls subscribe method on given Mono....");
		
		return identityCode;
	}

	@Override
	public Mono<String> createCrop(@RequestBody Crop crop) {
		return farmerCropService.createCrop(crop);
	}

	@Override
	public Mono<Farmer> getFarmerDetails(@PathVariable String farmerIdentityCode) {
		return farmerCropService.getFarmer(farmerIdentityCode);
	}

	@Override
	public Mono<Crop> getCropDetails(@PathVariable String cropIdentityCode) {
		return farmerCropService.getCrop(cropIdentityCode);
	}

	@Override
	public Mono<Void> deleteFarmer(String farmerIdentityCode) {
		return farmerCropService.deleteFarmer(farmerIdentityCode);
	}
}
