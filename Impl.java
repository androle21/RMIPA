package RMIPA;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Impl extends UnicastRemoteObject implements Interface  {
		protected Impl() throws RemoteException {
		super(); // chamando o construtor da classe UnicastRemoteObject - usado para exportar um
					// objeto remoto
	}
	
	int controlador = 0; // controlador dos clientes
	private int ptermo;
	private int razao;
	private int qtermo;
	int Valor = 10;
	int Valor2 = 5;
	Interface serv = null;
	
	
	public int controlador() throws RemoteException {
		return controlador;
	}
	
	
	public int getPtermo() throws RemoteException {
	
	return ptermo;
	}
	
	
	public void setPtermo(int ptermo) throws RemoteException {
	this.ptermo = ptermo;
	controlador += 1;
	}
	

	public int getRazao() throws RemoteException {
	
	return razao;
	}
	
	public void setRazao(int razao) throws RemoteException{
		this.razao = razao;
		controlador +=1;
	}
	
	public int getQtermo() throws RemoteException {
		
		return qtermo;
		}
		
		public void setQtermo(int qtermo) throws RemoteException{
			this.qtermo = qtermo;
			controlador +=1;
		}
		
		public int calcula() throws RemoteException {
			return (getPtermo() + getRazao()* getQtermo());
		}
		
		public float Valor() throws RemoteException {
			float ValorRetorno = Valor;
			try {
				serv = (Interface) Naming.lookup("//127.0.0.1/rmi"); // sevidor b
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (NotBoundException e) {
				e.printStackTrace();
			}

			return ValorRetorno;
		}
		
		
		public float Valor2() throws RemoteException {
			float ValorRetorno2 = Valor2;
			try {
				serv = (Interface) Naming.lookup("//127.0.0.1/rmi");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (NotBoundException e) {
				e.printStackTrace();
			}

			return ValorRetorno2;
		}
		
		public void zerar() throws RemoteException {
			controlador = 0;
			ptermo = 0;
			razao = 0;
			qtermo = 0;
		}
/*
	public int pa(int a, int r, int n, int an) throws RemoteException {
		for (int i = 1; i <= n; i++) {
			an = a + (i -1)*r; //Fórmula geral da PA

			//AN=A1+(n-1)*r
			//A1 primeiro termo
			//R Razaão
			//N Quantidade de Termos
			//An=A1+(n-1)*r;

			}
		System.out.println(an);
		return an;
	}
*/
/*
		public String Criptografia(String aux) throws RemoteException {
			char charArray[];
			char charAux = ' ';
			String output = "";
			int tam = aux.length();

			charArray = new char[tam];
			output += "\nCriptografado: ";

			aux.getChars(0, tam, charArray, 0);

			for (int count = 0; count < charArray.length; count++) {
				if (charArray[count] == ' ')
					charAux = ' ';
				if (charArray[count] == '1')
					charAux = 'A';
				if (charArray[count] == '2')
					charAux = 'B';
				if (charArray[count] == '3')
					charAux = 'C';
				if (charArray[count] == '4')
					charAux = 'D';
				if (charArray[count] == '5')
					charAux = 'E';
				if (charArray[count] == '6')
					charAux = 'F';
				if (charArray[count] == '7')
					charAux = 'G';
				if (charArray[count] == '8')
					charAux = 'H';
				if (charArray[count] == '9')
					charAux = 'I';
				if (charArray[count] == '0')
					charAux = 'j';

				charArray[count] = charAux;
				output += charArray[count];

			}
			return output;

		}
		
		
	   //Criptografia
		
		public String Descriptografia(String aux) throws RemoteException {
			char charArray[];
			char charAux = ' ';
			String output2 = "Descriptografado: " + aux;
			int tam = aux.length();

			charArray = new char[tam];
			output2 += "";

			aux.getChars(0, tam, charArray, 0);

			for (int count = 0; count < charArray.length; count++) {
				if (charArray[count] == ' ')
					charAux = ' ';
				if (charArray[count] == 'A')
					charAux = '1';
				if (charArray[count] == 'B')
					charAux = '2';
				if (charArray[count] == 'C')
					charAux = '3';
				if (charArray[count] == 'D')
					charAux = '4';
				if (charArray[count] == 'E')
					charAux = '5';
				if (charArray[count] == 'F')
					charAux = '6';
				if (charArray[count] == 'G')
					charAux = '7';
				if (charArray[count] == 'H')
					charAux = '8';
				if (charArray[count] == 'I')
					charAux = '9';
				if (charArray[count] == 'J')
					charAux = '0';

				charArray[count] = charAux;
				output2 += charArray[count];
			}
			return output2;
		}
	*/
		
		
	}



