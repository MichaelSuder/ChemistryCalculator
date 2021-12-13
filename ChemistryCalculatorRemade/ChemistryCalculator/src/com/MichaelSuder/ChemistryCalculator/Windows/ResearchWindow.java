package com.MichaelSuder.ChemistryCalculator.Windows;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.MichaelSuder.ChemistryCalculator.Utils.Finder;

public class ResearchWindow extends JFrame {

	private JPanel contentPane;
	private JTextField atomicSymbolTxtField;
	private JTextField atomicNumberTxtField;
	private Finder finder = new Finder();

	/**
	 * Create the frame.
	 */
	public ResearchWindow() {
		try {
			setIconImage(ImageIO.read(new File("img/vial.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton backBtn = new JButton("Back");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				Window win = SwingUtilities.getWindowAncestor(contentPane);
				win.dispose();
			}
		});
		backBtn.setBounds(10, 11, 110, 38);
		contentPane.add(backBtn);

		atomicSymbolTxtField = new JTextField();
		atomicSymbolTxtField.setToolTipText("Enter an atomic symbol");
		atomicSymbolTxtField.setBounds(180, 55, 228, 38);
		contentPane.add(atomicSymbolTxtField);
		atomicSymbolTxtField.setColumns(10);

		atomicNumberTxtField = new JTextField();
		atomicNumberTxtField.setToolTipText("Enter an atomic number");
		atomicNumberTxtField.setColumns(10);
		atomicNumberTxtField.setBounds(180, 170, 228, 38);
		contentPane.add(atomicNumberTxtField);

		JLabel symbolResultLbl = new JLabel("");
		symbolResultLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		symbolResultLbl.setBounds(180, 101, 471, 26);
		contentPane.add(symbolResultLbl);

		JLabel numResultLbl = new JLabel("");
		numResultLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		numResultLbl.setBounds(180, 219, 471, 26);
		contentPane.add(numResultLbl);

		JButton findAtomicSymbolBtn = new JButton("Find");
		findAtomicSymbolBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				symbolResultLbl.setText(isSymbol(atomicSymbolTxtField.getText()));
			}
		});
		findAtomicSymbolBtn.setBounds(418, 55, 115, 38);
		contentPane.add(findAtomicSymbolBtn);

		JButton findAtomicNumberBtn = new JButton("Find");
		findAtomicNumberBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numResultLbl.setText(isAtomicNumber(atomicNumberTxtField.getText()));

			}
		});
		findAtomicNumberBtn.setBounds(418, 170, 115, 38);
		contentPane.add(findAtomicNumberBtn);

		JLabel symbolInstructLbl = new JLabel("Atomic Symbol or Element Name:");
		symbolInstructLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		symbolInstructLbl.setBounds(180, 21, 209, 28);
		contentPane.add(symbolInstructLbl);

		JLabel numberInstructLbl = new JLabel("Atomic Number:");
		numberInstructLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		numberInstructLbl.setBounds(180, 138, 199, 28);
		contentPane.add(numberInstructLbl);

	}

	// Check input for our text fields
	private String isAtomicNumber(String message) {
		try {
			int number = Integer.parseInt(message);
			return finder.getElementNumber(number);
		} catch (NumberFormatException e) {
			return "Error: " + message + " is not a number, or is not less than 118";
		}
	}

	private String isSymbol(String message) {
		if (finder.isElement(message))
			return (finder.getElementName(message));
		return "Please enter a valid Atomic Symbol";
	}

}
