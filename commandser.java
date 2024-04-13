package service;

import java.sql.Date;
import java.util.List;

import models.commande;
import models.user;

public interface commandeser {
	public void addCommande(int qnt,Date date,String statut);
	public void editCommande(long id,int qnt,Date date,String statut);
	public void deleteCommande(long id);
	public commande getCommande(long id);
	public List<commande>getAllCommande();

}
