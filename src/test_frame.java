import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
public class test_frame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton analysisbutton, inputbutton, finishbutton, tomatobutton;
	private JTextField subjectField, timeField, dateField;
	private JLabel subLabel, timeLabel, img, dateLabel;
	private JPanel panel1, taskPanel;
	private JTextArea infoArea;
	private TaskManager taskManager;
	private int clicknum;
	
	public test_frame(){
		panel();
	}
	public void panel() {
		 
		panel1 = new JPanel();
		
		panel1.add(taskPanel);
		panel1.add(analysisbutton);
		panel1.add(inputbutton);
		//panel1.add(finishbutton);
		//panel1.add(tomatobutton);
		panel1.add(subLabel);
		panel1.add(dateLabel);
		panel1.add(timeLabel);
		panel1.add(subjectField);
		panel1.add(dateField);
		panel1.add(timeField);
		//panel1.add(infoArea);

		panel1.setLayout(null);
		add(panel1);

	}


}
