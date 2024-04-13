package implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import models.produit;
import models.user;
import repository.produitrep;
import service.produitser;

@Service
@Transactional
public class produitimp implements produitser {
produitrep prod;
	@Override
	public void addProduit(String name, String desc, double prix, long commande , long fournisseur ) {
		produit p=new produit();
		p.setName(name);
		p.setDesc(desc);
		p.setPrix(prix);
		prod.save(p);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editProduit(long id, String name, String desc, double prix ,  long commande , long fournisseur) {
		produit p=prod.findById(id).get();
		p.setName(name);
		p.setDesc(desc);
		p.setPrix(prix);
		prod.save(p);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduit(long id) {
		prod.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public produit getProduit(long id) {
		// TODO Auto-generated method stub
		return prod.findById(id).get();
	}

	@Override
	public List<produit> getAllProduit() {
		// TODO Auto-generated method stub
		return prod.findAll();
	}

}
