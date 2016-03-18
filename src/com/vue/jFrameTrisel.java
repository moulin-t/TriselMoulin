package com.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jFrameTrisel extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnMenuFichier;
	private JMenu mnMenuLevee;
	private JMenu mnMenuFacture;
	private JMenuItem mntmMenuItemQuitter;
	private JMenuItem mntmMenuItemLevee;
	private JMenuItem mntmMenuItemFacture;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jFrameTrisel frame = new jFrameTrisel();
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
	public jFrameTrisel() {
		setTitle("TRISEL - Gestion des poubelles");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnMenuFichier());
			menuBar.add(getMnMenuLevee());
			menuBar.add(getMnMenuFacture());
		}
		return menuBar;
	}
	private JMenu getMnMenuFichier() {
		if (mnMenuFichier == null) {
			mnMenuFichier = new JMenu("Fichier");
			mnMenuFichier.add(getMntmMenuItemQuitter());
		}
		return mnMenuFichier;
	}
	private JMenu getMnMenuLevee() {
		if (mnMenuLevee == null) {
			mnMenuLevee = new JMenu("Levee");
			mnMenuLevee.add(getMntmMenuItemLevee());
		}
		return mnMenuLevee;
	}
	private JMenu getMnMenuFacture() {
		if (mnMenuFacture == null) {
			mnMenuFacture = new JMenu("Facture");
			mnMenuFacture.add(getMntmMenuItemFacture());
		}
		return mnMenuFacture;
	}
	private JMenuItem getMntmMenuItemQuitter() {
		if (mntmMenuItemQuitter == null) {
			mntmMenuItemQuitter = new JMenuItem("Quitter");
			mntmMenuItemQuitter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
		}
		return mntmMenuItemQuitter;
	}
	private JMenuItem getMntmMenuItemLevee() {
		if (mntmMenuItemLevee == null) {
			mntmMenuItemLevee = new JMenuItem("Ajouter levée");
			mntmMenuItemLevee.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					insertionLevee();
				}
			});
		}
		return mntmMenuItemLevee;
	}
	private JMenuItem getMntmMenuItemFacture() {
		if (mntmMenuItemFacture == null) {
			mntmMenuItemFacture = new JMenuItem("Editer facture");
		}
		return mntmMenuItemFacture;
	}
	private void insertionLevee() { 
		// on affecte le panel de la fenêtre 
		// avec une instance de PanelLevee 
		this.setContentPane(new panelLevee());
		// mets à jour le formulaire 
		this.revalidate();
	}
}
