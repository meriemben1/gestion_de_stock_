package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import models.stock;
import models.user;

public interface stockrep extends JpaRepository<stock, Long> {

}
