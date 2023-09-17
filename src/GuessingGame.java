import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JButton btnPlayAgain;
	private JLabel lblOutput;
	private int theNumber;
	private String message;
	private int numberOfTries;    //объ€вили переменные
	public void checkGuess() {
		String guessText= txtGuess.getText();   //получили текст от юзера
						try {
					int guess= Integer.parseInt(guessText);  //перевели текст в цифру
			numberOfTries= numberOfTries+1;
				if (guess< theNumber)   //сравнили
					message= guess + " is too low. Try again.";
				else if (guess> theNumber) 
					message= guess + " is too high. Try again.";
				else {
					message= guess + " is correct. You win after "+ numberOfTries + " tries!";
					btnPlayAgain.setVisible(true);
							 }
				} catch (Exception e) {
			message = "Enter a whole number between 1 and 100.";
		}
		 finally {
					lblOutput.setText(message);  //написали сообщение в зависимости от ввода
					txtGuess.requestFocus();  	
					txtGuess.selectAll();
						}
	}
	public void newGame() {
		theNumber= (int)(Math.random()*100+1);	//рандомим число
		numberOfTries=0; //обнул€ем попытки
		btnPlayAgain.setVisible(false);
		lblOutput.setText("Enter the number and click Guess!");
			}
	public GuessingGame() {
		getContentPane().setPreferredSize(new Dimension(500, 350)); //создаЄм окно
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("HiLo Guessing Game!"); //шапка
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HiLo Guessing Game");  
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(171, 11, 186, 18);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Guess a number between 1 and 100:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(156, 39, 215, 44);
		getContentPane().add(lblNewLabel_1);
		
		txtGuess = new JTextField();
		txtGuess.setBounds(382, 50, 73, 18);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			checkGuess();
			}
		});
		JButton btnNewButton = new JButton("Guess!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnNewButton.setBounds(227, 122, 73, 23);
		getContentPane().add(btnNewButton);
		
		lblOutput = new JLabel("Enter the number and click Guess!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblOutput.setBounds(149, 184, 229, 44);
		getContentPane().add(lblOutput);
		
		btnPlayAgain = new JButton("Play again!");
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newGame();
										}
		});
		btnPlayAgain.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnPlayAgain.setBounds(193, 215, 141, 33);
		getContentPane().add(btnPlayAgain);
		btnPlayAgain.setVisible(false);
	}

	public static void main(String[] args) {
		GuessingGame theGame= new GuessingGame ();
		theGame.newGame();
		theGame.setSize(new Dimension(555,400));
		theGame.setVisible(true);
		
		}
}
