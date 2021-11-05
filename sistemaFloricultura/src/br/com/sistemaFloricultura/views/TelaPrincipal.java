package br.com.sistemaFloricultura.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.text.DateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JLabel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Insets;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.border.CompoundBorder;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.JEditorPane;
import javax.swing.border.LineBorder;


public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textData;
	private JTextField textUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
			
	}
	
	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setAlwaysOnTop(true);
		setResizable(false);
		setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		setTitle("Flower Shop");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/icons/flower.png")));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 622);
		
		JMenuBar menuNavegacao = new JMenuBar();
		menuNavegacao.setBorderPainted(false);
		menuNavegacao.setForeground(SystemColor.menu);
		menuNavegacao.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		menuNavegacao.setBackground(new Color(255, 255, 255));
		setJMenuBar(menuNavegacao);
		
		JMenu cadastro = new JMenu("Cadastro");
		cadastro.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		cadastro.setHorizontalAlignment(SwingConstants.CENTER);
		menuNavegacao.add(cadastro);
		
		JMenuItem clientes = new JMenuItem("Clientes");
		clientes.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		cadastro.add(clientes);
		
		JMenuItem produtos = new JMenuItem("Produtos");
		produtos.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		cadastro.add(produtos);
		
		JMenuItem funcionarios = new JMenuItem("Funcionarios");
		funcionarios.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		cadastro.add(funcionarios);
		
		JMenuItem fornecedores = new JMenuItem("Fornecedores");
		fornecedores.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		cadastro.add(fornecedores);
		
		JMenu relatorio = new JMenu("Relat\u00F3rio");
		relatorio.setIcon(null);
		relatorio.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		relatorio.setHorizontalAlignment(SwingConstants.CENTER);
		menuNavegacao.add(relatorio);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Servi\u00E7o");
		mntmNewMenuItem_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		relatorio.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Vendas");
		mntmNewMenuItem_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		relatorio.add(mntmNewMenuItem_6);
		
		JMenu ajuda = new JMenu("Ajuda");
		ajuda.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// Chamando a tela Sobre
				
				
			}
		});
		ajuda.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		ajuda.setHorizontalAlignment(SwingConstants.CENTER);
		menuNavegacao.add(ajuda);
		
		JMenuItem sobre = new JMenuItem("Sobre o sistema");
		sobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSobre sobre = new TelaSobre();
				sobre.setVisible(true);
			}
		});
		sobre.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		sobre.setHorizontalAlignment(SwingConstants.CENTER);
		sobre.setSelected(true);
		ajuda.add(sobre);
		
		JMenu sair = new JMenu("Sair");
		sair.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		sair.setHorizontalAlignment(SwingConstants.CENTER);
		menuNavegacao.add(sair);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktop = new JDesktopPane();
		desktop.setBorder(new LineBorder(new Color(0, 0, 0)));
		desktop.setBackground(new Color(255, 102, 102));
		desktop.setBounds(0, 0, 686, 556);
		contentPane.add(desktop);
		
		JLabel icons1 = new JLabel("");
		icons1.setHorizontalAlignment(SwingConstants.CENTER);
		icons1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icons/flower.png")));
		icons1.setBounds(696, 23, 41, 48);
		contentPane.add(icons1);
		
		JLabel icons2 = new JLabel("");
		icons2.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icons/flower.png")));
		icons2.setHorizontalAlignment(SwingConstants.CENTER);
		icons2.setBounds(908, 23, 46, 48);
		contentPane.add(icons2);
		
		JLabel lblNewLabel = new JLabel("Flower Shop");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(747, 35, 159, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Seja bem-vindo");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(706, 95, 248, 30);
		contentPane.add(lblNewLabel_1);
		
		textUser = new JTextField();
		textUser.setBounds(782, 469, 172, 26);
		contentPane.add(textUser);
		textUser.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		textUser.setEditable(false);
		textUser.setColumns(10);
		
		textData = new JTextField();
		textData.setBounds(778, 514, 176, 26);
		contentPane.add(textData);
		textData.setHorizontalAlignment(SwingConstants.CENTER);
		textData.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		textData.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
		        Date data = new Date();
		        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
		        textData.setText(formatador.format(data));
			}
		});
		textData.setEditable(false);
		textData.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setBounds(696, 467, 82, 31);
		contentPane.add(lblUsuario);
		lblUsuario.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setForeground(new Color(255, 255, 255));
		lblData.setBounds(696, 509, 72, 36);
		contentPane.add(lblData);
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblData.setVerticalAlignment(SwingConstants.CENTER);
		
		JLabel lblfrases1 = new JLabel("As flores mais belas s\u00E3o aquelas");
		lblfrases1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		lblfrases1.setForeground(new Color(255, 255, 255));
		lblfrases1.setBounds(696, 148, 258, 30);
		contentPane.add(lblfrases1);
		
		JLabel lblfrases2 = new JLabel("para as quais dedicamos mais ");
		lblfrases2.setForeground(Color.WHITE);
		lblfrases2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		lblfrases2.setBounds(696, 189, 258, 30);
		contentPane.add(lblfrases2);
		
		JLabel lblfrases3 = new JLabel(" tempo.");
		lblfrases3.setHorizontalAlignment(SwingConstants.CENTER);
		lblfrases3.setForeground(new Color(255, 255, 255));
		lblfrases3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblfrases3.setBounds(753, 230, 153, 30);
		contentPane.add(lblfrases3);
		
		JLabel lblfundo = new JLabel("");
		lblfundo.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icons/fundo2.jpg")));
		lblfundo.setBounds(683, 0, 302, 556);
		contentPane.add(lblfundo);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
