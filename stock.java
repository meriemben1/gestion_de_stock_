package models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class stock {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int qnt;
	private int s_min;
	private int s_max;
	@ManyToOne
    @JoinColumn(name = "produit_id")
	private produit Produit;
	public stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public stock(long id, int qnt, int s_min, int s_max) {
		super();
		this.id = id;
		this.qnt = qnt;
		this.s_min = s_min;
		this.s_max = s_max;
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
	public int getS_min() {
		return s_min;
	}
	public void setS_min(int s_min) {
		this.s_min = s_min;
	}
	public int getS_max() {
		return s_max;
	}
	public void setS_max(int s_max) {
		this.s_max = s_max;
	}
	

}
