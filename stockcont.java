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

import models.stock;
import models.user;
import service.stockser;
import service.userser;

@RestController
@RequestMapping("/api/stock")
@CrossOrigin(origins="http://localhost:4200")
public class stockcom {
	stockser stockk;
	@GetMapping("/all")
	public List<stock>getAll(){
		return stockk.getAllStock()	;
		}
	@GetMapping("/get/{id}")
	public stock getStock(@PathVariable long id) {
		return stockk.getStock(id);
	}
	@DeleteMapping("/delete/{id}")
	public void deletestock(@PathVariable long id) {
		stockk.deleteStock(id);
	}
	@PostMapping("/create")
	public void addstock(@RequestBody int qnt,int s_min,int s_max, long produit) {
		stockk.addstock(qnt, s_min,s_max, produit);
	}
	@PutMapping("/update")
	public void editstock(@RequestBody Long id,int qnt,int s_min,int s_max, long produit) {
		stockk.editstock(id, qnt,s_min,s_max, produit );
	}
}
