package sudoku.vue;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;
import sudoku.controleur.ActionButtonNouveau;
import sudoku.controleur.ActionButtonResolution;


/**
 * 
 * Creation d'un contenu ayant les principaux boutons. Celui-ci se situe en bas de la fenetre.
 * 
 * @see ActionButtonNouveau
 * @see ActionButtonResolution
 * 
 * @version 1.0
 */
public class PanneauBarreOutils extends JPanel {
	
	/**
	 * La largeur par defaut du panneau.
	 */
	public static final int LARGEUR_PAR_DEFAUT = PanneauInterface.LARGEUR_PAR_DEFAUT;
	/**
	 * La hauteur par defaut du panneau.
	 */
	public static final int HAUTEUR_PAR_DEFAUT = 36;
	/**
	 * La couleur de fond par defaut du panneau.
	 */
	private static final Color COULEUR_FOND_PAR_DEFAUT = Color.ORANGE;
	/**
	 * La dimmension par defaut des bouton dans le panneau.
	 */
	private static final Dimension DIMENSION_BOUTON_PAR_DEFAUT = new Dimension(100,26);
		
	
	
	/**
	 * Constructeur PanneauBarreOutils.
	 * Initialise les dimensions, la couleur de font et les boutons du panneau. 
	 */
	public PanneauBarreOutils() {
		this.setPreferredSize(new Dimension(LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT));
		this.setBackground(COULEUR_FOND_PAR_DEFAUT);
		
		this.initButtons();
	}
	
	
	
	/**
	 * Initialise les boutons "Nouveau" et "Resolution".
	 */
	private void initButtons (){
		JButton buttonNouveau = new JButton(new ActionButtonNouveau());
		buttonNouveau.setPreferredSize(DIMENSION_BOUTON_PAR_DEFAUT);
		this.add(buttonNouveau);
		
		JButton buttonResolution = new JButton(new ActionButtonResolution());
		buttonResolution.setPreferredSize(DIMENSION_BOUTON_PAR_DEFAUT);
		this.add(buttonResolution);		
	}
	
}
