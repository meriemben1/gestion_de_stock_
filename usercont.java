package controler;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.user;
import service.userser;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins="http://localhost:4200")
public class usercom {
	userser userr;
	@GetMapping("/all")
	public List<user>getAll(){
		return userr.getAllUser()	;
		}
	@GetMapping("/get/{id}")
	public user getUser(@PathVariable long id) {
		return userr.getUser(id);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteuser(@PathVariable long id) {
		userr.deleteUser(id);
	}
	@PostMapping("/create")
	public void adduser(@RequestBody String mdp,String role) {
		userr.addUser(mdp, role);
	}
	@PutMapping("/update")
	public void edituser(@RequestBody Long id,String mdp,String role) {
		userr.editUser(id, mdp, role);
	}

}

