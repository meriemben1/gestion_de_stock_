package implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import models.commande;
import models.fournisseur;
import repository.fournissuerrep;
import service.fournisseurser;

@Service
@Transactional
public class fournisseurimp implements fournisseurser{
	fournissuerrep fourni;
	@Override
	public void addFournisseur(String nom, String adresse, int tel, String email) {
		fournisseur f= new fournisseur();
		f.setNom(nom);
		f.setEmail(email);
		f.setTel(tel);
		f.setEmail(email);
		fourni.save(f);
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editFournisseur(long id, String nom, String adresse, int tel, String email) {
		fournisseur f=fourni.findById(id).get();
		f.setNom(nom);
		f.setEmail(email);
		f.setTel(tel);
		f.setEmail(email);
		fourni.save(f);
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFournisseur(long id) {
		fourni.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public fournisseur getFournisseur(long id) {
		
		// TODO Auto-generated method stub
		return fourni.findById(id).get();
	}

	@Override
	public List<fournisseur> getAllFournisseur() {
		// TODO Auto-generated method stub
		return fourni.findAll();
	}

}
