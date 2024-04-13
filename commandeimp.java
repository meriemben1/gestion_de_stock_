package implementation;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import models.commande;
import models.user;
import repository.commanderep;
import service.commandeser;

@Service
@Transactional
public class commandeimp implements commandeser{
commanderep commanderepo;
	@Override
	public void addCommande(int qnt, Date date, String statut) {
		commande c= new commande();
		c.setQnt(qnt);
		c.setDate(date);
		commanderepo.save(c);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editCommande(long id, int qnt, Date date, String statut) {
		commande c=commanderepo.findById(id).get();
		c.setQnt(qnt);
		c.setDate(date);
		commanderepo.save(c);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCommande(long id) {
		commanderepo.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public commande getCommande(long id) {
		
		// TODO Auto-generated method stub
		return commanderepo.findById(id).get();
	}

	@Override
	public List<commande> getAllCommande() {
		// TODO Auto-generated method stub
		return commanderepo.findAll();
	}

}

