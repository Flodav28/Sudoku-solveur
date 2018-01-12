package sudoku.modele;


/**
 * 
 * Traitement de la grille entree par l'utilisateur afin d'obtenir une solution conformement aux regles du Sudoku.
 *
 * @version 1.0
 */
public class SudokuSolver {
	
	/**
	 * La grille initiale non resolue.
	 * 
	 * @see SudokuSolver#getGridInit()
	 */
	private int gridInit[][] = new int[9][9];
	/**
	 * La grille resolue.
	 * 
	 * @see SudokuSolver#getGridResult()
	 */
	private int gridResult[][] = new int[9][9];
	private int number[] = {1,2,3,4,5,6,7,8,9};
		
	
	
	//TEST
	public SudokuSolver(){		
		//****
		int nb = 1;
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				this.getGridResult()[i][j] = nb;
			    nb++;
			}
		}
		//***		
	}
	/**
	 * Constructeur SudokuSolver.
	 * 
	 * @param gridInit
	 * 					La grille de l'utilisateur.
	 * 
	 */
	public SudokuSolver(int gridInit[][]){
		//Init la grille - Pas utile
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				this.getGridInit()[i][j] = gridInit[i][j];
			}
		}
		
		//lancement de l'algo de résolution
		this.solver(this.getGridInit());
		
	}
	
	
	
	/**
	 * Fonction de resolution d'une grille de Sudoku.
	 * 
	 * @param gridInit
	 * 					La grille a resoudre.
	 * @return La grille resolue.
	 */
	private int[][] solver(int gridInit[][]){
		
		return null;
	}
	
	
	
	/**
	 * Retourne la grille a resoudre.
	 * 
	 * @return La grille a resoudre.
	 * 
	 * @see gridInit
	 */
	private int[][] getGridInit(){
		return gridInit;
	}
	/**
	 * Retourne la grille resolue.
	 * 
	 * @return La grille resolue.
	 * 
	 * @see gridResult
	 */
	public int[][] getGridResult(){
		return gridResult;
	}

}
