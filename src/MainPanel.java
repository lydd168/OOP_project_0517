import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class MainPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton analysisbutton, inputbutton, finishbutton, tomatobutton;
	private JTextField subjectField, timeField, dateField;
	private JLabel abc, subLabel, timeLabel, bgimg, dateLabel;
	private JPanel panel1, taskPanel,oPanel;
	private JTextArea infoArea;
	private TaskManager taskManager;
	private int clicknum=1;
	private ImageIcon saveIcon,bg;
    private JLayeredPane layeredPane;
    private int click=0;
    private int pos=0;
    private CardLayout card;
    private JPanel cards;
	public MainPanel(TaskManager taskManager,CardLayout card ,JPanel cards) {
		setLayout(null);		
		setPreferredSize(new Dimension(500, 500));
		this.taskManager=taskManager;
		this.card=card;
		this.cards=cards;
		//create
		analysisbutton();
		inputbutton();		 		
		createitemcomp();
		createPanel();
		
		//setVisible(true);
		
		//oPanel=new JPanel();
		//Panel=(JPanel)getContentPane();
		//setOpaque(false);
		

        
		
	}

	public void createitemcomp() {
		// infoArea = new JTextArea();
		// infoArea.setBounds(1, 1, 500, 330);
		//img = new JLabel(new ImageIcon("src/tomato.png"));
		// img.setBounds(40, 5, 70, 50);
		//Font font = new Font("Arial", Font.BOLD, 25);
		//infoArea.setFont(font);
		
		//­I´º
		bg=new ImageIcon("src/tbg.png");
		bgimg=new JLabel(bg); 
		bgimg.setBounds(0,300,bg.getIconWidth(), bg.getIconHeight());
		//getLayeredPane().add(bgimg,new Integer(Integer.MIN_VALUE));
		dateLabel = new JLabel("Date:");
		dateLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		dateLabel.setBounds(18, 345, 70, 50);
		dateLabel.setForeground(Color.white);
		subLabel = new JLabel("Subject:");
		subLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		subLabel.setBounds(192, 345, 70, 50);
		subLabel.setForeground(Color.white);
		timeLabel = new JLabel("Time:");
		timeLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		timeLabel.setForeground(Color.white);
		timeLabel.setBounds(17, 400, 70, 50);
		subjectField = new JTextField(50);
		subjectField.setBounds(265, 350, 100, 40);
		timeField = new JTextField(50);
		timeField.setBounds(90, 410, 100, 40);
		dateField = new JTextField(50);
		dateField.setBounds(90, 350, 100, 40);
		taskPanel = new JPanel();
		taskPanel.setBounds(10, 10, 100, 100);		
		saveIcon = new ImageIcon("src/to.png");
		//
	}

	@SuppressWarnings("deprecation")
	public void createPanel() {
		
		
		
		// panel1.add(finishbutton);
		// panel1.add(tomatobutton);
		add(dateLabel);
		add(dateField);
		add(subLabel);
		add(subjectField);		
		add(timeLabel);				
		add(timeField);
		// panel1.add(infoArea);
		add(inputbutton);
		add(analysisbutton);	
		add(taskPanel);
		add(bgimg,new Integer(Integer.MIN_VALUE));
		
		//panel1.setOpaque(false);
		//setOpaque(false);
		
		
	

	}

	public void createtask() {
		remove(taskPanel);
		taskPanel = new JPanel();

		//taskPanel.setBounds(0, 0, 500, 300);
		taskPanel.setBounds(0,0, 460, 300);
		for (int i = 0; i < taskManager.getTasks().size(); i++) {
			JPanel task = new JPanel();
			JLabel label = new JLabel(taskManager.getInfo(i));
			label.setFont(new Font("Dialog", Font.BOLD, 20));
			task.add(label);
			finishButton(task);
			tomatobutton(task,i);
			taskPanel.add(task);
			
		}
		
        
        //pos+=80;
		 add(taskPanel);
		 validate();
	 repaint();

	}

	public void analysisbutton() {

		JFrame.setDefaultLookAndFeelDecorated(true);
		analysisbutton = new JButton("analysis");
		analysisbutton.setVisible(true);
		analysisbutton.setBackground(Color.blue);
		analysisbutton.setContentAreaFilled(false);
		analysisbutton.setBorder(BorderFactory.createLineBorder(Color.white));
		analysisbutton.setForeground(Color.white);
		analysisbutton.setBounds(370, 345, 100, 50);
		analysisbutton.setFont(new Font("Dialog", Font.BOLD, 17));
		class ClickListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				card.show(cards,"3");
			}
		}
		ClickListener listener=new ClickListener();
		analysisbutton.addActionListener(listener);

	}

	public void inputbutton() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		inputbutton = new JButton("Input");
		inputbutton.setFont(new Font("Dialog", Font.BOLD, 17));
		inputbutton.setBackground(Color.blue);

		inputbutton.setContentAreaFilled(false);
		inputbutton.setBorder(BorderFactory.createLineBorder(Color.white));
		
		
		
		inputbutton.setForeground(Color.white);
		inputbutton.setBounds(370, 400, 100, 50);
		class ClickListener1 implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				
				String date = dateField.getText();
				double t = Double.parseDouble(timeField.getText());
				taskManager.addTask(date, subjectField.getText(), t);
				createtask();
				timeField.setText("");
				subjectField.setText("");
				dateField.setText("");
			}

		}

		ActionListener b = new ClickListener1();
		inputbutton.addActionListener(b);
	}

	public void finishButton(JPanel panel) {
		JButton finishbutton = new JButton("unfinished");
		finishbutton.setFont(new Font("Dialog", Font.PLAIN, 18));
		finishbutton.setLayout(null);
		//finishbutton.setBounds(350, 2, 100, 50);
		finishbutton.setBackground(Color.blue);
		finishbutton.setForeground(Color.red);

		finishbutton.setContentAreaFilled(false);
		finishbutton.setBorder(BorderFactory.createLineBorder(Color.black));
		
		finishbutton.setPreferredSize(new Dimension(100,35));
		class ClickListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				
				if (clicknum % 2 == 1) {
					finishbutton.setText("finished");
					finishbutton.setBackground(Color.white);
					finishbutton.setForeground(Color.BLACK);

				} else {
					finishbutton.setText("unfinished");
					finishbutton.setBackground(Color.blue);
					finishbutton.setForeground(Color.red);
				}
				clicknum++;
			}
			
		}

		ActionListener f = new ClickListener();
		finishbutton.addActionListener(f);
		panel.add(finishbutton);
	}

	public void tomatobutton(JPanel panel,int i) {
		ImageIcon saveIcon = new ImageIcon("src/t1.png");
		JButton tomatobutton = new JButton(saveIcon);
		//tomatobutton.setText("task"+String.valueOf(i+1));
		tomatobutton.setBackground(Color.white);
		tomatobutton.setPreferredSize(new Dimension(100,35));
		tomatobutton.setBorder(BorderFactory.createLineBorder(Color.white));
		class ClickListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {				 
				card.show(cards,"3");
				//clock.setLoadingTask(i); 
			}
		}
		ClickListener listener=new ClickListener();
		tomatobutton.addActionListener(listener);
		panel.add(tomatobutton);
	}
}
