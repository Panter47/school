import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GestioneFile {
	private String tempFile;
	private ArrayList<Libro> libreria;

	public GestioneFile(String tempFile) {
		this.tempFile=tempFile;
		this.libreria= new ArrayList<Libro>();
	}
	/**
	 * read a every line in the file .txt ad save them in ArrayList libreria
	 */
	public void readFile() {
		File myObj = new File(tempFile);
		
		try (Scanner myReader = new Scanner(myObj)){
			while(myReader.hasNextLine()) {
				String data = myReader.nextLine();
				libreria.add(Libro.fromString(data));
			}
		} catch(FileNotFoundException e) {
			System.out.println("errore!!!!");
			e.printStackTrace();
		}
	}
	
	/**
	 * write a new file .txt
	 */
	public void writeFile() {
		try {
			FileWriter myWriter = new FileWriter(tempFile);
			for(Libro l : libreria) {
				myWriter.write(l.toString()+"\n");
			}
			myWriter.close();
		}catch(IOException e) {
			System.out.println("errore nell'apertura scrittura del file");
			e.printStackTrace();
		}
	}
	
	/**
	 * search a book by title
	 * @param titolo title from a book object
	 * @return book object
	 */
	public Libro getLibro(String titolo) {
		for(Libro l : libreria) {
			if(l.getTitolo().equalsIgnoreCase(titolo))
				return l;
		}
		return null;
	}
	
	/**
	 * aggiung un libro alla lista di libri
	 * @param libro oggetto libro aggiunto
	 */
	public void addLibro(Libro libro) {
		libreria.add(libro);
		writeFile();
	}
	
	/**
	 * remove the book in the list
	 * @param titolo
	 */
	public void removeLibro(String titolo) {
		libreria.remove(getLibro(titolo));
		writeFile();
	}
	
	/**
	 * dice quanti libri sono presenti all'interno del file
	 * @return il numero di libri presenti
	 */
	public int totNumLibri() {
	return libreria.size();
	}
	
	/**
	 * calcola il totale spesso per tutti i libri
	 * @return il costo totale di tutti i libri
	 */
	public double totPrezzoLibri() {
		double tot=0;
		for(Libro l : libreria) {
			tot+= l.getPrezzo();
		}
		return tot;
	}
	
	/**
	 * trova tutti i libri di un certo anno
	 * @param anno data di publicazione del libro
	 * @return un ArrayList di tutti libri di quell'anno
	 */
	public ArrayList<Libro> trovaPerAnno(int anno) {
		ArrayList<Libro> lib = new ArrayList<>();
		
		for(Libro l : libreria){
			if(l.getAnno() == anno)
				lib.add(l);
		}
		return lib;
	}
	
	/**
	 * trova tutti i libri di un certo genere
	 * @param genere tipologia di ogni libro
	 * @return un ArrayList di tutti i libri di quel genere
	 */
	public ArrayList<Libro> trovaPerGenere(String genere) {
		ArrayList<Libro> lib = new ArrayList<>();
		
		for(Libro l : libreria) {
			if(l.getGenere().equalsIgnoreCase(genere))
				lib.add(l);
		}
		return lib;
	}
	/**
	 * trova tutti i libri di un certo autore
	 * @param autore scrittore di ogni libro
	 * @return un ArrayList di tutti i libri di quel autore
	 */
	public ArrayList<Libro> trovaPerAutore(String autore) {
		ArrayList<Libro> lib = new ArrayList<>();
		for(Libro l : libreria) {
			if(l.getAutore().equalsIgnoreCase(autore))
				lib.add(l);
		}
		return lib;
	}
	
	/**
	 * trova tutti i libri letti 
	 * @return un ArrayList di libri
	 */
	public ArrayList<Libro> libriLetti() {
		ArrayList<Libro> lib = new ArrayList<>();
		for(Libro l : libreria) {
			if(l.getLetto().equalsIgnoreCase("si"))
				lib.add(l);
		}
		return lib;		
	}
	
	/**
	 * trova tutti i libri non letti
	 * @return un ArrayList di libri
	 */
	public ArrayList<Libro> libriNonLetti() {
		ArrayList<Libro> lib = new ArrayList<>();
		for(Libro l : libreria) {
			if(l.getLetto().equalsIgnoreCase("no"))
				lib.add(l);
		}
		return lib;	
	}
	/**
	 * mette in ordine i libri in ordine alfabetico
	 */
	public void ordinaAlfabetico() {
		libreria.sort((l1 ,l2) -> l1.getTitolo().compareToIgnoreCase(l2.getTitolo()));
		writeFile();
	}
	
	
	public void ordinaAnnoAlfa() {
		
	}
	
}