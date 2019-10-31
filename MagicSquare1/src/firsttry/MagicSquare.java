package firsttry;


public class MagicSquare {

	/**
	 * Team: Laura Weber, Basel Alwani, Nils Lüdtke, Benny Burkert
	 */
	private int[][] square;

	/**
	 * Methode für Assignment: Konstruktor
	 */
	public MagicSquare (int[][] square) {
		this.square = square;
	}

	/**
	 * Methode für Assignment
	 * @return Ob der square magic ist
	 */
	public boolean isMagicSquare() {
		int laenge = square.length;
		int zielsumme = laenge * (laenge * laenge + 1) / 2;
		boolean vorTest = true;
		vorTest = vorTest && richtigeZahlen(square);
		for (int j = 0; j < laenge; j++) {
			vorTest = vorTest && (zielsumme == summe(zeile(j)));
		}
		for (int i = 0; i < laenge; i++) {
			vorTest = vorTest && (zielsumme == summe(spalte(i)));
		}
		vorTest = vorTest && (zielsumme == summe(diag1()));
		vorTest = vorTest && (zielsumme == summe(diag2()));
		return vorTest;
	}

	/**
	 * Mehtode für Assignment gefordert
	 * @return zweidimensionale Array
	 */
	public int[][] getSquare() {
		return square;
	}

	/**
	 * Nicht gefordert
	 */
	public void squareAusgeben() {
		for ( int zeile = 0; zeile < square.length; zeile++ ) {
		      for ( int spalte=0; spalte < square[zeile].length; spalte++ )
		        System.out.print( square[zeile][spalte] + " ");
		      	System.out.println();
		}
	}
		
	public void setSquare(int[][] square) {
		this.square = square;
	}

	/**
	 * Prüfen ob Zahlen 1,2..n^2 drin stehen
	 * @param square
	 * @return
	 */
	 public boolean richtigeZahlen(int[][] square) {
		boolean bisNokay = true;
		for (int n = 1; n <= square.length * square.length && bisNokay; n++) {
			boolean nGefunden = false;
			for (int zeile=0; zeile < square.length && !nGefunden; zeile++){
				for (int spalte=0; spalte < square[zeile].length && !nGefunden; spalte++) {
					nGefunden = n == square[zeile][spalte];
				}
			}
		      bisNokay = nGefunden;
		    }
		return bisNokay;
	}
		  
		  
	public int[] zeile(int zeile) {
		return square[zeile];
	}

	public int[] spalte(int spalte) {
		int[] ergebnis = new int[square.length];
		for (int zeile = 0; zeile < square.length; zeile++){
			ergebnis[zeile] = square[zeile][spalte];
		}
			return ergebnis;
	}

	/**
	 * Übeprüfe Dialog 1
	 */
	public int[] diag1() {
		int[] ergebnis = new int[square.length];
		for (int i = 0; i < square.length; i++){
			ergebnis[i] = square[i][i];
		}
		return ergebnis;
	}

	/**
	 * Überprüfe Dialog 2
	 * @return
	 */
	public int[] diag2() {
		int[] ergebnis = new int[square.length];
		for (int i = 0; i < square.length; i++){
			ergebnis[i] = square[i][square.length - i - 1];
		}
		return ergebnis;
	}

	/**
	 * Summiert ein Array auf.
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
		/*int [][] test1 = { {16,  3,  2, 13},
				{ 5, 10, 11,  8},
				{ 9,  6,  7, 12},
				{ 4, 15, 14,  1}};*/
		int [][] test1 = {{16,6,9,3},{1,11,8,14},{7,13,2,12},{10,4,15,5}};
				 
		int [][] test2= { {16,  2,  3, 13},
				{ 5, 10, 11,  8},
				{ 9,  6,  7, 12},
				{ 4, 15, 14,  1}};
				  
		int [][] test3 = { {8,  8,  8,  8},
				{ 8,  8, 8,  8},
				{ 8,  8,  8, 8},
				{ 8, 8,  8,  8}};
				  
		MagicSquare square1 = new MagicSquare(test1);
		MagicSquare square2 = new MagicSquare(test2);
		MagicSquare square3 = new MagicSquare(test3);

				  
		System.out.println("Test: ");
		square1.squareAusgeben();
		System.out.println("Ergebnis: " + square1.isMagicSquare());
		System.out.println();
				      
		System.out.println("Test: ");
		square2.squareAusgeben();
		System.out.println("Ergebnis: " + square2.isMagicSquare());
		System.out.println();

		System.out.println("Test: ");
		square3.squareAusgeben();
		System.out.println("Ergebnis: " + square3.isMagicSquare());

			
	}
}
