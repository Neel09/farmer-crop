package org.jai.kissan.service;

import org.jai.kissan.api.farmer.crop.model.Crop;
import org.jai.kissan.api.farmer.crop.model.Farmer;

public interface FarmerCropService {

	public String doFarmerRegistration(Farmer farmer);

	public String createCrop(Crop crop);

	public Farmer getFarmer(String farmerIdentityCode);

	public Crop getCrop(String cropIdentityCode);

	public void deleteFarmer(String farmerIdentityCode);
}
