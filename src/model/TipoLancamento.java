package model;

public class TipoLancamento implements TipoFilme {
	
	private static final double VALOR_FITA_LANCAMENTO = 3.0;

	@Override
	public double getValor(int diasAlugada) {
		return VALOR_FITA_LANCAMENTO * diasAlugada;
	}

}
