import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;

import javax.swing.JFrame;

public class RendererBot implements Runnable{
	private static boolean active = true;
	private static String status = "";
	private Date date;
	
	public RendererBot(String str){
		Loader.frame.setAlwaysOnTop(false	);
		date = new Date();
		active = true;
		this.status = str;
	}


	public void run() {
		while(active){
			updateTime();
			try { Thread.sleep(100); } catch (InterruptedException e) {}
		}
		
	}
	

	private void updateTime(){
	    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
	    Date resultdate = new Date();
	    
	    long diff = resultdate.getTime() - date.getTime();
		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);
	    
	    status = "[ThievingBot] uptime: "+diffDays+"days "+diffHours+"hours "+diffMinutes+" minutes "+diffSeconds+"seconds";
	}
	
	public void setStatus(String str){
		this.status = str;
	}
	
	public static String getStatus(){
		return active ? status : "";
	}
	
	public static void terminate(){
		Loader.frame.setAlwaysOnTop(false);
		active = false;
	}
}
