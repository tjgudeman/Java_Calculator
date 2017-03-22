import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class CalcUI extends JFrame {
	// private Calc calculator;
	private JPanel calcHolder;
	private JButton one;
	private JButton two;
	private JButton three;
	private JButton four;
	private JButton five;
	private JButton six;
	private JButton seven;
	private JButton eight;
	private JButton nine;
	private JButton zero;

	private JButton add;
	private JButton subtract;
	private JButton divide;
	private JButton multiply;
	private JButton equals;
	private JButton decimal;
	private JButton clear;
	private JButton clearAll;
	private JMenuBar menuBar;
	private JMenuItem quitItem;
	private JMenuItem clearItem;
	private JMenuItem clearAllItem;

	private boolean aDone;
	private boolean bDone;
	private boolean addition;
	private boolean subtraction;
	private boolean multiplicaiton;
	private boolean division;

	private String aHolder;
	private String bHolder;
	private String answerHolder;
	private String answerString;
	private double aValue;
	private double bValue;
	private double answer;
	private JTextField calcDisplay;
	private JTextField holder;
	private JTextField secondValue;
	private JTextField answerPane;
	private JTextField sign;

	private JFrame calcMainDisplay;
	private JPanel north;

	private JMenu fileMenu;
	private JMenuItem quitDisplay;
	private JMenuItem addItem;
	private JMenuItem subtractItem;
	private JMenuItem multiplyItem;
	private JMenuItem divideItem;
	private JMenuItem evaluateItem;

	private calcHandler ch;

	public CalcUI() {
		calcMainDisplay = new JFrame();
		ch = new calcHandler();

		// Set Default to Empty so it is not Null
		aHolder = "";
		bHolder = "";
		answerHolder = "";

		// *** Create North Panel *****
		north = new JPanel();
		north.setLayout(new BorderLayout());

		calcDisplay = new JTextField(10);
		calcDisplay.addKeyListener(ch);
		calcDisplay.setEditable(false);

		secondValue = new JTextField(10);
		secondValue.setEditable(false);

		sign = new JTextField("Operator");
		sign.setEditable(false);
		Font myFont = new Font("Italics", Font.ITALIC | Font.ITALIC, 12);
		sign.setFont(myFont);

		answerPane = new JTextField(30);
		answerPane.setEditable(false);

		north.add(calcDisplay, BorderLayout.WEST);
		north.add(sign, BorderLayout.CENTER);
		north.add(secondValue, BorderLayout.EAST);
		north.add(answerPane, BorderLayout.SOUTH);

		// **** Creating Buttons and calcHolder****
		calcHolder = new JPanel();

		one = new JButton("1");
		one.addActionListener(new oneHandler());
		one.addKeyListener(ch);
		one.setFocusable(false);

		two = new JButton("2");
		two.addActionListener(new twoHandler());
		two.addKeyListener(ch);
		two.setFocusable(false);
		three = new JButton("3");
		three.addActionListener(new threeHandler());
		three.addKeyListener(ch);
		three.setFocusable(false);
		four = new JButton("4");
		four.addActionListener(new fourHandler());
		four.addKeyListener(ch);
		four.setFocusable(false);
		five = new JButton("5");
		five.addActionListener(new fiveHandler());
		five.addKeyListener(ch);
		five.setFocusable(false);
		six = new JButton("6");
		six.addActionListener(new sixHandler());
		six.addKeyListener(ch);
		six.setFocusable(false);
		seven = new JButton("7");
		seven.addActionListener(new sevenHandler());
		seven.addKeyListener(ch);
		seven.setFocusable(false);
		eight = new JButton("8");
		eight.addActionListener(new eightHandler());
		eight.addKeyListener(ch);
		eight.setFocusable(false);
		nine = new JButton("9");
		nine.addActionListener(new nineHandler());
		nine.addKeyListener(ch);
		nine.setFocusable(false);
		zero = new JButton("0");
		zero.addActionListener(new zeroHandler());
		zero.addKeyListener(ch);
		zero.setFocusable(false);

		// *** Arithmetic Buttons / Other Functional Buttons***
		add = new JButton("+ (A)");
		add.addActionListener(new addHandler());
		add.addKeyListener(ch);
		add.setFocusable(false);
		subtract = new JButton("- (S)");
		subtract.addActionListener(new subtractHandler());
		subtract.addKeyListener(ch);
		subtract.setFocusable(false);
		multiply = new JButton("* (M)");
		multiply.addActionListener(new multiplyHandler());
		multiply.setFocusable(false);
		multiply.addKeyListener(ch);
		divide = new JButton("/ (D)");
		divide.addActionListener(new divideHandler());
		divide.addKeyListener(ch);
		divide.setFocusable(false);
		equals = new JButton("= (Etr)");
		equals.addActionListener(new equalsHandler());
		equals.addKeyListener(ch);
		equals.setFocusable(false);
		clearAll = new JButton("CA (C)");
		clearAll.addActionListener(new clearAllHandler());
		clearAll.addKeyListener(ch);
		clearAll.setFocusable(false);
		clear = new JButton("C (B)");
		clear.addActionListener(new clearHandler());
		clear.addKeyListener(ch);
		clear.setFocusable(false);
		decimal = new JButton(".");
		decimal.addActionListener(new decimalHandler());
		decimal.addKeyListener(ch);
		decimal.setFocusable(false);

		// ***Grid Bad Layout for Center****
		calcHolder.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.gridx = 0;
		c.gridy = 1;
		calcHolder.add(clearAll, c);

		c.gridx = 1;
		c.gridy = 1;
		calcHolder.add(clear, c);

		c.gridx = 2;
		c.gridy = 1;
		calcHolder.add(divide, c);

		c.gridx = 3;
		c.gridy = 1;
		calcHolder.add(multiply, c);

		c.gridx = 0;
		c.gridy = 3;
		calcHolder.add(seven, c);

		c.gridx = 1;
		c.gridy = 3;
		calcHolder.add(eight, c);

		c.gridx = 2;
		c.gridy = 3;
		calcHolder.add(nine, c);

		c.gridx = 3;
		c.gridy = 3;
		calcHolder.add(subtract, c);

		c.gridx = 0;
		c.gridy = 4;
		calcHolder.add(four, c);

		c.gridx = 1;
		c.gridy = 4;
		calcHolder.add(five, c);

		c.gridx = 2;
		c.gridy = 4;
		calcHolder.add(six, c);

		c.gridx = 3;
		c.gridy = 4;
		calcHolder.add(add, c);

		c.gridx = 0;
		c.gridy = 5;
		calcHolder.add(one, c);

		c.gridx = 1;
		c.gridy = 5;
		calcHolder.add(two, c);

		c.gridx = 2;
		c.gridy = 5;
		calcHolder.add(three, c);

		c.gridheight = 0;
		c.gridwidth = 0;
		c.gridx = 1;
		c.gridy = 6;
		calcHolder.add(decimal, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 2;
		calcHolder.add(zero, c);

		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 3;
		c.gridy = 5;
		c.gridheight = 2;
		calcHolder.add(equals, c);

		// *** Menu***
		menuBar = new JMenuBar(); // add Menu bar
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');
		quitDisplay = new JMenuItem("Quit Program");
		quitDisplay.addActionListener(new QuitHandler());
		quitDisplay.setMnemonic('Q');
		addItem = new JMenu("+");

		fileMenu.add(addItem);
		fileMenu.add(quitDisplay);
		menuBar.add(fileMenu);
		// ***Add Contents to Main Pane****
		JPanel content = new JPanel();
		content.add(north, BorderLayout.NORTH);
		content.add(calcHolder, BorderLayout.CENTER);

		// ***** Defaults for Window****
		calcMainDisplay.setContentPane(content);
		calcMainDisplay.pack();
		calcMainDisplay.setVisible(true);
		calcMainDisplay.setSize(375, 250);
	}

	// *** Logic behind each number***
	public void one() {
		if (aDone == false) {
			if (aHolder.length() <= 10) {
				aHolder = aHolder + "1";
				calcDisplay.setText(aHolder);
			}
		} else {
			if (bHolder.length() <= 10) {
				bHolder = bHolder + "1";
				secondValue.setText(bHolder);
			}
		}
	}

	public void two() {
		if (aDone == false) {
			if (aHolder.length() <= 10) {
				aHolder = aHolder + "2";
				calcDisplay.setText(aHolder);
			}
		} else {
			if (bHolder.length() <= 10) {
				bHolder = bHolder + "2";
				secondValue.setText(bHolder);
			}
		}
	}

	public void three() {
		if (aDone == false) {
			if (aHolder.length() <= 10) {
				aHolder = aHolder + "3";
				calcDisplay.setText(aHolder);
			}
		} else {
			if (bHolder.length() <= 10) {
				bHolder = bHolder + "3";
				secondValue.setText(bHolder);
			}
		}
	}

	public void four() {
		if (aDone == false) {
			if (aHolder.length() <= 10) {
				aHolder = aHolder + "4";
				calcDisplay.setText(aHolder);
			}
		}

		else {
			if (bHolder.length() <= 10) {
				bHolder = bHolder + "4";
				secondValue.setText(bHolder);
			}
		}
	}

	public void five() {
		if (aDone == false) {
			if (aHolder.length() <= 10) {
				aHolder = aHolder + "5";
				calcDisplay.setText(aHolder);
			}
		}

		else {
			if (bHolder.length() <= 10) {
				bHolder = bHolder + "5";
				secondValue.setText(bHolder);
			}
		}
	}

	public void six() {
		if (aDone == false) {
			if (aHolder.length() <= 10) {
				aHolder = aHolder + "6";
				calcDisplay.setText(aHolder);
			}
		}

		else {
			if (bHolder.length() <= 10) {
				bHolder = bHolder + "6";
				secondValue.setText(bHolder);
			}
		}
	}

	public void seven() {
		if (aDone == false) {
			if (aHolder.length() <= 10) {
				aHolder = aHolder + "7";
				calcDisplay.setText(aHolder);
			}
		} else {
			if (bHolder.length() <= 10) {
				bHolder = bHolder + "7";
				secondValue.setText(bHolder);
			}
		}
	}

	public void eight() {
		if (aDone == false) {
			if (aHolder.length() <= 10) {
				aHolder = aHolder + "8";
				calcDisplay.setText(aHolder);
			}
		} else {
			if (bHolder.length() <= 10) {
				bHolder = bHolder + "8";
				secondValue.setText(bHolder);
			}
		}
	}

	public void nine() {
		if (aDone == false) {
			if (aHolder.length() <= 10) {
				aHolder = aHolder + "9";
				calcDisplay.setText(aHolder);
			}
		} else {
			if (bHolder.length() <= 10) {
				bHolder = bHolder + "9";
				secondValue.setText(bHolder);
			}
		}

	}

	public void zero() {
		if (aDone == false) {
			if (aHolder.length() <= 10) {
				aHolder = aHolder + "0";
				calcDisplay.setText(aHolder);
			}
		} else {
			if (bHolder.length() <= 10) {
				bHolder = bHolder + "0";
				secondValue.setText(bHolder);
			}
		}
	}

	// *** Logic behind operator buttons***
	public void add() {
		if (aHolder == "") {
			aValue = 0;
		} else {
			aValue = Double.parseDouble(aHolder);
		}
		aDone = true;
		addition = true;
		sign.setText("    +");
	}

	public void subtract() {
		if (aHolder == "")
			aValue = 0;
		else
			aValue = Double.parseDouble(aHolder);
		aDone = true;
		subtraction = true;
		sign.setText("-");
	}

	public void multiply() {
		if (aHolder == "")
			aValue = 0;
		else
			aValue = Double.parseDouble(aHolder);
		aDone = true;
		multiplicaiton = true;
		sign.setText("     *");
	}

	public void divide() {
		if (aHolder == "")
			aValue = 0;
		else
			aValue = Double.parseDouble(aHolder);
		aDone = true;
		division = true;
		sign.setText("     /");
	}

	public void equalsAction() {
		if (aDone == false)
			answerPane.setText(aHolder);
		else if (addition == true) {
			answer = Double.parseDouble(aHolder) + Double.parseDouble(bHolder);
			answerString = String.valueOf(answer);
			answerPane.setText(answerString);
		}
		if (subtraction == true) {
			answer = Double.parseDouble(aHolder) - Double.parseDouble(bHolder);
			answerString = String.valueOf(answer);
			answerPane.setText(answerString);
		}
		if (multiplicaiton == true) {
			answer = Double.parseDouble(aHolder) * Double.parseDouble(bHolder);
			answerString = String.valueOf(answer);
			answerPane.setText(answerString);
		}
		if (division == true) {
			answer = Double.parseDouble(aHolder) / Double.parseDouble(bHolder);
			answerString = String.valueOf(answer);
			answerPane.setText(answerString);
		}
	}

	public void clearAll() {
		// Reset values and Frames
		aValue = 0;
		bValue = 0;
		answer = 0;
		answerString = "";
		aHolder = "";
		bHolder = "";
		answerHolder = "";
		calcDisplay.setText("");
		secondValue.setText("");
		answerPane.setText("");
		sign.setText("");

		// Reset Booleans
		aDone = false;
		bDone = false;
		addition = false;
		subtraction = false;
		division = false;
		multiplicaiton = false;
	}

	public void clear() {
		if (aDone == false) {
			if (aHolder.length() <= 10 && aHolder.length() >= 2) {
				aHolder = aHolder.substring(0, aHolder.length() - 1);
				aValue = Double.parseDouble(aHolder);
				calcDisplay.setText(aHolder);
			}
			if (aHolder.length() == 1) {
				aValue = 0;
				calcDisplay.setText("0");
			}
		} else {
			if (bHolder.length() <= 10) {
				bHolder = bHolder.substring(0, bHolder.length() - 1);
				bValue = Double.parseDouble(bHolder);
				secondValue.setText(bHolder);
			}
		}
	}

	public void decimal() {
		if (aDone == false) {
			if (aHolder == "") {
				aHolder = "0" + ".";
				aValue = Double.parseDouble(aHolder);
			} else {
				aHolder = aHolder + ".";
				aValue = Double.parseDouble(aHolder);
				calcDisplay.setText(aHolder);
			}
		} else if (bHolder == "") {
			bHolder = "0" + ".";
			bValue = Double.parseDouble(bHolder);
		} else {
			bHolder = bHolder + ".";
			bValue = Double.parseDouble(bHolder);
			secondValue.setText(bHolder);
		}
	}

	public void quit() {
		System.exit(0);
	}

	// ****Action and Key Listeners***
	private class oneHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			one();
		}
	}

	private class twoHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			two();
		}
	}

	private class threeHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			three();
		}
	}

	private class fourHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			four();
		}
	}

	private class fiveHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			five();
		}
	}

	private class sixHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			six();
		}
	}

	private class sevenHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			seven();
		}
	}

	private class eightHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			eight();
		}
	}

	private class nineHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			nine();
		}
	}

	private class zeroHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			zero();
		}
	}

	// *** Actions for other buttons***
	private class addHandler implements ActionListener // Addition
	{
		public void actionPerformed(ActionEvent e) {
			add();
		}
	}

	private class subtractHandler implements ActionListener // Subtract
	{
		public void actionPerformed(ActionEvent e) {
			subtract();
		}
	}

	private class multiplyHandler implements ActionListener // Multiply
	{
		public void actionPerformed(ActionEvent e) {
			multiply();
		}
	}

	private class divideHandler implements ActionListener // Divide
	{
		public void actionPerformed(ActionEvent e) {
			divide();
		}
	}

	private class equalsHandler implements ActionListener // Equals
	{
		public void actionPerformed(ActionEvent e) {
			equalsAction();
		}
	}

	private class clearAllHandler implements ActionListener // Clear all
	{
		public void actionPerformed(ActionEvent e) {
			clearAll();
		}
	}

	private class clearHandler implements ActionListener // Clear
	{
		public void actionPerformed(ActionEvent e) {
			clear();
		}
	}

	private class decimalHandler implements ActionListener // Decimal
	{

		public void actionPerformed(ActionEvent e) {
			decimal();
		}

	}

	private class QuitHandler implements ActionListener // Quit
	{
		public void actionPerformed(ActionEvent e) {
			quit();
		}
	}

	class calcHandler implements KeyListener // Listens to key, we need to
												// fulfill KeyListener
												// "contract"
	{

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_1) {
				one();
			}
			if (e.getKeyCode() == KeyEvent.VK_2) {
				two();
			}
			if (e.getKeyCode() == KeyEvent.VK_3) {
				three();
			}
			if (e.getKeyCode() == KeyEvent.VK_4) {
				four();
			}
			if (e.getKeyCode() == KeyEvent.VK_5) {
				five();
			}
			if (e.getKeyCode() == KeyEvent.VK_6) {
				six();
			}
			if (e.getKeyCode() == KeyEvent.VK_7) {
				seven();
			}
			if (e.getKeyCode() == KeyEvent.VK_8) {
				eight();
			}
			if (e.getKeyCode() == KeyEvent.VK_9) {
				nine();
			}
			if (e.getKeyCode() == KeyEvent.VK_0) {
				zero();
			}
			if (e.getKeyCode() == KeyEvent.VK_A) {
				add();
			}
			if (e.getKeyCode() == KeyEvent.VK_S) {
				subtract();
			}
			if (e.getKeyCode() == KeyEvent.VK_D) {
				divide();
			}
			if (e.getKeyCode() == KeyEvent.VK_M) {
				multiply();
			}
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				equalsAction();
			}
			if (e.getKeyCode() == KeyEvent.VK_C) {
				clearAll();
			}
			if (e.getKeyCode() == KeyEvent.VK_B) {
				clear();
			}
			if (e.getKeyCode() == KeyEvent.VK_PERIOD) {
				decimal();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		@Override
		public void keyTyped(KeyEvent e) {
		}
	}
}
