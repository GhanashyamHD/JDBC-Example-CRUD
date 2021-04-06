package com.wolken.wolkenapp.dao;

import java.sql.SQLException;

import com.wolken.wolkenapp.dto.PrisonDTO;

public interface PrisonDAO {

	public boolean insert(PrisonDTO pd);

	public void display() throws SQLException;

	public boolean updatebyId(int prisonId, String prisonName);

	public boolean deletebyId(int prisonId);
}
