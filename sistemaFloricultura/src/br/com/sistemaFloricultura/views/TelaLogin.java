package br.com.sistemaFloricultura.views;

/**
 * 
 * Unime - União Metropolitana de Educação e Cultura Curso: Bacharelado em
 * Sistemas de Informação Disciplina: Programação Orientada a Objetos II
 * Professor(a): Pablo Ricardo Roxo Silva 
 * Aluno(a): Jéssica Silva de Jesus
 *
 */

import java.awt.EventQueue;


import java.sql.*;
import br.com.sistemaFloricultura.dataBase.*;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.ImageIcon;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin {

	private JFrame frmFlowerShopLogin;
	private JTextField textLogin;
	private JPasswordField passwordSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin();
					window.frmFlowerShopLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JLabel lblStatus;

	public void logar() {
		String sql = "select * from funcionarios where login=? and senha=?";

		try {

			// pegar os dados que estão sendo escrito na tela Principal
			pst = conexao.prepareStatement(sql);
			pst.setString(1, textLogin.getText());

			// Forma segura de recuperar uma senha
			String captura = new String(passwordSenha.getPassword());
			pst.setString(2, captura);

			// executar a query
			rs = pst.executeQuery();

			if (rs.next()) {

				String perfil = rs.getString(7);
				// System.out.print(perfil);

				if (perfil.equals("Administrador")) {
					TelaPrincipal principal = new TelaPrincipal();
					principal.setVisible(true);
					TelaPrincipal.textUsuario.setText(rs.getString(2));
					TelaPrincipal.textUsuario.setForeground(Color.red);
					frmFlowerShopLogin.dispose();

				} else if (perfil.equals("Atendente")) {

					TelaPrincipal principal = new TelaPrincipal();
					TelaPrincipal.textUsuario.setText(rs.getString(2));
					TelaPrincipal.textUsuario.setForeground(Color.BLUE);
					TelaPrincipal.funcionarios.setEnabled(false);
					principal.setVisible(true);
					frmFlowerShopLogin.dispose();
				}

				conexao.close();
			} else {
				JOptionPane.showMessageDialog(null, "O login e/ou  senha está inválido (s) ");
			}

		} catch (Exception e) {
			// JOptionPane.showMessageDialog(null, e);
			JOptionPane.showMessageDialog(null, "Atenção! ocorreu um erro ao consulta os dados");
		}

	}

	/**
	 * Create the application.
	 */
	public TelaLogin() {
		initialize();
		conexao = ConexaoUtil.conector();
		// Apoio ao status da conexão
		// System.out.println(conexao);

		if (conexao != null) {
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/database-view.png")));
		} else {
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/database-delete.png")));
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFlowerShopLogin = new JFrame();
		frmFlowerShopLogin
				.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/icons/flower.png")));
		frmFlowerShopLogin.getContentPane().setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		frmFlowerShopLogin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		frmFlowerShopLogin.setBackground(new Color(255, 255, 255));
		frmFlowerShopLogin.setResizable(false);
		frmFlowerShopLogin.setTitle("Flower Shop");
		frmFlowerShopLogin.setBounds(100, 100, 450, 300);
		frmFlowerShopLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFlowerShopLogin.getContentPane().setLayout(null);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setVerticalAlignment(SwingConstants.BOTTOM);
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblLogin.setBounds(0, 101, 119, 30);
		frmFlowerShopLogin.getContentPane().add(lblLogin);

		textLogin = new JTextField();
		textLogin.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textLogin.setBounds(122, 101, 252, 30);
		frmFlowerShopLogin.getContentPane().add(textLogin);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSenha.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setBounds(0, 145, 119, 30);
		frmFlowerShopLogin.getContentPane().add(lblSenha);

		passwordSenha = new JPasswordField();
		passwordSenha.setBounds(122, 145, 252, 30);
		frmFlowerShopLogin.getContentPane().add(passwordSenha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// chamando o método logar
				logar();
			}
		});

		btnEntrar.setForeground(Color.BLACK);
		btnEntrar.setBackground(UIManager.getColor("Button.background"));
		btnEntrar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnEntrar.setBounds(145, 195, 211, 30);
		frmFlowerShopLogin.getContentPane().add(btnEntrar);

		lblStatus = new JLabel("");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setIcon(new ImageIcon(TelaLogin.class.getResource("/icons/database-delete.png")));
		lblStatus.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblStatus.setBounds(0, 177, 119, 73);
		frmFlowerShopLogin.getContentPane().add(lblStatus);

		JLabel lblNewLabel = new JLabel("  Flower Shop");
		lblNewLabel.setIcon(new ImageIcon(TelaLogin.class.getResource("/icons/flower.png")));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 43));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(43, 25, 313, 44);
		frmFlowerShopLogin.getContentPane().add(lblNewLabel);

		JLabel lblIcons = new JLabel("");
		lblIcons.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcons.setIcon(new ImageIcon(TelaLogin.class.getResource("/icons/flower.png")));
		lblIcons.setBounds(367, 25, 57, 45);
		frmFlowerShopLogin.getContentPane().add(lblIcons);

		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(TelaLogin.class.getResource("/icons/fundo.jpg")));
		lblFundo.setBounds(0, 0, 434, 261);
		frmFlowerShopLogin.getContentPane().add(lblFundo);
	}
}
