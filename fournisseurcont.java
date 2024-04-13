package controler;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.fournisseur;
import models.user;
import service.fournisseurser;
import service.userser;

@RestController
@RequestMapping("/api/fournisseur")
@CrossOrigin(origins="http://localhost:4200")
public class fournisseurcom {
	fournisseurser fourni;
	@GetMapping("/all")
	public List<fournisseur>getAll(){
		return fourni.getAllFournisseur()	;
		}
	@GetMapping("/get/{id}")
	public fournisseur getFournisseur(@PathVariable long id) {
		return fourni.getFournisseur(id);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteFournisseur(@PathVariable long id) {
		fourni.deleteFournisseur(id);
	}
	@PostMapping("/create")
	public void addFournisseur(@RequestBody String nom,String adresse,int tel,String email) {
		fourni.addFournisseur(nom,adresse,tel,email);
	}
	@PutMapping("/update")
	public void editFournisseur(@RequestBody Long id,String nom,String adresse,int tel,String email) {
		fourni.editFournisseur(id,nom,adresse,tel,email);
	}

}
