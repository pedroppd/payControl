package br.com.paycontrol.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.paycontrol.domain.Account;
import br.com.paycontrol.domain.AverdueAccount;
import br.com.paycontrol.domain.Client;
import br.com.paycontrol.domain.Company;
import br.com.paycontrol.repository.AccountRepository;
import br.com.paycontrol.repository.AverdueAccountRepository;
import br.com.paycontrol.repository.ClientRepository;
import br.com.paycontrol.repository.CompanyRepository;

@Configuration
public class PopulteDb implements CommandLineRunner{

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private AverdueAccountRepository averdueAccountRepository;
	
	public PopulteDb() 
	{
		
	}

	@Override
	public void run(String... args) throws Exception 
	{
		//############## Company
		Company comp1 = new Company("123456789987", "OI");
		Company comp2 = new Company("123456789987", "CEDAE");
		Company comp3 = new Company("123456789987", "PLANO DE SAÚDE");
				
		companyRepository.saveAll(Arrays.asList(comp1, comp2, comp3));
				
		//############### Client
		Client c1 = new Client("Pedro Dantas", "12516453728", Instant.now());
		Client c2 = new Client("João Amoedo", "23316566885", Instant.now());
		Client c3 = new Client("Thuany Lima", "45656987228", Instant.now());
		
		clientRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		//############### Account
		Account ac1 = new Account("123456789987222", 50.00F, Instant.now(), c1, comp1);
		Account ac2 = new Account("123456789987333", 100.00F, Instant.now(), c2, comp2);
		Account ac3 = new Account("123456789987444", 200.00F, Instant.now(), c3, comp3);
		
		accountRepository.saveAll(Arrays.asList(ac1, ac2, ac3));
		
		//############### AverdueAccount
		AverdueAccount av1 = new AverdueAccount(c3, ac3, Instant.now());
		AverdueAccount av2 = new AverdueAccount(c2, ac2, Instant.now());
		
		//For relation one to one the insertion need be so.
		ac3.setAverdueAccount(av1);
		ac2.setAverdueAccount(av2);
		
		accountRepository.saveAll(Arrays.asList(ac3, ac2));
	}
	

}
