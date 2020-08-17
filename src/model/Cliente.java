package model;

import java.util.*;

public class Cliente {
	private int pontosDeAlugadorFrequente = 0;
	private double dividaTotal = 0.0;
	private String nome;
	private Collection<Aluguel> fitasAlugadas = new ArrayList<Aluguel>();

	public Cliente(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void adicionaAluguel(Aluguel aluguel) {
		fitasAlugadas.add(aluguel);
	}

	public int getPontosDeAlugadorFrequente() {
		return pontosDeAlugadorFrequente;
	}
	public void setPontosDeAlugadorFrequente(int pontos) {
		pontosDeAlugadorFrequente = pontos;
	}

	public double extrato() {
		double valorCorrente = 0.0;
		for(Aluguel cada: fitasAlugadas) {
		// determina valores para cada linha
		valorCorrente += cada.calcularValor() ;
		// trata de pontos de alugador frequente
		pontosDeAlugadorFrequente += calcularPontosAlugadorFrequente(cada);

		// mostra valores para este aluguel
		dividaTotal += valorCorrente;
		}
		return valorCorrente;
		}
	
	public String mostraExtrato() {
	    	
	    	final String fimDeLinha = System.getProperty("line.separator");
	        String resultado = "Registro de Alugueis de " + getNome() + fimDeLinha;	        
	    	
	    	for(Aluguel f : fitasAlugadas) {
	    		resultado += "\t" + f.getFita().getTitulo() + "\t" + extrato() + fimDeLinha;    		
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