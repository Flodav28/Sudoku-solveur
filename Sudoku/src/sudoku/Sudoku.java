package sudoku;

import sudoku.vue.FenetreSudoku;


/**
 * 
 * Cette Class permet de lancer le programme en ouvrant une fenetre qui permettra la resolution d'une grille de Sudoku.
 * 
 * @see FenetreSudoku
 * 
 * @version 1.0
 */
public class Sudoku {
	
	public static void main(String[] args) {
				FenetreSudoku.getInstance().setVisible(true);
	}

}
