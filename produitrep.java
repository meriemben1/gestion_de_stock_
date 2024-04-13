
package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import models.produit;

public interface produitrep extends JpaRepository<produit, Long> {

}
