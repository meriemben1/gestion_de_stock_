package implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import models.user;
import repository.userrep;
import service.userser;

@Service
@Transactional
public class userimp implements userser {
 userrep userrepo;
	@Override
	public void addUser(String mdp, String role) {
		user u= new user();
		u.setMdp(mdp);
		u.setRole(role);
		userrepo.save(u);
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editUser(long id, String mdp, String role) {
		user u=userrepo.findById(id).get();
		u.setMdp(mdp);
		u.setRole(role);
		userrepo.save(u);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(long id) {
		userrepo.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public user getUser(long id) {
		// TODO Auto-generated method stub
		return userrepo.findById(id).get();
	}

	@Override
	public List<user> getAllUser() {
		// TODO Auto-generated method stub
		return userrepo.findAll();
	}
	

}
