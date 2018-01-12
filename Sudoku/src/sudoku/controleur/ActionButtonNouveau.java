package sudoku.controleur;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import sudoku.vue.FenetreSudoku;
import sudoku.vue.PanneauInterface;


/**
 * 
 * Cette Class permet une reinitialisation/effacement de la grille qui est affichee dans la fenetre. 
 * 
 * @see FenetreSudoku
 * @see PanneauInterface
 *
 * @version 1.0
 */
public class ActionButtonNouveau extends AbstractAction {

	/**
	 * Nom du bouton "Nouveau".
	 */
	public static final String NOM_ACTION = "Nouveau";
	
	
	
	/**
	 * Constructeur ActionButtonNouveau.
	 */
	public ActionButtonNouveau(){
		super(NOM_ACTION);
	}
	
	
	
	/**
	 * Efface la grille lorsque l'utilisateur aura clique sur le bouton "Nouveau".
	 * 
	 * @param event
	 * 				Attend une action de l'utilisateur.
	 * 
	 */
	public void actionPerformed(ActionEvent event) {
		PanneauInterface panInterface = FenetreSudoku.getInstance().getPanneauInterface();
		
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				panInterface.getTab()[i][j].setText("");
				
				//panInterface.getGrid()[i][j] = 0;
			}
		}
		
		System.out.println("Action Nouveau");
	}

}
