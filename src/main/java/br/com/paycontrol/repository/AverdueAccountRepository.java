package br.com.paycontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.paycontrol.domain.AverdueAccount;

@Repository
public interface AverdueAccountRepository extends JpaRepository<AverdueAccount, Long>{

}
