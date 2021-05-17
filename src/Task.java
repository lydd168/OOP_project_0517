 
public class Task {
	private double expectTime;
	private double realTime;
	private String subject;
	private String date;
	
	public Task(String date,String subject,double expectTime) {
		this.date=date;
		this.expectTime=expectTime;
		this.subject=subject;
		this.realTime=0;
	}
	
	
	public void updateTime(double num) {
		this.realTime=num;		
	}
	
	public String getDate() {
		return date;
	}
	public String getSubject() {
		return subject;
	}
	public double getRealTime() {
		return realTime;
	}
	public double getExpectTime() {
		return expectTime;
	}

}
