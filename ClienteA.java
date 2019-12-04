package RMIPA;
import java.rmi.*;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class ClienteA {
	
	public static void main(String[] args) {
		JDialog dialog = new JDialog();
		Interface serv = null; // objeto controlador do servidor
		String[] result = { "Continuar", "Criptografar", "Sair" };
		String A, resp="", resp2 = "";

		Object[] servidor = { "Servidor A", "Servidor B" };
		Object escolha = JOptionPane.showInputDialog(null, "Qual servidor?", "ClienteA", JOptionPane.QUESTION_MESSAGE,
				null, servidor, servidor[0]);
		/* ESCOLHA DO SERVIDOR */

		try {
			if (escolha == servidor[0]) {
				serv = (Interface) Naming.lookup("//127.0.0.1/rmi");

			} else if (escolha == servidor[1]) {
				serv = (Interface) Naming.lookup("//127.0.0.1/rmi");
			}
		} catch (Exception e) {
			System.err.println("Erro: " + e);
			e.printStackTrace();
		}
		
		try {
			for (;;) {
				if (serv.controlador() == 0) {
					String str = JOptionPane.showInputDialog(null, "ClienteA" + "\nEntre com o primeiro termo: ");
					int ptermo = Integer.parseInt(str);
					serv.setPtermo(ptermo);
					
					JOptionPane aviso0 = new JOptionPane(
							"ClienteA" + "\nAguardando o clienteB",
							JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] {});
					dialog.setContentPane(aviso0);
					dialog.pack();
					dialog.setVisible(true);
					dialog.setLocationRelativeTo(null);
					
					
				} else if (serv.controlador() ==2) {
					dialog.setVisible(false);
					
					if(serv.getQtermo() ==1) {
						String str3 = JOptionPane.showInputDialog(null,"ClienteA"+"\nDigite a quantidade de termos");
						int qtermo = Integer.parseInt(str3);
						
						serv.setQtermo(qtermo);
						
					}
					
					}else if (serv.controlador() == 3) {
						
						int resposta = JOptionPane.showOptionDialog(null,
								"ClienteA digitou: " + "\nO primeiro termo" + serv.getPtermo() + "\na Razao: " + serv.getRazao()
										+ "%" + "\nValor das parcelas: " + serv.calcula(),
								"ClienteA", 0, JOptionPane.INFORMATION_MESSAGE, null, result, result[0]);
						
						if (resposta == 0)
							serv.zerar();/*
						else if (resposta == 1) {
							A = String.valueOf(serv.calcula());
							resp = serv.Criptografia(A);
							int opcao = JOptionPane.showConfirmDialog(null, resp + "\nVocê deseja descriptografar?", null,
									JOptionPane.YES_NO_OPTION);
							if (opcao == JOptionPane.YES_OPTION)
								resp2 = serv.Descriptografia(A);
							int opcao2 = JOptionPane.showConfirmDialog(null, resp2 + "\nVocê deseja voltar?", null,
									JOptionPane.YES_NO_OPTION);
							if (opcao2 == JOptionPane.YES_OPTION)
								serv.zerar();
							else if (opcao == JOptionPane.NO_OPTION)
								System.exit(0);
							else if (opcao == JOptionPane.NO_OPTION)
								System.exit(0);

						}*/else if (resposta == 2)
							System.exit(0);
					}
				}
			}
		catch (Exception e) {
		System.err.println("Erro: " + e);
		e.printStackTrace();
	}

}
}
