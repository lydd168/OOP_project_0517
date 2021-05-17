
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class TaskManager {
	private ArrayList<Task> tasks;
	private int clicknum;
	public TaskManager() {
		this.tasks = new ArrayList<Task>();
		clicknum=1;
	}

	public void addTask(String date,String subject,double expectTime) {
		tasks.add(new Task(date,subject, expectTime));
	}

	public ArrayList<Task> getTasks() {
		return tasks;
	}
	
	//獲得特定subject的總時間
	public double getSpecificSubject(String subject) {
		double subjectTime=0;
		for (Task task:tasks) {
			if (task.getSubject().equals(subject)) {
				subjectTime=subjectTime+task.getRealTime();
			}
		}
		return subjectTime;
	}
	
	//獲得特定日期的總時間
		public double getSpecificDate(String date) {
			double dateTime=0;
			for (Task task:tasks) {
				if (task.getDate().equals(date)) {
					dateTime=dateTime+task.getRealTime();
				}
			}
			return dateTime;
		}
	
	
		
	public String getInfo(int i) {
		ImageIcon saveIcon = new ImageIcon("src/t1.png");
		String info="";
			info=info+String.format("%5s",tasks.get(i).getDate())+" "+String.format("%5s",tasks.get(i).getSubject())+" "
					+String.format("%2s",tasks.get(i).getExpectTime())+" "+String.format("%2s",tasks.get(i).getRealTime()/tasks.get(i).getExpectTime())+"%\n";
		
		return info;
	}
	
	

}
