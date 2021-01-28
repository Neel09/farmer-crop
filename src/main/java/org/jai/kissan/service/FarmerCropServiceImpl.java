package org.jai.kissan.service;

import lombok.extern.slf4j.Slf4j;
import org.jai.kissan.model.Crop;
import org.jai.kissan.model.Farmer;
import org.jai.kissan.repository.CropRepository;
import org.jai.kissan.repository.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("registrationService")
@Slf4j
public class FarmerCropServiceImpl implements FarmerCropService {

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private CropRepository cropRepository;

    @Override
    public void doFarmerRegistration(Farmer farmer) {
        Farmer save = farmerRepository.save(farmer);
    }

    @Override
    public void createCrop(Crop crop) {
        cropRepository.save(crop);
    }

}
