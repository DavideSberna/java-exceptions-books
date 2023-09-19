package org.java.book;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Biblioteca {
	
	private static final String FILE_PATH = "src/org/java/book/java.out";
	
	public static String getInput(Scanner scanner, String message) {
	    while (true) {
	        System.out.print(message);
	        String input = scanner.nextLine().trim();
	        if (!input.isEmpty()) {
	            return input;
	        }
	        System.err.println("Il campo non può essere vuoto. Riprova.");
	    }
	}


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Inserisci il numero di libri: ");
		int nBook = Integer.valueOf(sc.nextLine());
		
		Book[] books = new Book[nBook];
		
		 
		 int i = 0;
	        while (i < nBook) {
	            try {
	            	String title = getInput(sc, "Inserisci il titolo del libro: ");
	               
	            	System.out.print("Inserisci il numero pagine: ");
	                String numberStr = sc.nextLine();
	                
	                int number;
	                
	                try {
	                	
	                    number = Integer.parseInt(numberStr);
	                    
	                } catch (NumberFormatException e) {
	                	
	                    System.err.println("Inserisci un valore numerico valido");
	                    i--;
	                    continue;
	                }

	                String author = getInput(sc, "Inserisci l'autore: ");
	                
	        		String publisher = getInput(sc, "Inserisci l'editore: ");
	                            
	                books[i] = new Book(title, number, author, publisher);            

	            } catch (IllegalArgumentException e) {
	                System.err.println("Errore: " + e.getMessage());
	                i--;
	            } catch (Exception e) {
	                System.err.println("Invalid Persona data: " + e.getMessage());
	                i--;
	            } finally {
	                i++;
	            }
	        }
	        sc.close();
		
	        
	        
	        
	        
	        
	        FileWriter myWriter = null;
		
	        try {
	        	myWriter = new FileWriter(FILE_PATH);
	        	for (int x=0;x<nBook;x++) {
					
					myWriter.write(books[x].getTitle() + "\n");
					
				}
	        	
	        } catch(IOException e) {
	        	
	        }finally {
				
				try {
					myWriter.close();
				} catch (IOException e) {		
					e.printStackTrace();
				}
			}
	        
	        
	        File tmpFile = new File(FILE_PATH);
			sc = null;
			try {
				
				sc = new Scanner(tmpFile);
				
				while (sc.hasNextLine()) {
					
					String record = sc.nextLine();
					System.out.println("Il titolo: " + record);
				}
			} catch (Exception e) { 
			
				System.out.println("Error reading file: " + e.getMessage());
			} finally {
				
				if (sc != null)
					sc.close();
			}
		
		
		

	}

}
