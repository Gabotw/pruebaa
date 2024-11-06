package biz.restobar.platform.u202018627.attention.infrastructure.persistence.jpa.repositories;

import biz.restobar.platform.u202018627.attention.domain.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}