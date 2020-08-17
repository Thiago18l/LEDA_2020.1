package test;

import model.Aluguel;
import model.Cliente;
import model.Fita;
import model.TipoInfantil;
import model.TipoLancamento;
import model.TipoNormal;

public class Locadora {
    public static void main(String[] args){
        
    	
    	
        Cliente cliente = new Cliente("Jose");
        Cliente cliente2 = new Cliente("Maria");
        Cliente cliente3 = new Cliente("Sofia");
        
        Fita baby = new Fita("Baby Shark", new TipoInfantil());
        Fita teletanbs = new Fita("Teletubs", new TipoInfantil());
        Fita Coringa = new Fita("Coringa", new TipoLancamento());
        Fita Woman = new Fita("Mulher Maravilha", new TipoLancamento());
        Fita LoboW = new Fita("Lobo de Wall Street",new TipoNormal());
        
        
        Aluguel alugado = new Aluguel(baby, 2);   
        Aluguel alugado2 = new Aluguel(teletanbs, 4);
        Aluguel alugado3 = new Aluguel(Coringa, 1);
        Aluguel alugado4 = new Aluguel(Woman, 2);
        Aluguel alugado5 = new Aluguel(LoboW, 5);
        
        cliente.adicionaAluguel(alugado);
        cliente.adicionaAluguel(alugado2);
        cliente2.adicionaAluguel(alugado3);
        cliente2.adicionaAluguel(alugado4);
        cliente3.adicionaAluguel(alugado5);
        
        System.out.println(cliente.extrato());
        System.out.printf("\n\n");
        System.out.println(cliente2.extrato());
        System.out.printf("\n\n");
        System.out.println(cliente3.extrato());
    }
}