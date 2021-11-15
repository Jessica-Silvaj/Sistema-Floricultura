package br.com.sistemaFloricultura.views;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import br.com.sistemaFloricultura.dataBase.ConexaoUtil;
import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaListaFuncionarios extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaFuncionarios frame = new TelaListaFuncionarios();
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
	private JTable tableFuncionarios;
	
	public void ligarConexao() {
		conexao = ConexaoUtil.conector();
	}
	
 private void pesquisarFuncionarios() {
	 String sql = "select * from funcionarios ";
 
	 try {

			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();
			tableFuncionarios.setModel(DbUtils.resultSetToTableModel(rs));
		
           
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	
 }

	private void deletarAll() {
		int confirma = JOptionPane.showConfirmDialog(null, "deseja mesmo excluir  todos os registros?", "Atenção!",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			String sql = "truncate funcionarios";

			try {
				
				pst = conexao.prepareStatement(sql);
				int apagado = pst.executeUpdate();
			    
				if(apagado > 0) {
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
	public TelaListaFuncionarios() {
		setFrameIcon(new ImageIcon(TelaListaFuncionarios.class.getResource("/icons/team20.png")));
		ligarConexao();
		setTitle("Lista Funcionarios");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 707, 501);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lista de Funcionarios");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(167, 36, 288, 35);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Listar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarFuncionarios();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnNewButton.setBounds(451, 92, 141, 23);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(25, 141, 584, 308);
		getContentPane().add(scrollPane);
		
		tableFuncionarios = new JTable();
		tableFuncionarios.setEnabled(false);
		tableFuncionarios.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "nome", "fone", "e-mail", "login", "senha", "perfil"
			}
		));
		scrollPane.setViewportView(tableFuncionarios);
		
		JButton btnNewButton_1 = new JButton("Excluir todos os registros");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletarAll();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		btnNewButton_1.setBounds(128, 471, 387, 29);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaListaFuncionarios.class.getResource("/icons/papeldeparede.jpg")));
		lblNewLabel_1.setBounds(-38, -51, 848, 624);
		getContentPane().add(lblNewLabel_1);
		setBounds(100, 100, 653, 554);

	}
}
