package implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import models.stock;
import models.user;
import repository.stockrep;
import service.stockser;

@Service
@Transactional
public class stockimp implements stockser {
stockrep stockrepo;
	@Override
	public void addstock(int qnt, int s_min, int s_max, long produit) {
		stock s= new stock();
		s.setQnt(qnt);
		s.setS_min(s_min);
		s.setS_max(s_max);
		stockrepo.save(s);
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editstock(long id, int qnt, int s_min, int s_max , long produit) {
		stock s=stockrepo.findById(id).get();
		s.setQnt(qnt);
		s.setS_min(s_min);
		s.setS_max(s_max);
		stockrepo.save(s);
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStock(long id) {
		stockrepo.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public stock getStock(long id) {
		// TODO Auto-generated method stub
		return stockrepo.findById(id).get();
	}

	@Override
	public List<stock> getAllStock() {
		// TODO Auto-generated method stub
		return stockrepo.findAll();
	}

}
