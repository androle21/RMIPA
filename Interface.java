package RMIPA;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Interface extends Remote {
	
	int controlador()throws RemoteException;
	
	public int getPtermo() throws RemoteException;
	public void setPtermo(int termo) throws RemoteException;

	public int getRazao() throws RemoteException;
	public void setRazao(int razao) throws RemoteException;
	
	public int getQtermo() throws RemoteException;
	public void setQtermo(int qtermo) throws RemoteException;
	
	public int calcula() throws RemoteException;
	
	public float Valor() throws RemoteException;
	public float Valor2() throws RemoteException;
	
	public void zerar() throws RemoteException;
	
	//public String Criptografia (String aux) throws RemoteException;
	//public String Descriptografia (String aux) throws RemoteException;

}
