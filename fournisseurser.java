package service;

import java.util.List;

import models.fournisseur;
import models.user;

public interface fournisseurser {
	public void addFournisseur(String nom,String adresse,int tel,String email);
	public void editFournisseur(long id,String nom,String adresse,int tel,String email);
	public void deleteFournisseur(long id);
	public fournisseur getFournisseur(long id);
	public List<fournisseur>getAllFournisseur();
}
