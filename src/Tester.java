import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tester extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaskManager taskManager = new TaskManager();
		
		CardLayout card = new CardLayout();
		JPanel cards=new JPanel(card);
		MainPanel main=new MainPanel(taskManager,card,cards);
		ClockPanel clock=new ClockPanel();
		AnalysisPanel analysis=new AnalysisPanel();
		
		cards.add(main,"100");
		cards.add(analysis,"101");
		cards.add(clock,"3");
		
		 

		JFrame f = new JFrame();
		//f.setSize(500,500);
		//f.setBounds(200, 50, 500, 500);
		f.add(cards);
		
		f.setTitle("Learning list");		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

}
