package model;

import java.util.*;


public class Cliente {
	private int pontosDeAlugadorFrequente = 0;
	private double dividaTotal = 0.0;
	private static Integer TAMANHO_DEFAULT = 10;
	private Integer size = 0;
	private String nome;
	private Aluguel dados[];


	public Cliente(String nome) {
		this.nome = nome;
		dados = new Aluguel[TAMANHO_DEFAULT];
	}

	public String getNome() {
		return nome;
	}
	public Integer getSize () {
		return this.size;
	}
	public void adicionaAluguel(Aluguel aluguel) {
		if (size == dados.length) {
			aumentaArray();
		}
		dados[size++] = aluguel;
	}
	private void aumentaArray () {
		int newLenght = dados.length * 2;
		dados = Arrays.copyOf(dados, newLenght);
	}
	public int getPontosDeAlugadorFrequente() {
		return pontosDeAlugadorFrequente;
	}
	public void setPontosDeAlugadorFrequente(int pontos) {
		pontosDeAlugadorFrequente = pontos;
	}

	public double extrato() {
		double valorCorrente = 0.0;
		for (int i = 0; i < dados.length; i++) {
			if (dados[i] == null) {
				break;
			}
			valorCorrente += dados[i].calcularValor();
			pontosDeAlugadorFrequente +=  calcularPontosAlugadorFrequente(dados[i]);
			dividaTotal += valorCorrente;
		}
		return valorCorrente;
	}
	
	public String mostraExtrato() {
	    	
	    	final String fimDeLinha = System.getProperty("line.separator");
	        String resultado = "Registro de Alugueis de " + getNome() + fimDeLinha;	        
	    	for (int i = 0; i < dados.length; i++) {
	    		if (dados[i] == null) {
	    			break;
				}
	    		resultado += "\t" + dados[i].getFita().getTitulo() + "\t" + extrato() + fimDeLinha;
			}
	    	
	    	// adiciona rodape
	    	resultado += "Valor total devido: " + dividaTotal + fimDeLinha;        
	        resultado += "Voce acumulou " + getPontosDeAlugadorFrequente() + " pontos de alugador frequente";
	        
	        return resultado;    	
	    }
		

	// adiciona bonus para aluguel de um lancamento por pelo menos 2 dias
	private int calcularPontosAlugadorFrequente(Aluguel aluguel) {
		int pontos = 1;
		if (aluguel.getFita().getTipo() instanceof TipoLancamento && aluguel.getDiasAlugada() > 1) {
			pontos += 1;
		}
		return pontos;
	}

}