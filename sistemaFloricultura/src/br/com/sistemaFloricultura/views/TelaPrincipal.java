package br.com.sistemaFloricultura.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.util.Date;
import java.beans.PropertyChangeEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class TelaPrincipal extends JFrame {
	public static JTextField textUsuario;
	private JTextField textData;
	public static JMenu relatorio;
	public static JMenuItem funcionarios;

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
		initComponents();
	}

	private void initComponents() {

		// TODO Auto-generated method stub
		getContentPane().setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/icons/flower.png")));
		setResizable(false);
		setAlwaysOnTop(false);
		setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		setTitle("Flower Shop");
		setBounds(100, 100, 980, 622);

		JDesktopPane desktop = new JDesktopPane();
		desktop.setBackground(new Color(250, 240, 230));
		desktop.setForeground(new Color(240, 230, 140));
		desktop.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel lblNewLabel = new JLabel("Flower Shop");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icons/flower.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icons/flower.png")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_4 = new JLabel("Sejam Bem-Vindos");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_3 = new JLabel("As flores mais belas s\u00E3o aquelas");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));

		JLabel lblNewLabel_5 = new JLabel("para as quais dedicamos mais");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));

		JLabel lblNewLabel_6 = new JLabel("tempo.");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));

		JLabel lblusuario = new JLabel("Usu\u00E1rio:");
		lblusuario.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		lblusuario.setHorizontalAlignment(SwingConstants.CENTER);

		textUsuario = new JTextField();
		textUsuario.setEditable(false);
		textUsuario.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		textUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		textUsuario.setColumns(10);

		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		lblData.setHorizontalAlignment(SwingConstants.CENTER);

		textData = new JTextField();
		textData.setEditable(false);
		textData.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				Date data = new Date();
				DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
				textData.setText(formatador.format(data));
			}
		});
		textData.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		textData.setHorizontalAlignment(SwingConstants.CENTER);
		textData.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addComponent(desktop, GroupLayout.PREFERRED_SIZE, 674, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup().addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblNewLabel_6)
										.addContainerGap())
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
										.createSequentialGroup()
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 145,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
										.addGap(15))
										.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 223,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblNewLabel_3, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(lblNewLabel_5, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
												.addGap(28))))
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblData).addGap(18)
										.addComponent(textData, GroupLayout.PREFERRED_SIZE, 165,
												GroupLayout.PREFERRED_SIZE)
										.addGap(57))))
						.addGroup(groupLayout.createSequentialGroup().addGap(4).addComponent(lblusuario).addGap(10)
								.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(desktop, GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup().addGap(22)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 32,
										Short.MAX_VALUE))
						.addGap(18)
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addGap(40).addComponent(lblNewLabel_3).addGap(18).addComponent(lblNewLabel_5)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(18).addComponent(lblNewLabel_6))
								.addGroup(Alignment.TRAILING,
										groupLayout.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
												.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
														.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblusuario))
												.addGap(29)))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblData)
								.addComponent(textData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(25)));
		getContentPane().setLayout(groupLayout);

		JMenuBar menu = new JMenuBar();
		menu.setBackground(new Color(240, 240, 240));
		menu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		setJMenuBar(menu);

		JMenu cadastro = new JMenu("Cadastro");
		cadastro.setFont(new Font("Times New Roman", Font.BOLD, 20));
		menu.add(cadastro);

		JMenuItem clientes = new JMenuItem("Clientes");
		clientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaClientes cli = new TelaClientes();
				cli.setVisible(true);
				desktop.add(cli);
			}
		});
		clientes.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icons/clients.png")));
		cadastro.add(clientes);

		funcionarios = new JMenuItem("Funcionarios");
		funcionarios.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icons/team20.png")));
		funcionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFuncionarios func = new TelaFuncionarios();
				func.setVisible(true);
				desktop.add(func);
			}
		});
		// funcionarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O,
		// java.awt.event.InputEvent.ALT_MASK));
		cadastro.add(funcionarios);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Produtos");
		cadastro.add(mntmNewMenuItem_2);

		relatorio = new JMenu("Relat\u00F3rio");
		relatorio.setFont(new Font("Times New Roman", Font.BOLD, 20));
		menu.add(relatorio);

		JMenuItem Vendas = new JMenuItem("Vendas");
		relatorio.add(Vendas);

		JMenu ajuda = new JMenu("Ajuda");
		ajuda.setFont(new Font("Times New Roman", Font.BOLD, 20));
		menu.add(ajuda);

		JMenuItem sobre = new JMenuItem("Sobre");
		sobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaSobre tlSobre = new TelaSobre();
				tlSobre.setVisible(true);
				desktop.add(sobre);
			}
		});
		ajuda.add(sobre);

		JMenu sair = new JMenu("Sair");
		sair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clicado();
			}
		});
		sair.setFont(new Font("Times New Roman", Font.BOLD, 20));
		menu.add(sair);

	}

	protected void clicado() {
		// TODO Auto-generated method stub
		int sair = JOptionPane.showConfirmDialog(null, "Você realmente deseja sair do sistema?", "Atenção!",
				JOptionPane.YES_NO_OPTION);
		if (sair == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
