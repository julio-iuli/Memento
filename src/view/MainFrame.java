package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.*;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnSalvaEstado, btnEstadoAnterior;
	Texto texto;
	JTextArea textArea;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(67, 27, 329, 70);
		textArea.addKeyListener(new KeyAdapter(){
			public void KeyPressed(KeyEvent e) {
				  if(e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
					  try {
							Texto.getInstancia().escreverTexto(textArea.getText());
							JOptionPane.showMessageDialog(null, "estado salvo");
							textField.setText("");
							
						} catch(Exception er) {
							er.printStackTrace();;
						}
				  }
			}
		});
		contentPane.add(textArea);
		
		
		btnEstadoAnterior = new JButton("estado anterior");
		btnEstadoAnterior.setBounds(67, 138, 146, 25);
		btnEstadoAnterior.addActionListener(this);
		contentPane.add(btnEstadoAnterior);
		
		btnSalvaEstado = new JButton("salva estado");
		btnSalvaEstado.setBounds(67, 101, 137, 25);
		btnSalvaEstado.addActionListener(this);
		contentPane.add(btnSalvaEstado);
		
		JLabel lblHoraDoEstado = new JLabel("hora do estado");
		lblHoraDoEstado.setBounds(222, 109, 122, 15);
		contentPane.add(lblHoraDoEstado);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(282, 125, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent ev) {

		if (ev.getSource() == btnSalvaEstado) {
			
			try {
				Texto.getInstancia().escreverTexto(textArea.getText());
				JOptionPane.showMessageDialog(null, "estado salvo");
				textField.setText("");
				
			} catch(Exception er) {
				er.printStackTrace();;
			}
		}
		
		if (ev.getSource() == btnEstadoAnterior) {
			texto = Texto.getInstancia();
			texto.escritaAnterior();
			textArea.setText(texto.getTexto());
			textField.setText(texto.getHora());
		}
	}
}
