package br.com.pe.urbana.cobranca.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the COM_REGISTRO_PAGAMENTO database table.
 * 
 */
@Entity
@Table(name="COM_REGISTRO_PAGAMENTO")
public class Cobranca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="RP_ID")
	private Long id;

	@Column(name="CPF_PAGADOR")
	private String sacado;

	@Temporal(TemporalType.DATE)
	@Column(name="RP_DTCRED")
	private Date dataCredito;

	@Temporal(TemporalType.DATE)
	@Column(name="RP_DTPAG")
	private Date dataPagamento;

	@Temporal(TemporalType.DATE)
	@Column(name="RP_DTPROCESS")
	private Date dataProcessamento;

	@Temporal(TemporalType.DATE)
	@Column(name="RP_DTVCTO")
	private Date dataVencimento;

	@Column(name="RP_NN")
	private Long codigo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="RP_REGDATE")
	private Date regdate;

	@Column(name="RP_REGUSER")
	private String reguser;

	@Column(name="RP_VALOR")
	private BigDecimal valor;

	@Column(name="STATUS_ID")
	@Enumerated(EnumType.ORDINAL)
	private Status status;

	public Cobranca() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long rpId) {
		this.id = rpId;
	}

	public String getSacado() {
		return sacado;
	}

	public void setSacado(String sacado) {
		this.sacado = sacado;
	}

	public Date getDataCredito() {
		return this.dataCredito;
	}

	public void setDataCredito(Date dataCredito) {
		this.dataCredito = dataCredito;
	}

	public Date getDataPagamento() {
		return this.dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Date getDataProcessamento() {
		return this.dataProcessamento;
	}

	public void setDataProcessamento(Date dataProcessamento) {
		this.dataProcessamento = dataProcessamento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getRegdate() {
		return this.regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getReguser() {
		return this.reguser;
	}

	public void setReguser(String reguser) {
		this.reguser = reguser;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public String getMaskCpf(){
		return sacado.substring(0, 3)+"."+sacado.substring(3, 6)+"."+sacado.substring(6, 9)+"-"+sacado.substring(9);
	}

}