package br.com.paycontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.paycontrol.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
