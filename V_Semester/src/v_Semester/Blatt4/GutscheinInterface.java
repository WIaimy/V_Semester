package v_Semester.Blatt4;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import v_Semester.Blatt0.Gutschein;

public interface GutscheinInterface extends Remote{

	public List<Gutschein> getGutscheine(int knr) throws RemoteException;
}
