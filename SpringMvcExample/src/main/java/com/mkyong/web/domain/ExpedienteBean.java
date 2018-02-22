package com.mkyong.web.domain;

import java.util.List;

public class ExpedienteBean {
	
	public String	codTramite	;
	public String	descTramite	;;
	public List<Requisito> requisito;
	

	public ExpedienteBean() {
		super();
	}
	
	public ExpedienteBean(String codTramite, String descTramite,
			String codExpediente, String codDerivado, String descDerivado,
			String codUsuario, String tipoDocumento, String codigo,
			String descCodigo, String estadoCodigo, String observacion,
			List<Requisito> requisito) {
		super();
		this.codTramite = codTramite;
		this.descTramite = descTramite;
	}

	public String getCodTramite() {
		return codTramite;
	}

	public void setCodTramite(String codTramite) {
		this.codTramite = codTramite;
	}

	public String getDescTramite() {
		return descTramite;
	}

	public void setDescTramite(String descTramite) {
		this.descTramite = descTramite;
	}


	public List<Requisito> getRequisito() {
		return requisito;
	}

	public void setRequisito(List<Requisito> requisito) {
		this.requisito = requisito;
	}
	

}
