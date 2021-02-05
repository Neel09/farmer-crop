package org.jai.kissan.controller;

import lombok.extern.slf4j.Slf4j;
import org.jai.kissan.api.farmer.crop.controller.IFarmerCropController;
import org.jai.kissan.api.farmer.crop.model.Crop;
import org.jai.kissan.api.farmer.crop.model.Farmer;
import org.jai.kissan.service.FarmerCropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class FarmerCropController implements IFarmerCropController {

    private final FarmerCropService farmerCropService;

    @Autowired
    public FarmerCropController(FarmerCropService farmerCropService) {
        this.farmerCropService = farmerCropService;
    }

    @Override
    public String doFarmerRegistration(@RequestBody Farmer farmer) {
        return farmerCropService.doFarmerRegistration(farmer);
    }

    @Override
    public String createCrop(@RequestBody Crop crop) {
        return farmerCropService.createCrop(crop);
    }

    @Override
    public Farmer getFarmerDetails(@PathVariable String farmerIdentityCode) {
        return farmerCropService.getFarmer(farmerIdentityCode);
    }

    @Override
    public Farmer getCropDetails(@PathVariable String cropIdentityCode) {
        return farmerCropService.getFarmer(cropIdentityCode);
    }
}
