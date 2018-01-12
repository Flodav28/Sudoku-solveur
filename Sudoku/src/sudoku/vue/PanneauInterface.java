package sudoku.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.NumberFormat;
import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;


/**
 * 
 * Creation d'un contenu ayant une grille du Sudoku qui pourra etre modifiee par l'utilisateur et affichera la solution. Celui-ci se situe au centre de la fenetre.
 * 
 * @version 1.0
 */
public class PanneauInterface extends JPanel {

	/**
	 * La largeur par defaut du panneau.
	 */
	public static final int LARGEUR_PAR_DEFAUT = 500;
	/**
	 * La hauteur par defaut du panneau.
	 */
	public static final int HAUTEUR_PAR_DEFAUT = 400;
	/**
	 * La couleur de fond par defaut du panneau.
	 */
	private static final Color COULEUR_FOND_PAR_DEFAUT = Color.LIGHT_GRAY;
	/**
	 * La dimension de la cellule par defaut du panneau.
	 */
	private static final Dimension DIMENSION_CELL_PAR_DEFAUT = new Dimension(40,40);
	/**
	 * La dimension de la cellule noircie par defaut du panneau.
	 */
	private static final Dimension DIMENSION_CELLBLACK_PAR_DEFAUT = new Dimension(2,2);
	/**
	 * Tableau de zones de texte où l'utilisateur pourra rentrer ses valeurs sous la forme de String.
	 * 
	 * @see PanneauInterface#getTab()
	 */
	private JFormattedTextField tab [][] = new JFormattedTextField[9][9];
	
	
	
	/**
	 * Constructeur PanneauInterface
	 * Initialise les dimensions et la couleur de font du panneauainsi que la grille.
	 */
	public PanneauInterface() {
		this.setPreferredSize(new Dimension(LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT));
		this.setBackground(COULEUR_FOND_PAR_DEFAUT);
		this.setLayout(new GridBagLayout());
		
		this.initGrid();
		this.displayGrid();
	}

	
	
	/**
	 * Initialise la grille de zones de texte par un tableau[9][9].
	 */
	private void initGrid(){		
		int nb = 1;
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				//JLabel cell = new JLabel(Integer.toString(nb), JLabel.CENTER);
				JFormattedTextField cell = new JFormattedTextField(NumberFormat.getIntegerInstance());
				cell.setPreferredSize(DIMENSION_CELL_PAR_DEFAUT);
				cell.setHorizontalAlignment(JFormattedTextField.CENTER);
				//cell.setText(Integer.toString(nb));
				cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				tab[i][j] = cell;
			    
			    nb++;
			}
		}		
		tab[0][2].setText("");				
	}
	
	/**
	 * Format d'affichage du tableau conformement au Sudoku.
	 */
	private void displayGrid(){
		GridBagConstraints gbc = new GridBagConstraints();
		
		int col = 0;
		for(int j=0; j<11; j++){
			int li = 0;
			if(j==3 || j==7){
				for(int i=0; i<11; i++){
					JPanel cellBlack = new JPanel();
					cellBlack.setBackground(Color.black);
					cellBlack.setPreferredSize(DIMENSION_CELLBLACK_PAR_DEFAUT);
					gbc.gridx = i;
					gbc.gridy = j;
					gbc.gridheight = 1;
				    gbc.gridwidth = 8;	
					gbc.fill = GridBagConstraints.HORIZONTAL;
				    this.add(cellBlack, gbc);
				}
			}
			else{
				for(int i=0; i<11; i++){
					if(i==0){
						//On positionne la case de départ du composant
					    gbc.gridx = 0;
					    gbc.gridy = j;
					    //La taille en hauteur et en largeur
					    gbc.gridheight = 1;
					    gbc.gridwidth = 1;
					    this.add(tab[col][li], gbc);
					    
					    li++;
					}
					else if(i==3 || i==7){
						JPanel cellBlack = new JPanel();
						cellBlack.setBackground(Color.black);
						cellBlack.setPreferredSize(DIMENSION_CELLBLACK_PAR_DEFAUT);
						gbc.gridx = i;
						gbc.gridy = j;
						gbc.gridheight = 8;
					    gbc.gridwidth = 1;	
						gbc.fill = GridBagConstraints.VERTICAL;
					    this.add(cellBlack, gbc);
					}
					else if(i==10){
						gbc.gridx = 10;
					    gbc.gridy = j;
					    gbc.gridheight = 1;
					    gbc.gridwidth = 1;
					    //Cette instruction informe le layout que c'est une fin de ligne
					    gbc.gridwidth = GridBagConstraints.REMAINDER;
					    this.add(tab[col][li], gbc);
					}
					else{
						gbc.gridx = i;
						gbc.gridy = j;
						gbc.gridheight = 1;
					    gbc.gridwidth = 1;
						this.add(tab[col][li], gbc);
						
						li++;
					}
				}	
				col++;
			}
		}
		
		/*for(int j=0; j<9; j++){
			for(int i=0; i<9; i++){
				if(i==0){
					//On positionne la case de départ du composant
				    gbc.gridx = 0;
				    gbc.gridy = j;
				    //La taille en hauteur et en largeur
				    gbc.gridheight = 1;
				    gbc.gridwidth = 1;
				    this.add(tab[j][i], gbc);
				}
				else if(i==8){
					//Cette instruction informe le layout que c'est une fin de ligne
				    gbc.gridwidth = GridBagConstraints.REMAINDER;
				    gbc.gridx = 8;		
				    this.add(tab[j][i], gbc);
				}
				else{
					gbc.gridx = i;
					this.add(tab[j][i], gbc);
				}
			}	    
		}*/
	}
	
	
	
	/**
	 * Retourne la grille de zones de texte.
	 * 
	 * @return tableau correspondant à la grille de zones de texte.
	 * 
	 * @see tab
	 */
	public JFormattedTextField[][] getTab(){
		return tab;
	}

	
}
