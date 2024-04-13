package models;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class commande {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int qnt;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String statut;
	@OneToMany(mappedBy="commande",cascade=CascadeType.ALL)
	private List<produit>produits;
	public commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public commande(long id, int qnt, Date date, String statut) {
		super();
		this.id = id;
		this.qnt = qnt;
		this.date = date;
		this.statut = statut;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getQnt() {
		return qnt;
	}
	public void setQnt(int qnt) {
		this.qnt = qnt;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	

}
