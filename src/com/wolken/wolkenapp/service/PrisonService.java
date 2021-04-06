package com.wolken.wolkenapp.service;

import com.wolken.wolkenapp.dto.PrisonDTO;

public interface PrisonService {

	public boolean validateInputAndInsert(PrisonDTO pdto);

	public boolean validateAndUpdate(int idToBeUpdated, String updatedName);
	
	public boolean validateAndDelete(int idToBeDeleted);
}
