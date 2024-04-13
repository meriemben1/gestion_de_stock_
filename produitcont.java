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

import models.produit;
import models.user;
import service.produitser;

@RestController
@RequestMapping("/api/produit")
@CrossOrigin(origins="http://localhost:4200")
public class produitcom {
	produitser produitt;
	@GetMapping("/all")
	public List<produit>getAll(){
		return produitt.getAllProduit()	;
		}
	@GetMapping("/get/{id}")
	public produit getProduit(@PathVariable long id) {
		return produitt.getProduit(id);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteProduit(@PathVariable long id) {
		produitt.deleteProduit(id);
	}
	@PostMapping("/create")
	public void addProduit(@RequestBody String name,String desc,double prix , long fournisseur , long commande ) {
		produitt.addProduit(name,desc,prix, fournisseur ,commande);
	}
	@PutMapping("/update")
	public void editProduit(@RequestBody Long id,String name,String desc,double prix, long fournisseur , long commande) {
		produitt.editProduit(id,name,desc,prix , fournisseur ,commande);
	}

}
