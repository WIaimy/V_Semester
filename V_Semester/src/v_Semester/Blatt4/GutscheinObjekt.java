package v_Semester.Blatt4;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import v_Semester.Blatt0.Gutschein;

public class GutscheinObjekt extends UnicastRemoteObject implements
		GutscheinInterface {

	ObjectInputStream in;

	protected GutscheinObjekt() throws RemoteException {
		super();
	}

	public List<Gutschein> getGutscheine(int knr) throws RemoteException {
		List<Gutschein> l = null;
		Gutschein gut;
		
		try{
			in = new ObjectInputStream(new FileInputStream("Gutscheine.dat"));
			int amount = in.readInt();
			l = new ArrayList<Gutschein>();
			
			for(int i = 0; i < amount; i++){
				gut = (Gutschein) in.readObject();
				if(gut.getKdNr() == knr)
					l.add(gut);
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return l;
	}

}
