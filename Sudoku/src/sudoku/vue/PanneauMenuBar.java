package sudoku.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import sudoku.controleur.ActionButtonNouveau;
import sudoku.controleur.ActionButtonResolution;


/**
 * 
 * Creation d'un contenu ayant une barre de menus en haut de la fenetre.
 * 
 * @see ActionButtonNouveau
 * @see ActionButtonResolution
 * 
 * @version 1.0
 */
public class PanneauMenuBar {
	
	/**
	 * La barre de menus.
	 * 
	 * @see PanneauMenuBar#getMenuBar()
	 */
	private JMenuBar menuBar = new JMenuBar();
	/**
	 * La fenetre pop-up.
	 */
	private JOptionPane popupInfo = new JOptionPane();
	
	
	
	/**
	 * Constructeur PanneauMenuBar.
	 * Initialise la barre de menus.
	 */
	public PanneauMenuBar(){
		this.initMenuBar();
	}
	
	
	/**
	 * Creation de menus et de leurs items associés à une action.
	 */
	private void initMenuBar(){
		JMenu menuSudoku = new JMenu("Sudoku");
		JMenuItem itemNouveau = new JMenuItem("Nouveau");		
		itemNouveau.addActionListener(new ActionButtonNouveau());
		menuSudoku.add(itemNouveau);
		JMenuItem itemResolution = new JMenuItem("Résolution");
		itemResolution.addActionListener(new ActionButtonResolution());
		menuSudoku.add(itemResolution);
		menuSudoku.addSeparator();
		JMenuItem itemQuitter = new JMenuItem("Quitter");
		itemQuitter.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event) {
			        System.exit(0);
			      }        
			    }
		);
		menuSudoku.add(itemQuitter);
		
		
		JMenu menuAide = new JMenu("Aide");
		JMenuItem itemProjet = new JMenuItem("Projet");		
		itemProjet.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event) {
		    	  popupInfo.showMessageDialog(null, "Info Projet - Résolution d'une grille de Sudoku ", "Projet", JOptionPane.INFORMATION_MESSAGE);
			      }        
			    }
		);
		menuAide.add(itemProjet);		
		JMenuItem itemAPropos = new JMenuItem("À propos");
		itemAPropos.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event) {
		    	  popupInfo.showMessageDialog(null, "À Propos Projet", "À Propos", JOptionPane.INFORMATION_MESSAGE);
			      }        
			    }
		);
		menuAide.add(itemAPropos);
		
		
		menuBar.add(menuSudoku);
		menuBar.add(menuAide);
	}
	
	
	/**
	 * Renvoie la barre de menus.
	 * 
	 * @return La barre de menus.
	 * 
	 * @see menuBar
	 */
	public JMenuBar getMenuBar(){
		return menuBar;
	}
}
