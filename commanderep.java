package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import models.commande;

public interface commanderep extends JpaRepository<commande, Long>{

}
