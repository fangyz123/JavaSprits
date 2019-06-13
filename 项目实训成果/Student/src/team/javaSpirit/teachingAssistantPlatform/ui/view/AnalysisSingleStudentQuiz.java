package team.javaSpirit.teachingAssistantPlatform.ui.view;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

public class AnalysisSingleStudentQuiz extends ApplicationFrame{
	ChartPanel frame1;
	@Override
	public void windowClosing(WindowEvent event) {
		if(event.getWindow()==this)
			dispose();
	}
	public AnalysisSingleStudentQuiz(String title1,Map<String,Double> map,String title2) {
		super(title1);
		 StandardChartTheme standardChartTheme=new StandardChartTheme("CN");  
		    //设置标题字体  
		    standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));  
		 //应用主题样式  
	    ChartFactory.setChartTheme(standardChartTheme);this.setBounds(0,0,560 , 367);
		 setContentPane(createDemoPanel(map,title2 ));
		 this.setBounds(0,0,560 , 367);
		 this.setIconImage(Toolkit.getDefaultToolkit().getImage("image\\logo1.png"));
		 this.setVisible( true ); 
		 // 居中显示
	 	 this.setLocationRelativeTo(null);
	}
	public static JPanel createDemoPanel(Map<String,Double> map,String title ) {
	      JFreeChart chart = createChart(createDataset(map ) ,title); 
	      DecimalFormat df=new DecimalFormat("0.00%");
	      NumberFormat nf=NumberFormat.getNumberInstance();
	      StandardPieSectionLabelGenerator sp1=new StandardPieSectionLabelGenerator("{0} {2}",nf,df);
	      PiePlot pieplot=(PiePlot)chart.getPlot();
	      pieplot.setLabelGenerator(sp1);
	      pieplot.setLabelFont(new Font("宋体",Font.BOLD,12));
	      chart.getLegend().setItemFont(new Font("黑体",Font.BOLD,12));
	      return new ChartPanel( chart ); 
	 }
	private static JFreeChart createChart( PieDataset dataset,String title ) {
	      JFreeChart chart = ChartFactory.createPieChart(      
	         title,  // chart title 
	         dataset,        // data    
	         true,           // include legend   
	         true, 
	         false);

	      return chart;
	   }
	private static PieDataset createDataset(Map<String,Double> map) {
	      DefaultPieDataset dataset = new DefaultPieDataset( );
	      for(String k:map.keySet()) {
	    	  dataset.setValue(k, map.get(k));
	      }
	      return dataset;         
	   }
}
