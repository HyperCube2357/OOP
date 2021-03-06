import java.io.File;
import java.util.ArrayList;


public class CsvCombinedThread extends Thread  {

	private DataBase database ;
	private String name;
	
	public CsvCombinedThread (DataBase database,String name){
		 this.database = database;
		 this.name = name;
	}

	@Override
	public void run() {
		
		synchronized (database) {

		String newFileName = this.name+".csv" ;
		CsvWrite csvwr = new CsvProcessor();
		ArrayList <Wifi> wifiarr = database.getDatabase() ;
		if(wifiarr.isEmpty()) System.out.println("your database is empty");
		else 
		csvwr.Array2csvSorted(wifiarr, newFileName, 10);
		}
	}
}
