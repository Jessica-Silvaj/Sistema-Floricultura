package br.com.sistemaFloricultura.views;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import br.com.sistemaFloricultura.dataBase.ConexaoUtil;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaProdutos extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProdutos frame = new TelaProdutos();
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
	private JTextField nomeProd;
	private JTextField dimensaoProd;
	private JTextField precoProd;
	private JTextField descricao;

	public void ligarConexao() {
		conexao = ConexaoUtil.conector();
	}

	private void AdicionarProd() {
		String sql = "insert into produtos (nomeprod , precoprod, dimensao, descricao) values (?,?,?,?)";

		try {

			pst = conexao.prepareStatement(sql);
			pst.setString(1, nomeProd.getText());
			pst.setString(2, precoProd.getText());
			pst.setString(3, dimensaoProd.getText());
			pst.setString(4, descricao.getText());

			if ((nomeProd.getText().isEmpty()) || (precoProd.getText().isEmpty()) || (dimensaoProd.getText().isEmpty())
					|| (descricao.getText().isEmpty())) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");

			} else {

				int clienteAdicionado = pst.executeUpdate();
				if (clienteAdicionado > 0) {
					JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
					nomeProd.setText(null);
					dimensaoProd.setText(null);
					precoProd.setText(null);
					descricao.setText(null);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	private void consultarProd() {
		String sql = "select * from produtos where nomeprod=?";

		try {

			pst = conexao.prepareStatement(sql);
			pst.setString(1, nomeProd.getText());
			rs = pst.executeQuery();

			if (rs.next()) {

				dimensaoProd.setText(rs.getString(4));
				precoProd.setText(rs.getString(3));
				descricao.setText(rs.getString(5));

			} else {
				JOptionPane.showMessageDialog(null, "Não existe produto com este nome cadastrado!");
				// textNomeFunc.setText(null);
				dimensaoProd.setText(null);
				precoProd.setText(null);
				descricao.setText(null);

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Atenção! Esse produto já existe no sistema, tente novamente! ");
		}
	}

	private void alterarProd() {
		String sql = "update produtos set precoprod=?, dimensao=? , descricao=? where nomeprod=? ";

		try {

			pst = conexao.prepareStatement(sql);
			pst.setString(1, precoProd.getText());
			pst.setString(2, dimensaoProd.getText());
			pst.setString(3, descricao.getText());
			;
			pst.setString(4, nomeProd.getText());

			if ((nomeProd.getText().isEmpty()) || (precoProd.getText().isEmpty()) || (dimensaoProd.getText().isEmpty())
					|| (descricao.getText().isEmpty())) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");

			} else {

				int confirma = JOptionPane.showConfirmDialog(null, "Deseja alterar esse registro?", "Atenção!",
						JOptionPane.YES_NO_OPTION);
				if (confirma == JOptionPane.YES_OPTION) {

					int adicionado = pst.executeUpdate();
					if (adicionado > 0) {
						JOptionPane.showMessageDialog(null, "O dados do protduto foi alterado com sucesso!");
						nomeProd.setText(null);
						precoProd.setText(null);
						dimensaoProd.setText(null);
						descricao.setText(null);
					}

				}
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	private void deletarProd() {
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste produro?", "Atenção!",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			String sql = "delete from produtos where nomeprod=?";

			try {

				pst = conexao.prepareStatement(sql);
				pst.setString(1, nomeProd.getText());
				int apagado = pst.executeUpdate();

				if (apagado > 0) {
					JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
					nomeProd.setText(null);
					precoProd.setText(null);
					dimensaoProd.setText(null);
					descricao.setText(null);
				}

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}

	/**
	 * Create the frame.
	 */
	public TelaProdutos() {
		setFrameIcon(new ImageIcon(TelaProdutos.class.getResource("/icons/boxOne.png")));
		setTitle("Cadastramento de produtos");
		ligarConexao();
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		getContentPane().setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		setBounds(100, 100, 673, 484);
		getContentPane().setLayout(null);

		JLabel lblCadastramentoDeProdutos = new JLabel("Cadastramento de produtos");
		lblCadastramentoDeProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastramentoDeProdutos.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		lblCadastramentoDeProdutos.setBounds(142, 44, 367, 31);
		getContentPane().add(lblCadastramentoDeProdutos);

		JLabel lblNewLabel_7 = new JLabel("* Campos obrigat\u00F3rios");
		lblNewLabel_7.setForeground(Color.BLACK);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_7.setBounds(448, 91, 182, 35);
		getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_1 = new JLabel("* Nome do produto:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(22, 158, 182, 24);
		getContentPane().add(lblNewLabel_1);

		nomeProd = new JTextField();
		nomeProd.setColumns(10);
		nomeProd.setBounds(207, 158, 406, 24);
		getContentPane().add(nomeProd);

		JLabel lblNewLabel_1_1_1 = new JLabel("* Dimensao:");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_1_1.setBounds(50, 248, 106, 24);
		getContentPane().add(lblNewLabel_1_1_1);

		dimensaoProd = new JTextField();
		dimensaoProd.setColumns(10);
		dimensaoProd.setBounds(166, 248, 447, 24);
		getContentPane().add(dimensaoProd);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("* Descri\u00E7\u00E3o:");
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_1_1_1.setBounds(38, 304, 106, 24);
		getContentPane().add(lblNewLabel_1_1_1_1);

		precoProd = new JTextField();
		precoProd.setColumns(10);
		precoProd.setBounds(166, 207, 152, 24);
		getContentPane().add(precoProd);

		JLabel lblNewLabel_1_1_1_2 = new JLabel("* Pre\u00E7o:");
		lblNewLabel_1_1_1_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_1_1_2.setBounds(50, 205, 106, 24);
		getContentPane().add(lblNewLabel_1_1_1_2);

		JButton btnAdicionarProd = new JButton("Adicionar");
		btnAdicionarProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdicionarProd();
			}

		});
		btnAdicionarProd.setIcon(new ImageIcon(TelaProdutos.class.getResource("/icons/add20.png")));
		btnAdicionarProd.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnAdicionarProd.setBackground(SystemColor.menu);
		btnAdicionarProd.setBounds(22, 409, 143, 23);
		getContentPane().add(btnAdicionarProd);

		JButton btnConsultarProd = new JButton("Consultar");
		btnConsultarProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarProd();
			}
		});
		btnConsultarProd.setIcon(new ImageIcon(TelaProdutos.class.getResource("/icons/search.png")));
		btnConsultarProd.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnConsultarProd.setBackground(SystemColor.menu);
		btnConsultarProd.setBounds(175, 409, 134, 23);
		getContentPane().add(btnConsultarProd);

		JButton btnAlterarProd = new JButton("Alterar");
		btnAlterarProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarProd();
			}
		});
		btnAlterarProd.setIcon(new ImageIcon(TelaProdutos.class.getResource("/icons/edit.png")));
		btnAlterarProd.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnAlterarProd.setBackground(SystemColor.menu);
		btnAlterarProd.setBounds(337, 409, 137, 23);
		getContentPane().add(btnAlterarProd);

		JButton btnDeletarCli = new JButton("Deletar");
		btnDeletarCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletarProd();
			}
		});
		btnDeletarCli.setIcon(new ImageIcon(TelaProdutos.class.getResource("/icons/delete.png")));
		btnDeletarCli.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnDeletarCli.setBackground(SystemColor.menu);
		btnDeletarCli.setBounds(484, 409, 141, 23);
		getContentPane().add(btnDeletarCli);

		descricao = new JTextField();
		descricao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		descricao.setBounds(154, 304, 459, 24);
		getContentPane().add(descricao);
		descricao.setColumns(10);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TelaProdutos.class.getResource("/icons/papeldeparede.jpg")));
		lblNewLabel.setBounds(-67, 11, 776, 553);
		getContentPane().add(lblNewLabel);

	}
}
