package br.com.Vendas.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tb_itens")
@NamedQueries({
@NamedQuery(name = "Itens.listar", query = "SELECT itens FROM Itens itens"),
@NamedQuery(name = "Itens.buscarPorCodigo", query = "SELECT itens FROM Itens itens WHERE itens.codigo = :codigo")})
public class Itens {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ite_codigo")
	private Long codigo;
	
	@Column(name = "ite_quantidade", nullable = false)
	private Integer quantidade;
	
	@Column(name = "ite_valor_parcial", nullable = false, scale = 2, precision = 7)
	private BigDecimal valor_parcial;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_produto_pro_codigo", referencedColumnName = "pro_codigo", nullable = false)
	private Produto produto;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_vendas_ven_codigo", referencedColumnName = "ven_codigo", nullable = false)
	private Vendas vendas;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor_parcial() {
		return valor_parcial;
	}

	public void setValor_parcial(BigDecimal valor_parcial) {
		this.valor_parcial = valor_parcial;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Vendas getVendas() {
		return vendas;
	}

	public void setVendas(Vendas vendas) {
		this.vendas = vendas;
	}

	@Override
	public String toString() {
		return "Itens [codigo=" + codigo + ", quantidade=" + quantidade + ", valor_parcial=" + valor_parcial
				+ ", produto=" + produto + ", vendas=" + vendas + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Itens other = (Itens) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	

}
