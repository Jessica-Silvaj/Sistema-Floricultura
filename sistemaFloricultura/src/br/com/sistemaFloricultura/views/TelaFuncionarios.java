package br.com.sistemaFloricultura.views;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import br.com.sistemaFloricultura.dataBase.ConexaoUtil;

import java.awt.Font;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

public class TelaFuncionarios extends JInternalFrame {
	private JTextField textNomeFunc;
	private JTextField textEmail;
	private JTextField textFone;
	private JTextField textLogin;
	private JPasswordField passwordSenha;
	private JComboBox<String> cboPerfil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFuncionarios frame = new TelaFuncionarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	public void ligarConexao() {
		conexao = ConexaoUtil.conector();
	}

	private void consultar() {
		String sql = "select * from funcionarios where login=?";

		try {

			pst = conexao.prepareStatement(sql);
			pst.setString(1, textLogin.getText());
			rs = pst.executeQuery();

			if (rs.next()) {

				textNomeFunc.setText(rs.getString(2));
				textEmail.setText(rs.getString(4));
				textFone.setText(rs.getString(3));
				textLogin.setText(rs.getString(5));
				passwordSenha.setText(rs.getString(6));
				cboPerfil.setSelectedItem(rs.getString(7));

			} else {
				JOptionPane.showMessageDialog(null, "Não existe funcionario com este login cadastrado!");
				// textNomeFunc.setText(null);
				textEmail.setText(null);
				textFone.setText(null);
				textNomeFunc.setText(null);
				passwordSenha.setText(null);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Atenção! Esse login já existe no sistema, tente novamente! ");
		}

	}

	private void adicionar() {
		String sql = "insert into funcionarios (nomeFunc ,fonefunc, emailfunc,login,senha,perfil ) values (?,?,?,?,?,?)";

		try {

			pst = conexao.prepareStatement(sql);
			pst.setString(1, textNomeFunc.getText());
			pst.setString(2, textFone.getText());
			pst.setString(3, textEmail.getText());
			pst.setString(4, textLogin.getText());
			pst.setString(5, passwordSenha.getText());
			pst.setString(6, cboPerfil.getSelectedItem().toString());

			if ((textNomeFunc.getText().isEmpty()) || (textLogin.getText().isEmpty())
					|| (passwordSenha.getPassword().length == 0) || cboPerfil.getSelectedItem().equals(" ")) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");

			} else {

				int adicionado = pst.executeUpdate();
				if (adicionado > 0) {
					JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso!");
					textNomeFunc.setText(null);
					textEmail.setText(null);
					textFone.setText(null);
					textLogin.setText(null);
					passwordSenha.setText(null);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	private void alterar() {
		String sql = "update funcionarios set nomeFunc=?, fonefunc=?, emailfunc=? , senha=?, perfil=? where login=? ";

		try {

			pst = conexao.prepareStatement(sql);
			pst.setString(1, textNomeFunc.getText());
			pst.setString(2, textFone.getText());
			pst.setString(3, textEmail.getText());
			pst.setString(4, passwordSenha.getText());
			pst.setString(5, cboPerfil.getSelectedItem().toString());
			pst.setString(6, textLogin.getText());

			if ((textNomeFunc.getText().isEmpty()) || (textLogin.getText().isEmpty())
					|| (passwordSenha.getPassword().length == 0) || cboPerfil.getSelectedItem().equals(" ")) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");

			} else {

				int adicionado = pst.executeUpdate();
				if (adicionado > 0) {
					JOptionPane.showMessageDialog(null, "Dado do funcionario alterado com sucesso!");
					textNomeFunc.setText(null);
					textEmail.setText(null);
					textFone.setText(null);
					textLogin.setText(null);
					passwordSenha.setText(null);
				}
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	private void deletar() {
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste usuário?", "Atenção!",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			String sql = "delete from funcionarios where login=?";

			try {
				
				pst = conexao.prepareStatement(sql);
				pst.setString(1, textLogin.getText());
				int apagado = pst.executeUpdate();
			    
				if(apagado > 0) {
					JOptionPane.showMessageDialog(null, "Funcionario removido com sucesso!");
					textNomeFunc.setText(null);
					textEmail.setText(null);
					textFone.setText(null);
					textLogin.setText(null);
					passwordSenha.setText(null);
				} 
				
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		}


	/**
	 * Create the frame.
	 */
	public TelaFuncionarios() {
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setFrameIcon(new ImageIcon(TelaFuncionarios.class.getResource("/icons/team20.png")));
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		ligarConexao();

		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Cadastrar Funcionarios");
		setBounds(100, 100, 654, 421);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastramento de Funcionarios");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(90, 33, 400, 24);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("* Nome do funcionario:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(25, 108, 205, 24);
		getContentPane().add(lblNewLabel_1);

		textNomeFunc = new JTextField();
		textNomeFunc.setBounds(233, 110, 352, 24);
		getContentPane().add(textNomeFunc);
		textNomeFunc.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("E-mail:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(25, 143, 78, 30);
		getContentPane().add(lblNewLabel_2);

		textEmail = new JTextField();
		textEmail.setBounds(113, 143, 461, 27);
		getContentPane().add(textEmail);
		textEmail.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Telefone:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setBounds(25, 184, 90, 24);
		getContentPane().add(lblNewLabel_3);

		textFone = new JTextField();
		textFone.setBounds(113, 181, 171, 27);
		getContentPane().add(textFone);
		textFone.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel(" * Perfil:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_4.setBounds(294, 181, 87, 24);
		getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("* Login:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_5.setBounds(25, 229, 78, 24);
		getContentPane().add(lblNewLabel_5);

		textLogin = new JTextField();
		textLogin.setBounds(100, 231, 194, 24);
		getContentPane().add(textLogin);
		textLogin.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("* Senha:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_6.setBounds(304, 231, 77, 21);
		getContentPane().add(lblNewLabel_6);

		passwordSenha = new JPasswordField();
		passwordSenha.setBounds(391, 231, 182, 24);
		getContentPane().add(passwordSenha);

		cboPerfil = new JComboBox<String>();
		cboPerfil.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		cboPerfil.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Atendente"}));
		cboPerfil.setSelectedIndex(0);
		cboPerfil.setMaximumRowCount(2);
		cboPerfil.setBounds(379, 182, 208, 28);
		getContentPane().add(cboPerfil);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnAdicionar.setBackground(UIManager.getColor("Button.background"));
		btnAdicionar.setIcon(new ImageIcon(TelaFuncionarios.class.getResource("/icons/add20.png")));
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
		});
		btnAdicionar.setBounds(25, 307, 143, 23);
		getContentPane().add(btnAdicionar);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setIcon(new ImageIcon(TelaFuncionarios.class.getResource("/icons/search.png")));
		btnConsultar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnConsultar.setBackground(UIManager.getColor("Button.background"));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultar();
			}
		});
		btnConsultar.setBounds(195, 309, 134, 23);
		getContentPane().add(btnConsultar);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBackground(UIManager.getColor("Button.background"));
		btnAlterar.setIcon(new ImageIcon(TelaFuncionarios.class.getResource("/icons/edit.png")));
		btnAlterar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterar();
			}
		});
		btnAlterar.setBounds(355, 309, 120, 23);
		getContentPane().add(btnAlterar);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBackground(UIManager.getColor("Button.background"));
		btnDeletar.setIcon(new ImageIcon(TelaFuncionarios.class.getResource("/icons/delete.png")));
		btnDeletar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletar();
			}
		});
		btnDeletar.setBounds(496, 309, 125, 23);
		getContentPane().add(btnDeletar);

		JLabel lblNewLabel_7 = new JLabel("* Campos obrigat\u00F3rios");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_7.setForeground(Color.BLACK);
		lblNewLabel_7.setBounds(428, 68, 182, 29);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(0, 0, 638, 391);
		getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(TelaFuncionarios.class.getResource("/icons/papeldeparede.jpg")));
		lblNewLabel_9.setBounds(0, 0, 707, 526);
		getContentPane().add(lblNewLabel_9);

	}
}
