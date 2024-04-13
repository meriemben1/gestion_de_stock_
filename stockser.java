package service;

import java.util.List;

import models.stock;
import models.user;

public interface stockser {
	public void addstock(int qnt,int s_min,int s_max, long produit);
	public void editstock(long id,int qnt,int s_min,int s_max , long produit);
	public void deleteStock(long id);
	public stock getStock(long id);
	public List<stock>getAllStock();
	

}
