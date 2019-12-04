package RMIPA;

import java.rmi.*;
import javax.swing.JOptionPane;

public class ServidorB {

	public static void main(String[] args) {
		try {
			Impl calcula = new Impl();
			Naming.rebind("//localhost/rmi", calcula);
			JOptionPane.showMessageDialog(null,"ServidorB OK!");
			System.out.println("ServidorB no ar." + "\n Inicialmente x = : " );
				if (calcula.controlador()>=0) {
					System.out.println("ServidorB no ar." + "\nReplicação: ");
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
