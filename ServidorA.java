package RMIPA;

import java.rmi.Naming;

import javax.swing.JOptionPane;

public class ServidorA {
	public static void main(String[] args) {
		try {
			Impl calcula = new Impl();
			Naming.rebind("//localhost/rmi", calcula);
			JOptionPane.showMessageDialog(null,"ServidorA OK!");
			System.out.println("ServidorA no ar." + "\n Inicialmente x = : " );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
