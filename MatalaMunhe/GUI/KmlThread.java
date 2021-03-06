import java.util.ArrayList;



public class KmlThread extends Thread{
	private DataBase database ;
	private String name;
	
	public KmlThread (DataBase database,String name){
		 this.database = database;
		 this.name = name;
	}

	@Override
	public void run() {
		
		synchronized (database) {
			
		
		String newFileName = this.name+".kml" ;
      WriteWifiKml wkml = new WriteWifiKml();
      ArrayList <Wifi> wifiarr = database.getDatabase() ;
		if(wifiarr.isEmpty()) System.out.println("your database is empty");
		else 
		wkml.createWifiKml(wifiarr, newFileName);
		}
	}
}
