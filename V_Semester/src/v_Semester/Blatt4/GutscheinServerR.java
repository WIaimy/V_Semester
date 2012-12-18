package v_Semester.Blatt4;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class GutscheinServerR {

	public static void main(String[] para){
		
		try{
			LocateRegistry.createRegistry(1099);
			
			GutscheinObjekt go = new GutscheinObjekt();
			Naming.rebind("rmi://localhost:1099/Gutschein", go);
			System.out.println("Server läuft");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
