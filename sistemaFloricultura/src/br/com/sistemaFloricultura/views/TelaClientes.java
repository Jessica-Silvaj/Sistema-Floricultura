package br.com.sistemaFloricultura.views;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

import br.com.sistemaFloricultura.dataBase.ConexaoUtil;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaClientes extends JInternalFrame {
	private JTextField textCliente;
	private JTextField textEndCli;
	private JTextField textEmailCli;
	private JTextField textFoneCli;
	private JTextField textCpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaClientes frame = new TelaClientes();
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

	private void AdicionarCli() {
		String sql = "insert into clientes (nomecli ,cpfcli, endcli, fonecli ,emailcli) values (?,?,?,?,?)";

		try {

			pst = conexao.prepareStatement(sql);
			pst.setString(1, textCliente.getText());
			pst.setString(2, textCpf.getText());
			pst.setString(3, textEndCli.getText());
			pst.setString(4, textFoneCli.getText());
			pst.setString(5, textEmailCli.getText());

			if ((textCliente.getText().isEmpty()) || (textEndCli.getText().isEmpty()) || (textCpf.getText().isEmpty())
					|| (textFoneCli.getText().isEmpty()) || (textEmailCli.getText().isEmpty())) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");

			} else {

				int clienteAdicionado = pst.executeUpdate();
				if (clienteAdicionado > 0) {
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
					textCliente.setText(null);
					textCpf.setText(null);
					textEndCli.setText(null);
					textFoneCli.setText(null);
					textEmailCli.setText(null);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	private void consultarCli() {
		String sql = "select * from clientes where cpfcli=?";

		try {

			pst = conexao.prepareStatement(sql);
			pst.setString(1, textCpf.getText());
			rs = pst.executeQuery();

			if (rs.next()) {

				textCliente.setText(rs.getString(2));
				textEndCli.setText(rs.getString(4));
				textFoneCli.setText(rs.getString(5));
				textEmailCli.setText(rs.getString(6));

			} else {
				JOptionPane.showMessageDialog(null, "Não existe cliente com este cpf cadastrado!");
				// textNomeFunc.setText(null);
				textCliente.setText(null);
				textEndCli.setText(null);
				textFoneCli.setText(null);
				textEmailCli.setText(null);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Atenção! Esse cpf já existe no sistema, tente novamente! ");
		}
	}

	private void alterarCli() {
		String sql = "update clientes set nomecli=?, endcli=? , fonecli=?, emailcli=? where cpfcli=? ";

		try {

			pst = conexao.prepareStatement(sql);
			pst.setString(1, textCliente.getText());
			pst.setString(2, textEndCli.getText());
			pst.setString(3, textFoneCli.getText());
			pst.setString(4, textEmailCli.getText());
			pst.setString(5, textCpf.getText());
			;

			if ((textCliente.getText().isEmpty()) || (textEndCli.getText().isEmpty())
					|| (textFoneCli.getText().isEmpty()) || (textEmailCli.getText().isEmpty())) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");

			} else {

				int confirma = JOptionPane.showConfirmDialog(null, "Deseja alterar esse registro?", "Atenção!",
						JOptionPane.YES_NO_OPTION);
				if (confirma == JOptionPane.YES_OPTION) {

					int adicionado = pst.executeUpdate();
					if (adicionado > 0) {
						JOptionPane.showMessageDialog(null, "O dados do clientes alterado com sucesso!");
						textCliente.setText(null);
						textEndCli.setText(null);
						textFoneCli.setText(null);
						textEmailCli.setText(null);

					}
				}
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	private void deletarCli() {
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste usuário?", "Atenção!",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			String sql = "delete from clientes where cpfCli=?";

			try {

				pst = conexao.prepareStatement(sql);
				pst.setString(1, textCpf.getText());
				int apagado = pst.executeUpdate();

				if (apagado > 0) {
					JOptionPane.showMessageDialog(null, "Funcionario removido com sucesso!");
					textCliente.setText(null);
					textFoneCli.setText(null);
					textEndCli.setText(null);
					textEmailCli.setText(null);
				}

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}

	/**
	 * Create the frame.
	 */
	public TelaClientes() {

		ligarConexao();

		setTitle("Cadastrar Cliente");
		setFrameIcon(new ImageIcon(TelaClientes.class.getResource("/icons/clients.png")));
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setBackground(Color.WHITE);
		setBounds(100, 100, 654, 450);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastramento de clientes");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(136, 31, 367, 29);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_7 = new JLabel("* Campos obrigat\u00F3rios");
		lblNewLabel_7.setForeground(Color.BLACK);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_7.setBounds(458, 71, 182, 35);
		getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_1 = new JLabel("* Nome do cliente:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(26, 163, 157, 24);
		getContentPane().add(lblNewLabel_1);

		textCliente = new JTextField();
		textCliente.setBounds(193, 165, 406, 24);
		getContentPane().add(textCliente);
		textCliente.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Endere\u00E7o:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_1.setBounds(38, 233, 93, 24);
		getContentPane().add(lblNewLabel_1_1);

		textEndCli = new JTextField();
		textEndCli.setColumns(10);
		textEndCli.setBounds(141, 235, 461, 24);
		getContentPane().add(textEndCli);

		JLabel lblNewLabel_1_1_1 = new JLabel("E-mail:");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_1_1.setBounds(56, 198, 65, 24);
		getContentPane().add(lblNewLabel_1_1_1);

		textEmailCli = new JTextField();
		textEmailCli.setColumns(10);
		textEmailCli.setBounds(131, 200, 468, 24);
		getContentPane().add(textEmailCli);

		JLabel lblNewLabel_3 = new JLabel("* Telefone:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setBounds(41, 279, 100, 24);
		getContentPane().add(lblNewLabel_3);

		textFoneCli = new JTextField();
		textFoneCli.setColumns(10);
		textFoneCli.setBounds(151, 280, 171, 27);
		getContentPane().add(textFoneCli);

		JLabel lblNewLabel_3_1 = new JLabel("* Cpf:");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3_1.setBounds(353, 279, 65, 24);
		getContentPane().add(lblNewLabel_3_1);

		textCpf = new JTextField();
		textCpf.setColumns(10);
		textCpf.setBounds(428, 280, 171, 27);
		getContentPane().add(textCpf);

		JButton btnAdicionarCli = new JButton("Adicionar");
		btnAdicionarCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdicionarCli();
			}
		});
		btnAdicionarCli.setIcon(new ImageIcon(TelaClientes.class.getResource("/icons/add20.png")));
		btnAdicionarCli.setSelectedIcon(new ImageIcon(TelaClientes.class.getResource("/icons/add20.png")));
		btnAdicionarCli.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnAdicionarCli.setBackground(SystemColor.menu);
		btnAdicionarCli.setBounds(38, 364, 143, 23);
		getContentPane().add(btnAdicionarCli);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarCli();
			}
		});
		btnConsultar.setIcon(new ImageIcon(TelaClientes.class.getResource("/icons/search.png")));
		btnConsultar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnConsultar.setBackground(SystemColor.menu);
		btnConsultar.setBounds(208, 364, 134, 23);
		getContentPane().add(btnConsultar);

		JButton btnAlterarCli = new JButton("Alterar");
		btnAlterarCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarCli();
			}
		});
		btnAlterarCli.setIcon(new ImageIcon(TelaClientes.class.getResource("/icons/edit.png")));
		btnAlterarCli.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnAlterarCli.setBackground(SystemColor.menu);
		btnAlterarCli.setBounds(352, 364, 137, 23);
		getContentPane().add(btnAlterarCli);

		JButton btnDeletarCli = new JButton("Deletar");
		btnDeletarCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletarCli();
			}

		});
		btnDeletarCli.setIcon(new ImageIcon(TelaClientes.class.getResource("/icons/delete.png")));
		btnDeletarCli.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnDeletarCli.setBackground(SystemColor.menu);
		btnDeletarCli.setBounds(499, 364, 141, 23);
		getContentPane().add(btnDeletarCli);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(TelaClientes.class.getResource("/icons/papeldeparede.jpg")));
		lblNewLabel_2.setBounds(-114, -170, 929, 787);
		getContentPane().add(lblNewLabel_2);

	}
}
