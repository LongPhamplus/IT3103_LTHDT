package hust.soict.dsai.swing;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class NumberGrid extends JFrame{
	private JButton[] numberBtns = new JButton[10];
	private JButton deleteBtn, resetBtn;
	private JTextField tfDisplay;
	
	public NumberGrid() {
		
		tfDisplay = new JTextField();
		tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		tfDisplay.setPreferredSize(new Dimension(180, 40));
		tfDisplay.setEditable(false);
		
		JPanel panelBtn = new JPanel(new GridLayout(4, 3));
		addBtns(panelBtn);
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(tfDisplay, BorderLayout.NORTH);
		cp.add(panelBtn, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("NumberGrid");
		setSize(200, 200);
		setVisible(true);
	}
	
	void addBtns(JPanel panelBtn) {
		
		ButtonListener btnListener = new ButtonListener();
		
		for(int i = 1; i <= 9; i++) {
			numberBtns[i] = new JButton("" + i);
			panelBtn.add(numberBtns[i]);
			numberBtns[i].addActionListener(btnListener);
		}
		
		deleteBtn = new JButton("DEL");
		panelBtn.add(deleteBtn);
		deleteBtn.addActionListener(btnListener);
		numberBtns [0] = new JButton("0");
		panelBtn.add(numberBtns[0]);
		numberBtns [0].addActionListener(btnListener);
		resetBtn = new JButton("C");
		panelBtn.add(resetBtn);
		resetBtn.addActionListener(btnListener);
	}
	
	public class ButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed (ActionEvent e) {
			
			String button = e.getActionCommand();
			
			if (button.charAt(0) >= '0' && button.charAt(0) <= '9') {
				tfDisplay.setText(tfDisplay.getText() + button);
			} else if (button.equals("DEL")) {
				String stringDis = tfDisplay.getText();
				tfDisplay.setText(stringDis.substring(0, stringDis.length() - 1));
			} else if (button.equals("C")) {
				tfDisplay.setText("");
			}
		}
	}
}
