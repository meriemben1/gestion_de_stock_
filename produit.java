package models;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
// creation mta3 table de BD
@Entity 
public class produit {
	// ki yebde andek clé prim
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String desc;
	private double prix;
	@ManyToOne
	@JoinColumn(name = "cmd_id")
	private commande commande;
	@OneToMany(mappedBy = "Produit", cascade = CascadeType.ALL)
    private List <stock> stocks;
    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private fournisseur fournisseurs;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public commande getCommande() {
		return commande;
	}
	public void setCommande(commande commande) {
		this.commande = commande;
	}
	public List<stock> getStocks() {
		return stocks;
	}
	public void setStocks(List<stock> stocks) {
		this.stocks = stocks;
	}
	public fournisseur getFournisseurs() {
		return fournisseurs;
	}
	public void setFournisseurs(fournisseur fournisseurs) {
		this.fournisseurs = fournisseurs;
	}
	public produit(long id, String name, String desc, double prix, models.commande commande, List<stock> stocks,
			fournisseur fournisseurs) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.prix = prix;
		this.commande = commande;
		this.stocks = stocks;
		this.fournisseurs = fournisseurs;
	}
	public produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
