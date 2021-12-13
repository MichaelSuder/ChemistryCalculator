package com.MichaelSuder.ChemistryCalculator.Windows;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.MichaelSuder.ChemistryCalculator.Utils.AtomFinder;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField elementTxtField;
	private JTextField unitTxtField;
	private AtomFinder atomFinder = new AtomFinder();

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		// Toolkit.getDefaultToolkit().getImage("C:\\dev\\ChemistryCalculatorRemade\\ChemistryCalculator\\img\\vial.png"));
		// Went with an alternative to using an absolute path but will leave this here
		// for quick testing or a reference for the future
		try {
			setIconImage(ImageIO.read(new File("img/vial.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setTitle("Chemistry Calculator v2.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Button that will open the research pane window
		// Window should open on a new thread and all the controls for the window should be located in a separate class
		JButton openResearchPane = new JButton("Research Window");
		openResearchPane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ResearchWindow frame = new ResearchWindow();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		openResearchPane.setBounds(32, 35, 149, 39);
		contentPane.add(openResearchPane);

		// Button that will open the stoichiometry window
		JButton openStoichWinBtn = new JButton("Stoichiometry Window");
		openStoichWinBtn.setBounds(32, 85, 149, 39);
		contentPane.add(openStoichWinBtn);

		// Set up a txt field that will take the users input for an element to be
		// converted
		elementTxtField = new JTextField();
		elementTxtField.setToolTipText("Enter Element ex: Na");
		elementTxtField.setBounds(290, 44, 130, 30);
		contentPane.add(elementTxtField);
		elementTxtField.setColumns(10);

		// Set up a txt field that will take the users input for the amount of x element
		// to be converted
		unitTxtField = new JTextField();
		unitTxtField.setToolTipText("");
		unitTxtField.setColumns(10);
		unitTxtField.setBounds(450, 44, 130, 30);
		contentPane.add(unitTxtField);

		ButtonGroup bg = new ButtonGroup();

		JRadioButton gramsToMolesBtn = new JRadioButton("Grams To moles");
		gramsToMolesBtn.setBounds(290, 85, 130, 23);
		contentPane.add(gramsToMolesBtn);
		bg.add(gramsToMolesBtn);

		JRadioButton gramsToAtomsBtn = new JRadioButton("Grams To Atoms");
		gramsToAtomsBtn.setBounds(450, 85, 130, 23);
		contentPane.add(gramsToAtomsBtn);
		bg.add(gramsToAtomsBtn);

		JRadioButton atomsToGramsBtn = new JRadioButton("Atoms To Grams");
		atomsToGramsBtn.setBounds(450, 137, 130, 23);
		contentPane.add(atomsToGramsBtn);
		bg.add(atomsToGramsBtn);

		JRadioButton atomsToMolesBtn = new JRadioButton("Atoms to Moles");
		atomsToMolesBtn.setBounds(290, 137, 130, 23);
		contentPane.add(atomsToMolesBtn);
		bg.add(atomsToMolesBtn);

		JRadioButton molesToAtomsBtn = new JRadioButton("Moles to Atoms");
		molesToAtomsBtn.setBounds(290, 111, 130, 23);
		contentPane.add(molesToAtomsBtn);
		bg.add(molesToAtomsBtn);

		JRadioButton molesToGramsBtn = new JRadioButton("Moles to Grams");
		molesToGramsBtn.setBounds(450, 111, 130, 23);
		contentPane.add(molesToGramsBtn);
		bg.add(molesToGramsBtn);

		JLabel elementInstructLbl = new JLabel("Enter Element Ex: Na");
		elementInstructLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		elementInstructLbl.setBounds(290, 26, 115, 14);
		contentPane.add(elementInstructLbl);

		JLabel unitInstructLbl = new JLabel("Enter Unit Ex: 10.2");
		unitInstructLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		unitInstructLbl.setBounds(450, 26, 115, 14);
		contentPane.add(unitInstructLbl);

		JLabel resultLbl = new JLabel("");
		resultLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		resultLbl.setBounds(290, 221, 290, 30);
		contentPane.add(resultLbl);

		JButton calculateConversionBtn = new JButton("Calculate");
		calculateConversionBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gramsToMolesBtn.isSelected()) {

					resultLbl.setText(Double.toString(atomFinder.gramsMolesAtoms(gramsToMolesBtn.getText(),
							elementTxtField.getText(), Double.parseDouble(unitTxtField.getText()))));
				}
				if (molesToGramsBtn.isSelected()) {
					resultLbl.setText(Double.toString(atomFinder.gramsMolesAtoms(molesToGramsBtn.getText(),
							elementTxtField.getText(), Double.parseDouble(unitTxtField.getText()))));
				}
				if (molesToAtomsBtn.isSelected()) {
					resultLbl.setText(Double.toString(atomFinder.gramsMolesAtoms(molesToAtomsBtn.getText(),
							elementTxtField.getText(), Double.parseDouble(unitTxtField.getText()))));
				}
				if (atomsToMolesBtn.isSelected()) {
					resultLbl.setText(Double.toString(atomFinder.gramsMolesAtoms(atomsToMolesBtn.getText(),
							elementTxtField.getText(), Double.parseDouble(unitTxtField.getText()))));
				}
				if (atomsToGramsBtn.isSelected()) {
					resultLbl.setText(Double.toString(atomFinder.gramsMolesAtoms(atomsToGramsBtn.getText(),
							elementTxtField.getText(), Double.parseDouble(unitTxtField.getText()))));
				}
				if (gramsToAtomsBtn.isSelected()) {
					resultLbl.setText(Double.toString(atomFinder.gramsMolesAtoms(gramsToAtomsBtn.getText(),
							elementTxtField.getText(), Double.parseDouble(unitTxtField.getText()))));
				}

			}
		});
		calculateConversionBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		calculateConversionBtn.setBounds(290, 171, 290, 39);
		contentPane.add(calculateConversionBtn);

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			// Set cross-platform Java L&F (also called "Metal")
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Check compatability of System Look and Feel");
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
