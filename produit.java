package controler;

import java.sql.Date;
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

import models.commande;
import models.fournisseur;
import service.commandeser;

@RestController
@RequestMapping("/api/commande")
@CrossOrigin(origins="http://localhost:4200")
public class commandecont {
	commandeser com;
	@GetMapping("/all")
	public List<commande>getAll(){
		return com.getAllCommande()	;
		}
	@GetMapping("/get/{id}")
	public commande getCommande(@PathVariable long id) {
		return com.getCommande(id);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteCommande(@PathVariable long id) {
		com.deleteCommande(id);
	}
	@PostMapping("/create")
	public void addCommande(@RequestBody int qnt,Date date,String statut) {
		com.addCommande(qnt,date,statut);
	}
	@PutMapping("/update")
	public void editCommande(@RequestBody Long id,int qnt,Date date,String statut) {
		com.editCommande(id,qnt,date,statut);
	}

}
