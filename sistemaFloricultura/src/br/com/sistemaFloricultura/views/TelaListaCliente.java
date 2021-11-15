package br.com.sistemaFloricultura.views;

import java.awt.EventQueue;

import java.sql.*;
import net.proteanit.sql.*;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.ScrollPane;
import java.awt.Button;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.sistemaFloricultura.dataBase.ConexaoUtil;

import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaListaCliente extends JInternalFrame {
	private JTable tableCliente;
	public static JButton deleteCli;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaCliente frame = new TelaListaCliente();
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

	private void pesquisarCliente() {
		String sql = "select * from clientes ";

		try {

			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();
			tableCliente.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "e");
		}
	}

	private void deletarAll() {
		int confirma = JOptionPane.showConfirmDialog(null, "deseja mesmo excluir  todos os registros?", "Atenção!",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			String sql = "truncate clientes";

			try {

				pst = conexao.prepareStatement(sql);
				int apagado = pst.executeUpdate();

				if (apagado > 0) {
					JOptionPane.showMessageDialog(null, "Registros excluidos com sucesso com sucesso!");

				}

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}

	/**
	 * Create the frame.
	 */
	public TelaListaCliente() {
		setFrameIcon(new ImageIcon(TelaListaCliente.class.getResource("/icons/clients.png")));
		ligarConexao();
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("Lista de Clientes");
		setBounds(100, 100, 653, 554);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Lista de Clientes");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(61, 30, 507, 29);
		getContentPane().add(lblNewLabel);

		JButton deleteCli = new JButton("Excluir todos os registros");
		deleteCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletarAll();
			}
		});
		deleteCli.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		deleteCli.setBounds(113, 484, 367, 29);
		getContentPane().add(deleteCli);

		JScrollPane scrClientes = new JScrollPane();
		scrClientes.setEnabled(false);
		scrClientes.setBounds(24, 110, 592, 363);
		getContentPane().add(scrClientes);

		tableCliente = new JTable();
		tableCliente.setEnabled(false);
		tableCliente.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "id", "Nome", "Cpf", "Endereço", "fone", "E-mail" }));
		scrClientes.setViewportView(tableCliente);

		JButton btnNewButton = new JButton("Listar");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarCliente();
			}
		});
		btnNewButton.setBounds(527, 56, 89, 29);
		getContentPane().add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaListaCliente.class.getResource("/icons/papeldeparede.jpg")));
		lblNewLabel_1.setBounds(-28, -37, 756, 622);
		getContentPane().add(lblNewLabel_1);

	}
}
