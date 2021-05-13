package br.com.paycontrol.domain;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class AverdueAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT" )
	private Instant instant;
	
	@OneToOne
	@MapsId
	private Account account;
	
	public AverdueAccount() 
	{
		
	}

	public AverdueAccount(Account account, Instant instant) 
	{
		this.account = account;
		this.instant = instant;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "AverdueAccount [id=" + id + ", account=" + account + "]";
	}
	
	public Instant getInstant() {
		return instant;
	}

	public void setInstant(Instant instant) {
		this.instant = instant;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AverdueAccount other = (AverdueAccount) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
