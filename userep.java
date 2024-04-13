package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import models.user;

public interface userrep extends JpaRepository<user, Long> {

}
