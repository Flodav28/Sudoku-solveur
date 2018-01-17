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
	
	public int[][] sudokuSolver(int gridInit[][], int x, int y){
		if(this.gridInit[x][y]<9){
			this.gridInit[x][y]=this.gridInit[x][y]+1;
			if(checking(x,y)==true){
				if(x<8){
					return sudokuSolver(gridInit, x+1,y);
				}
				else if(x==8 & y<8){
					return sudokuSolver(gridInit, 0,y+1);
				}
				else{
					System.out.println("Le sudoku est résolu");
					displaySudoku(this.gridInit);
					return this.gridInit;
				}
			}
			else{
				 return sudokuSolver(gridInit, x,y);
			}
		}
		else if(this.gridInit[x][y]==9){
			if(x>0){
				this.gridInit[x][y]=0;
				 return sudokuSolver(gridInit, x-1, y);
			}
			else if(x==0 & y>0){
				this.gridInit[x][y]=0;
				return sudokuSolver(gridInit, 8, y-1);
			}
			else{
				System.out.println("Impossible de résoudre");
				return null;
			}
		}
		else{
			return null;
		}
		
	}
	
	public boolean checking(int i,int j){
		boolean check = true;
		for(int k=0; k<9; k++){
			if(k!=i){
				if (this.getGridInit()[i][j]==this.getGridInit()[k][j]){
					check = false;
				}
			}
		}
		for(int l=0; l<9; l++){
			if(l!=j){
				if (this.getGridInit()[i][j]==this.getGridInit()[i][l]){
						check = false;
				}
			}
		}
		int partieX = i/3;
		int partieY = j/3;
		for(int x=3*partieX; x<3*partieX+3; x++){
			for(int y=3*partieY; y<3*partieY+3; y++){
				if(x!=i & y!=j){
					if(this.getGridInit()[x][y]==this.getGridInit()[i][j]){
						check = false;
					}
				}
			}
		}
			
		return check;
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
		this.gridResult=this.solver(this.getGridInit());
		
	}
	
	
	
	/**
	 * Fonction de resolution d'une grille de Sudoku.
	 * 
	 * @param gridInit
	 * 					La grille a resoudre.
	 * @return La grille resolue.
	 */
	private int[][] solver(int gridResult[][]){
		return sudokuSolver(gridResult,0,0);
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



	public void displaySudoku(int gridInit[][]){
		System.out.println("LA matrice est :");
		for (int i=0;i<gridInit.length;i++){
			for (int j=0;j<9;j++){
				System.out.print(gridInit[i][j]);
				if(j==8 ){
					System.out.println();
				}
			}
		}
		
	}
}
