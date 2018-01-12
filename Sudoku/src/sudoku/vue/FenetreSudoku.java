package sudoku.vue;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;


/**
 * 
 * Creation d'une fenetre ayant trois contenus : la grille, les principaux boutons et une barre de menus.
 * 
 * @see PanneauInterface
 * @see PanneauBarreOutils
 * @see PanneauMenuBar
 * 
 * @version 1.0
 */
public class FenetreSudoku extends JFrame {
	
	/**
	 * La fenetre de l'interface graphique.
	 * 
	 * @see FenetreSudoku#getInstance()
	 */
	private static FenetreSudoku instance = new FenetreSudoku();
	/**
	 * Contient la grille de Sudoku.
	 * 
	 * @see PanneauInterface
	 * @see FenetreSudoku#getPanneauInterface()
	 */
	private PanneauInterface panneauInterface = new PanneauInterface();
	/**
	 * Contient les principaux boutons.
	 * 
	 * @see PanneauBarreOutils
	 * @see FenetreSudoku#getPanneauBarreOutils()
	 */
	private PanneauBarreOutils panneauBarreOutils = new PanneauBarreOutils();
	/**
	 * Contient une barre de manus.
	 * 
	 * @see PanneauMenuBar
	 * @see FenetreSudoku#getPanneauMenuBar()
	 */
	private PanneauMenuBar panneauMenuBar = new PanneauMenuBar();
	
	
	
	/**
	 * Concstructeur FenetreSudoku.
	 * Creation d'une fenetre placee au centre de l'ecran et initialise les trois panneaux : panneauInterface, panneauBarreOutils et panneauMenuBar
	 */
	private FenetreSudoku() {
		this.setTitle("Sudoku");
		
		this.getContentPane().add(this.getPanneauInterface(), BorderLayout.CENTER);
		this.getContentPane().add(this.getPanneauBarreOutils(), BorderLayout.SOUTH);
		this.setJMenuBar(this.getPanneauMenuBar().getMenuBar());
		
		//Position du centre de la fenetre au centre de l'ecran
		int hScreen = Math.round((float) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		int lScreen = Math.round((float) Toolkit.getDefaultToolkit().getScreenSize().getWidth());
		this.setLocation((lScreen/2)-(PanneauInterface.LARGEUR_PAR_DEFAUT/2),
				(hScreen/2)-((PanneauInterface.HAUTEUR_PAR_DEFAUT+PanneauBarreOutils.HAUTEUR_PAR_DEFAUT)/2));
		
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.pack();
	}
	
	
		
	/**
	 * Retourne l'interface graphique.
	 * 
	 * @return L'interface graphique.
	 * 
	 * @see instance
	 */
	public static FenetreSudoku getInstance(){
		return instance;
	}
	/**
	 * Retourne le panneau de la grille de Sudoku.
	 * 
	 * @return Le panneau de la grille de Sudoku.
	 * 
	 * @see panneauInterface
	 */
	public PanneauInterface getPanneauInterface(){
		return panneauInterface;
	}
	/**
	 * Retourne le panneau des principeaux boutons.
	 * 
	 * @return Le panneau des principeaux boutons.
	 * 
	 * @see panneauBarreOutils
	 */
	public PanneauBarreOutils getPanneauBarreOutils(){
		return panneauBarreOutils;
	}
	/**
	 * Retourne le panneau de la barre de menus.
	 * 
	 * @return Le panneau de la barre de menus.
	 * 
	 * @see panneauMenuBar
	 */
	public PanneauMenuBar getPanneauMenuBar(){
		return panneauMenuBar;
	}
	
}
