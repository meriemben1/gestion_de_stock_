package service;

import java.util.List;

import models.produit;
import models.user;

public interface produitser {
	public void addProduit(String name,String desc,double prix, long commande , long fournisseur);
	public void editProduit(long id,String name,String desc,double prix ,  long commande , long fournisseur);
	public void deleteProduit(long id);
	public produit getProduit(long id);
	public List<produit>getAllProduit();
}
