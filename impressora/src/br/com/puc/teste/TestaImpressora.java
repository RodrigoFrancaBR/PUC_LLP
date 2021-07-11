package br.com.puc.teste;

import br.com.puc.state.Impressora;
import br.com.puc.state.exception.NaoPodeDesligarException;
import view.ImpressoraView;

public class TestaImpressora {

	public static void main(String[] args) {
		ImpressoraView tela = new ImpressoraView();
		
		/**
		 * padr�o inicia com estado desligada...
		 */
		Impressora imp = new Impressora();

		try {
			imp.ligar();
			imp.imprimir();
			imp.pausarImpressao();
			imp.imprimir(); // volta a imprimir
			imp.terminarImpressao(); // deixar impressora no estado pronta
			imp.imprimirUltimaFolha();
			imp.colocarTinta();
			imp.imprimir(); // sem tinta ok
			// imp.pausarImpressao();
			// imp.cancelarImpressao();

			// imp.ligar();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				imp.desligar();
			} catch (NaoPodeDesligarException e) {			
				e.printStackTrace();
				System.out.println("N�o foi possivel desligar a impressora, " + e.getMessage() + ".");
			}
		}
	}

}
