package br.com.paycontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.paycontrol.domain.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{

}
