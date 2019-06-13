package team.javaSpirit.teachingAssistantPlatform.ui.view;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class AnalysisSingleCourse extends ApplicationFrame{

	@Override
	public void windowClosing(WindowEvent event) {
		if(event.getWindow()==this)
			dispose();
	}
	public AnalysisSingleCourse(String applicationTitle , String chartTitle,Map<String,Double> map) {
		super(applicationTitle);//创建主题样式  
	    StandardChartTheme standardChartTheme=new StandardChartTheme("CN");  
	    //设置标题字体  
	    standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));  
	    //设置图例的字体  
	    standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));  
	    //设置轴向的字体  
	    standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));  
	    //应用主题样式  
	    ChartFactory.setChartTheme(standardChartTheme);this.setBounds(0,0,560 , 367);
	   
	    this.setIconImage(Toolkit.getDefaultToolkit().getImage("image\\logo1.png"));
	    // 居中显示
	    this.setLocationRelativeTo(null);  
	    this.setVisible( true ); 
	    JFreeChart lineChart = ChartFactory.createLineChart(
		         chartTitle,
		         "章节","正确率",
		         createDataset(map),
		         PlotOrientation.VERTICAL,
		         true,true,false);
	    ChartPanel chartPanel = new ChartPanel( lineChart );
	      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
	      setContentPane( chartPanel );
	}
	private DefaultCategoryDataset createDataset(Map<String,Double> map )
	   {
	      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
	      for(String key:map.keySet()) {
	    	  dataset.addValue(map.get(key), "章节", key);
	      }
	      return dataset;
	   }
}
