package RMIPA;
import java.rmi.*;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class ClienteB {
	public static void main(String[] args) {
		
		JDialog dialog = new JDialog();
		JDialog dialog2 = new JDialog();
		Interface serv = null; // objeto controlador do servidor
		String[] result = { "Continuar", "Criptografar", "Sair" };
		String A, resp = "", resp2 = "";

		Object[] servidor = { "Servidor A", "Servidor B" }; // vetor de objetos
		Object escolha = JOptionPane.showInputDialog(null, "Qual servidor?", "ClienteB", JOptionPane.QUESTION_MESSAGE,
				null, servidor, servidor[0]);
		
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
			JOptionPane aviso = new JOptionPane("ClienteB" + "\nAguardando o valor da compra do clienteA",
					JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] {});
			dialog.setContentPane(aviso);
			dialog.setSize(500, 500);
			dialog.pack();
			dialog.setVisible(false);
			dialog.setLocationRelativeTo(null);
			for (;;) {
				if (serv.controlador() == 0) {
					dialog.setVisible(true);
					
			}else if (serv.controlador() == 1) {
				dialog.setVisible(false);
				String str2 = JOptionPane.showInputDialog(null,"ClienteB" + "\nEntre com a razao: ");
				int razao = Integer.parseInt(str2);
				
				if(razao >=2 && razao <=12)
					serv.setRazao(razao);
				else if(razao ==1)
					serv.setRazao(razao);
				else
					dialog.setVisible(true);
				
				JOptionPane aviso2 = new JOptionPane("ClienteB" + "\nAguardando o valor do juros do clienteA",
						JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[] {});
				dialog2.setContentPane(aviso2);
				dialog2.pack();
				dialog2.setVisible(true);
				dialog2.setLocationRelativeTo(null);
				
				
			}else if (serv.controlador() == 3) {
				dialog2.setVisible(false);
				int resposta = JOptionPane.showOptionDialog(null,"ClienteB digitou: "+"\nRazao: "+serv.getRazao() + "\nValor das parcelas: "+ serv.calcula(),"ClienteB", 0, JOptionPane.INFORMATION_MESSAGE, null, result, result[0]);
				
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
		
		}catch (Exception e) {
			System.err.println("Erro: " + e);
			e.printStackTrace();

	}
		
	}
}
