package models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class fournisseur {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nom;
	private String adresse;
	private int tel;
	private String email;
	@OneToMany(mappedBy = "fournisseurs", cascade = CascadeType.ALL)
    private List <produit> produits;
	
	public fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public fournisseur(long id, String nom, String adresse, int tel, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.tel = tel;
		this.email = email;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
