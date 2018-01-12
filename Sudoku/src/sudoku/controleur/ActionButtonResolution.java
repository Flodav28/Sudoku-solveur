package sudoku.controleur;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import sudoku.modele.SudokuSolver;
import sudoku.vue.FenetreSudoku;
import sudoku.vue.PanneauInterface;


/**
 * 
 * Cette Class permet de recuperer la grille entree par l'utilisateur pour ensuite appeler la fonction de resolution et afficher la solution.
 * 
 * @see FenetreSudoku
 * @see PanneauInterface
 * @see SudokuSolver
 *
 * @version 1.0
 */
public class ActionButtonResolution extends AbstractAction {

	/**
	 * Nom du bouton "Resolution".
	 */
	public static final String NOM_ACTION = "Résolution";
	
	
	
	/**
	 * Constructeur ActionButtonResolution.
	 */
	public ActionButtonResolution(){
		super(NOM_ACTION);
	}
	
	
	
	/**
	 * Permet la resolution de la grille lorsque l'utilisateur aura clique sue le bouton "Resolution".
	 * Verifiacation de chaque cellule s'il y a bien au plus un chiffre sinon il y aura un pop-up avec un message d'erreur. 
	 * S'il n'y a pas d'erreur alors recuperation de la grille, conversion de celle-ci en tableau de int, appelle la fonction de resolution et enfin affichage de la solution.
	 * 
	 * @param event
	 * 				Attend une action de l'utilisateur.
	 * 
	 */
	public void actionPerformed(ActionEvent event) {
		PanneauInterface panInterface = FenetreSudoku.getInstance().getPanneauInterface();
		int gridInit[][] = new int[9][9];
		
		
		//Vérif un chiffre par cell
		JOptionPane popupErreur = new JOptionPane();
		int nbErreur = 0;
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				String cell = panInterface.getTab()[i][j].getText();
				if(cell.length()>1){
					nbErreur++;
				}
			}
		}
		
		
		if(nbErreur==0){
			//Récup grille init en int
			for(int i=0; i<9; i++){
				for(int j=0; j<9; j++){
					String cell = "";
					try {
						cell = panInterface.getTab()[i][j].getText(0, 1);
					} catch (BadLocationException e) {
						e.printStackTrace();
					}
					
					if(!cell.equals("1") && !cell.equals("2") && !cell.equals("3") && !cell.equals("4") && !cell.equals("5") && !cell.equals("6") && !cell.equals("7") && !cell.equals("8") && !cell.equals("9")){ 
						gridInit[i][j] = 0;
					}
					else{
						gridInit[i][j] = Integer.parseInt(cell);
					}
					
					System.out.println("*"+gridInit[i][j]+"*");
				}
			}			
			
			//Solver
			SudokuSolver sudokuSolver = new SudokuSolver();
			
			//Affichage de la solution
			for(int i=0; i<9; i++){
				for(int j=0; j<9; j++){
					panInterface.getTab()[i][j].setText(Integer.toString(sudokuSolver.getGridResult()[i][j]));				
				}
			}
		}
		else{
			popupErreur.showMessageDialog(null, "Erreur - Un chiffre par cell ("+nbErreur+")", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	
		System.out.println("Action Résolution");
		
	}

}
