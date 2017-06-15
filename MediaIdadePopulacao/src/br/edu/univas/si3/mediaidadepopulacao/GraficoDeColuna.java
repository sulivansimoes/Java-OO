package br.edu.univas.si3.mediaidadepopulacao;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficoDeColuna {
	
		public JFreeChart  CriaGrafico (String titulo,Populacao p){
			
			//Cria o gráfico
			DefaultCategoryDataset dataset = criaDataset(p);
			
			JFreeChart graficoDeColuna = ChartFactory.createBarChart(titulo,                  
					 												 "GENERO", 					
					 												 "MEDIA IDADES", 			
					 												 dataset, 					
					 												 PlotOrientation.VERTICAL, 	
					 												 true, 						 
					 												 false, 
					 												 true);
			
		//	graficoDeColuna.getCategoryPlot().getRenderer(0).setSeriesPaint(0, Color.ORANGE); //Setando cor da coluna do grafico com laranja			
			return graficoDeColuna;
		}
		
		//Popula grafico com informações
		private DefaultCategoryDataset criaDataset(Populacao p){ 
			
			 DefaultCategoryDataset dataset= new DefaultCategoryDataset();
			 
			 dataset.addValue(p.getMediaIdadeMulher(), "Populacao", "Mulher");
			 dataset.addValue(p.getMediaIdadeHomem() , "Populacao", "Homem ");
			 dataset.addValue(p.getMediaIdadeGeral() , "Populacao", "Homem e Mulher");
					
			return dataset;
		}
		
		public void saveToFile(String fileName, JFreeChart chart) {
			
		
	 		int width  = 560; /* altura da imagem*/
	 		int height = 370; /* largura da imagem*/
	 		
	 		File pieChart = new File(fileName);
	 		
	 		try {
	 			ChartUtilities.saveChartAsJPEG(pieChart, chart, width, height);
	 		} catch (IOException e) {
	 			System.out.println("Erro ao salvar o arquivo do gráfico.\n");
	 			e.printStackTrace();
	 		}
		} 
}


