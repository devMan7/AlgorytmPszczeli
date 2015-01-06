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

public class View {

	private JFrame frame;
	private JTextField txtFOd;
	private JTextField txtFDo;
	private Controller controller;


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
		
		JButton btnUruchom = new JButton("Uruchom");
		btnUruchom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runModel(txtFOd.getText(), txtFDo.getText());
			}
		});
		btnUruchom.setBounds(128, 58, 89, 23);
		frame.getContentPane().add(btnUruchom);
		
		
		
		// zawsze musi byæ na koñcu
		frame.setVisible(true);

	}
	public void setController(Controller controller){
		this.controller=controller;
	}
	public void showResult(ArrayList<String> result){
		String tempResult="";
		for(String r : result){
			System.out.println(r);
		}
		//JOptionPane.showMessageDialog(null, tempResult);
	}
}
