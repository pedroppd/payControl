package br.com.paycontrol.domain.dto;

import java.io.Serializable;

public class CompanyDTO implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String cnpj;
	
	private String name;
	
	public CompanyDTO() 
	{
		
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
