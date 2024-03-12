package com.clubsProjet.api.services;

import java.util.List;

import com.clubsProjet.api.DTO.SalleDTO;
import com.clubsProjet.api.exceptions.SalleNotFoundException;
import com.clubsProjet.api.models.Salle;
import com.clubsProjet.api.repositories.SalleRepository;

public class SalleServiceImpl implements SalleService{

	private SalleRepository salleRepository;
	
	@Override
	public List<Salle> getAllSalles() {
		// TODO Auto-generated method stub
		return this.salleRepository.findAll();
	}

	@Override
	public Salle createSalle(Salle salle) {
		// TODO Auto-generated method stub
		return this.salleRepository.save(salle);
	}

	@Override
	public Salle updateSalle(int salleId, SalleDTO salle) {
		// TODO Auto-generated method stub
		Salle s=this.salleRepository.findById(salleId).orElseThrow(()->new SalleNotFoundException("Salle inexistante !"));
		s.setId(salleId);
		s.setLibelle(salle.getLibelle());
		s.setDepartement(salle.getDepartement());;
		s.setReserve(salle.isReserve());
		return s;
	}

	@Override
	public void deleteSalle(int salleId) {
		// TODO Auto-generated method stub
		Salle s=this.salleRepository.findById(salleId).orElseThrow(()->new SalleNotFoundException("Salle inexistante !"));
		this.salleRepository.delete(s);
	}

}
