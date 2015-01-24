package mvc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import bees.Point;

public class View {

	private JFrame frame;
	private JTextField txtFOd;
	private JTextField txtFDo;
	private Controller controller;
	private JTextField textField;


	/**
	 * Create the application window.
	 */
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDziedzina = new JLabel("Dziedzina");
		lblDziedzina.setBounds(10, 11, 86, 14);
		frame.getContentPane().add(lblDziedzina);
		
		txtFOd = new JTextField();
		txtFOd.setBounds(131, 8, 86, 20);
		frame.getContentPane().add(txtFOd);
		txtFOd.setColumns(10);
		
		txtFDo = new JTextField();
		txtFDo.setBounds(254, 8, 86, 20);
		frame.getContentPane().add(txtFDo);
		txtFDo.setColumns(10);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Rastrigin", "Michalewicz"}));
		comboBox.setBounds(131, 39, 209, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblIloIteracji = new JLabel("Ilo\u015B\u0107 iteracji");
		lblIloIteracji.setBounds(10, 78, 72, 14);
		frame.getContentPane().add(lblIloIteracji);
		
		textField = new JTextField();
		textField.setBounds(131, 75, 209, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnUruchom = new JButton("Uruchom");
		btnUruchom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runModel(Double.parseDouble(txtFOd.getText()), Double.parseDouble(txtFDo.getText()), comboBox.getSelectedItem().toString(), Integer.parseInt(textField.getText()));
			}
		});
		btnUruchom.setBounds(131, 130, 89, 23);
		frame.getContentPane().add(btnUruchom);
		
		JLabel lblFunkcja = new JLabel("Funkcja");
		lblFunkcja.setBounds(10, 36, 46, 14);
		frame.getContentPane().add(lblFunkcja);
		
		
		
		
		
		
		
		// zawsze musi byæ na koñcu
		frame.setVisible(true);

	}
	public void setController(Controller controller){
		this.controller=controller;
	}
	public void showResult(ArrayList<Point> result){
	new GraphPanel(result, Integer.parseInt(textField.getText())).createAndShowGui();
	}
}
