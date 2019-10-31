package firsttry;


public class MagicSquare {
	//Klassenvariablen
		private int[][] square;
		
		
		
		// Konstruktor
		public MagicSquare (int[][] square) {
			this.square= square;
			}
		

		public boolean isMagicSquare() {
			  // Zur Vereinfachung quadratisches Format angenommen 
		    int laenge = square.length;
		    int zielsumme = laenge * (laenge * laenge + 1) / 2;
		    boolean vorTest = true; // meldeten alle vorherigen Test true zur�ck?
		    // Idee: wir ermitteln zuerst Zeile/Spalte/Diagonale und summieren diese jeweils in gleicher Weise auf.
		    vorTest = vorTest && richtigeZahlen(square);
		    for (int j = 0; j < laenge; j++) {
		      vorTest = vorTest && (zielsumme == summe(zeile(j, square)));
		    }
		    for (int i = 0; i < laenge; i++) {
		      vorTest = vorTest && (zielsumme == summe(spalte(i, square)));
		    }
		    vorTest = vorTest && (zielsumme == summe(diag1(square)));
		    vorTest = vorTest && (zielsumme == summe(diag2(square)));
		    return vorTest;
		  }
			
			
		// Quadrat ausgeben	
		
		public int[][] getSquare() {
			return square;
			  }
			
		public void SquareAusgeben() {
			for ( int zeile = 0; zeile < square.length; zeile++ )
			{
		      for ( int spalte=0; spalte < square[zeile].length; spalte++ )
		        System.out.print( square[zeile][spalte] + " ");
		      	System.out.println();
		      
		    }
		}
		
		public void setSquare(int[][] square) {
			this.square = square;
			}
			
			
		/* pruefen ob genau die Zahlen 1..n^2 drinstehen*/
		  static boolean richtigeZahlen(int[][] square) {
		    boolean bisNokay = true;
		    for (int n = 1; n <= square.length * square.length && bisNokay; n++) {
		      boolean nGefunden = false;
		      for (int zeile=0; zeile < square.length && !nGefunden; zeile++){
		        for (int spalte=0; spalte < square[zeile].length && !nGefunden; spalte++) {
//		        nGefunden = nGefunden || n == square[zeile][spalte];
//		        Da wir die Schleife bei nGefunden==true abbrechen, reicht hier auch:
		          nGefunden = n == square[zeile][spalte];
		        }
		      }
//		    bisNokay = bisNokay && nGefunden;
//		    Da wegen der Schleifenbedingung im Schleifenrumpf bisNokay==true gelten muss, reicht hier auch:
		      bisNokay = nGefunden;
		    }
		    return bisNokay;
		  }
		  
		  
		  static int[] zeile(int zeile, int[][] square) {
			    return square[zeile];
			  }

		  static int[] spalte(int spalte, int[][] square) {
			    int[] ergebnis = new int[square.length]; // neues Array wird zur�ck geliefert
			    for (int zeile = 0; zeile < square.length; zeile++){
			      ergebnis[zeile] = square[zeile][spalte];
			    }
			    return ergebnis;
			  }

			  //�berpr�fung Diagonle 1
			  static int[] diag1(int[][] square) {
			    int[] ergebnis = new int[square.length];
			    for (int i = 0; i < square.length; i++){
			      ergebnis[i] = square[i][i];
			    }
			    return ergebnis;
			  }
			  
			  //�berpr�fung Diagonale 2
			  static int[] diag2(int[][] square) {
			    int[] ergebnis = new int[square.length];
			    for (int i = 0; i < square.length; i++){
			      ergebnis[i] = square[i][square.length - i - 1];
			    }
			    return ergebnis;
			  }

			  /**
			   * Summiert ein Array auf.
			   * @param data zu summierende Daten
			   * @return Summe von data
			   */
			  static int summe(int[] daten) {
			    int sum = 0;
			    for (int element : daten){
			      sum += element;
			    }
			    return sum;
			  }
			
			  public static void main(String[] args) {
				 
				  int [][] test1 = { {16,  3,  2, 13},
			              		   { 5, 10, 11,  8},
			              		   { 9,  6,  7, 12},
			              		   { 4, 15, 14,  1}};
				 
				  int [][] test2= { {16,  2,  3, 13},
			              			{ 5, 10, 11,  8},
			              			{ 9,  6,  7, 12},
			              			{ 4, 15, 14,  1}};
				  
				  int [][] test3 = { {10,  8,  8,  8},
			              			{ 8,  8, 10,  8},
			              			{ 8,  8,  8, 10},
			              			{ 8, 10,  8,  8}};
				  
				  MagicSquare square1 = new MagicSquare(test1);
				  MagicSquare square2 = new MagicSquare(test2);
				  MagicSquare square3 = new MagicSquare(test3);

				  
				      System.out.println("Test: ");
				      square1.SquareAusgeben();
				      System.out.println("Ergebnis: " + square1.isMagicSquare());
				      System.out.println();
				      
				      System.out.println("Test: ");
				      square2.SquareAusgeben();
				      System.out.println("Ergebnis: " + square2.isMagicSquare());
				      System.out.println();
				      
				      System.out.println("Test: ");
				      square3.SquareAusgeben();
				      System.out.println("Ergebnis: " + square3.isMagicSquare());
				    
			
			 } 
			  
}
