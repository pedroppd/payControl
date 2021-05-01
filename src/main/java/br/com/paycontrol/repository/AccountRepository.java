package br.com.paycontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.paycontrol.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

}
