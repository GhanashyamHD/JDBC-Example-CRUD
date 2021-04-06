package com.wolken.wolkenapp.service;

import com.wolken.wolkenapp.dao.PrisonDAO;
import com.wolken.wolkenapp.dao.PrisonDAOImpl;
import com.wolken.wolkenapp.dto.PrisonDTO;

public class PrisonServiceImpl implements PrisonService {

	PrisonDAO pd = new PrisonDAOImpl();

	@Override
	public boolean validateAndUpdate(int idToBeUpdated, String updatedName) {

		// TODO Auto-generated method st
		if (idToBeUpdated > 0) {
			if (updatedName != null)
				pd.updatebyId(idToBeUpdated, updatedName);
		} else {
			System.out.println("invalid id or name");
		}
		return false;
	}

	@Override
	public boolean validateInputAndInsert(PrisonDTO pdto) {
		if (pdto != null) {
			if (pdto.getId() > 0)
				if (pdto.getName() != null && pdto.getName().length() > 1)
					if (pdto.getPlace() != null && pdto.getPlace().length() > 1)
						if (pdto.getNo_of_prisoners() > 10)
							return pd.insert(pdto);

		} else {
			System.out.println("invalid entry");
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateAndDelete(int idToBeDeleted) {
		boolean vad;
		// TODO Auto-generated method stub
		if(idToBeDeleted >0 && idToBeDeleted < 1000)
		vad = pd.deletebyId(idToBeDeleted);
		else {System.out.println("Wrong ID");}
		return false;
	}

}