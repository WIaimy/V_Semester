package v_Semester.Blatt4;

import java.rmi.Naming;

public class GutscheinServerR {

	public static void main(String[] para){
		try{
			GutscheinObjekt go = new GutscheinObjekt();
			Naming.rebind("rmi://127.0.0.1:1221/Gutschein", go);
			System.out.println("Server läuft");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
