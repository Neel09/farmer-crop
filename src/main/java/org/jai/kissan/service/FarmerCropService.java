package org.jai.kissan.service;

import org.jai.kissan.model.Crop;
import org.jai.kissan.model.Farmer;

public interface FarmerCropService {

    public void doFarmerRegistration(Farmer farmer);

    public void createCrop(Crop crop);
}
