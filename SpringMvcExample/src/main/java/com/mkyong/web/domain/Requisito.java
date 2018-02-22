package com.mkyong.web.domain;

public class Requisito {

	public String codRequisito;
	public String DescRequisito;

	public Requisito() {
		super();
	}

	public Requisito(String codRequisito, String descRequisito) {
		super();
		this.codRequisito = codRequisito;
		DescRequisito = descRequisito;
	}

	public String getCodRequisito() {
		return codRequisito;
	}

	public void setCodRequisito(String codRequisito) {
		this.codRequisito = codRequisito;
	}

	public String getDescRequisito() {
		return DescRequisito;
	}

	public void setDescRequisito(String descRequisito) {
		DescRequisito = descRequisito;
	}

}
