package org.jai.kissan.controller;

import org.jai.kissan.model.Crop;
import org.jai.kissan.model.Farmer;
import org.jai.kissan.service.FarmerCropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("farmer-crop")
public class FarmerCropController {

    @Autowired
    private FarmerCropService farmerCropService;

    @PostMapping("farmer-registration")
    public void doRegistration(@RequestBody Farmer farmer){
        farmerCropService.doFarmerRegistration(farmer);
    }

    @PostMapping("create-crop")
    public void createCrop(@RequestBody Crop crop){
        farmerCropService.createCrop(crop);
    }
}
