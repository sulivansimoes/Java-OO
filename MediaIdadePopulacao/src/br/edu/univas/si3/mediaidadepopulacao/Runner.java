package br.edu.univas.si3.mediaidadepopulacao;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class Runner {

	public static void main(String[] args) {

		Populacao cadastro = new Populacao();
		Mulher m1 = new Mulher("m1", 1234, 50);
		Mulher m2 = new Mulher("m2", 1235, 24);
		Homem  h1 = new Homem ("h1", 1236, 19);
		Homem  h2 = new Homem ("h2", 1238, 31);
		
		GraficoDeColuna graficoBuilder = new GraficoDeColuna();
		int ALTURA = 500;
		int LARGURA= 800;
	   
		try{
			cadastro.addPessoa(m1); 
			cadastro.addPessoa(m2);
			cadastro.addPessoa(h1);
			cadastro.addPessoa(h2);
		}catch(KeyDuplicateException e){
			System.out.println("Erro! Não era para entrar no catch do Runner\n"+e.getMessage());
		}
				
		//cria o gráfico
		JFreeChart grafico = graficoBuilder.CriaGrafico("Idade Média da Populacao", cadastro);
		
		//Salva o gráfico
		graficoBuilder.saveToFile("graficoDaPopulacao.png", grafico);
		
		//cria um painel
		ChartPanel painelDoGrafico = new ChartPanel(grafico);
		painelDoGrafico.setPreferredSize(new java.awt.Dimension(LARGURA, ALTURA));
		
		//Cria uma janela
		ApplicationFrame frame = new ApplicationFrame("Gráfico");
		frame.setContentPane(painelDoGrafico);
		frame.pack();
		RefineryUtilities.centerFrameOnScreen(frame);
		frame.setVisible(true);
	}
}
