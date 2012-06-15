package webservice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;


import de.xml.Players.Player;
import de.xml.Quizgame;
import de.xml.Quizgame.Highscore;
import de.xml.Quizgame.Quizfrage;
import de.xml.Quizgame.Quizfrage.Antwort;
import de.xml.Quizgame.Quizfrage.Bild;
import de.xml.Players;

@SuppressWarnings("unused")
public class XMLHelper {
	
	
	
	
	/**
	 * Erzeugt 4 Antwortmöglichkeiten, die mit der Funktion createAntwort erfasst werden. 
	 * Diese ArrayList muss in createFrage() übergeben werden.
	 * @param result
	 * @param value
	 * @param result1
	 * @param value1
	 * @param result2
	 * @param value2
	 * @param result3
	 * @param value3
	 * @return ArrayList<Antwort>
	 */
	public ArrayList<Antwort> createAntwortList (Boolean result, String value, Boolean result1, String value1, Boolean result2, String value2, Boolean result3, String value3) {
		ArrayList<Quizgame.Quizfrage.Antwort> antworten = new ArrayList<Quizgame.Quizfrage.Antwort>();
		Quizgame.Quizfrage.Antwort antwort = createAntwort(result, value);
		antworten.add(antwort);
		Quizgame.Quizfrage.Antwort antwort1 = createAntwort(result1, value1);
		antworten.add(antwort1);
		Quizgame.Quizfrage.Antwort antwort2 = createAntwort(result2, value2);
		antworten.add(antwort2);
		Quizgame.Quizfrage.Antwort antwort3 = createAntwort(result3, value3);
		antworten.add(antwort3);
		return antworten;
	}
	
	/**
	 * Zur Verwendung in createAntwortList()
	 * @param result
	 * @param value
	 * @return Antwort
	 */
	public Antwort createAntwort (Boolean result, String value) {
		Quizgame.Quizfrage.Antwort antwort = new Antwort();
		antwort.setResult(result);
		antwort.setValue(value);
		return antwort;
	}

	/**
	 * Objekt Quizfrage muss in getQuizfrage() dem Quizgame Root eingefügt werden. Z.B. <CODE>quiz.getQuizfrage().addAll(fragen);</CODE>
	 * @param nr
	 * @param time
	 * @param link
	 * @param antwort
	 * @return Quizfrage
	 */
	public Quizfrage createFrage (String genre, int nr, XMLGregorianCalendar time, Bild link, ArrayList<Antwort> antwort) {
		Quizgame.Quizfrage frage = new Quizfrage();
		frage.setGenre(genre);
		frage.setNr(nr);
		frage.setTime(time);
		frage.setBild(link);
		frage.getAntwort().addAll(antwort);
		return frage;
	}
	
	
	/**
	 * Objekt Players Liste erstellen 
	 * @param name
	 * @param wins
	 * @param loss
	 * @param id
	 * @return ArrayList<Player>
	 */
	public ArrayList<Player> createPlayers (String name, int id, int wins, int loss) {
		ArrayList<Player> players = new ArrayList<Player>();
		Player player = createPlayer(name, id, wins, loss);
		players.add(player);
		return players;
	}
	
	/**
	 * 
	 * @param name
	 * @param id
	 * @param wins
	 * @param loss
	 * @return Player
	 */
	public Player createPlayer(String name, int id, int wins, int loss) {
		Player player = new Player();
		if(player.getId() != id){
			player.setName(name);
			player.setId(id);
			player.setWins(wins);
			player.setLoss(loss);
		}else{
			System.out.println("Gesuchte id "+id+" gibt es schon.");
		}
		return player;
	}
	
	/**
	 * Spieler Daten Updaten
	 * @param id
	 * @param wins
	 * @param loss
	 * @return
	 */
	public Player updatePlayer(int id, int wins, int loss, Player player) {
		if(player.getId() == id){
			player.setWins(wins);
			player.setLoss(loss);
		}else{
			System.out.println("Gesuchte id "+id+" gibt es nicht.");
		}
		return player;
	}
	
	/**
	 * Daten von Spieler löschen
	 * @param id
	 * @return Player
	 */
	public void deletePlayer (int id, Player player) {
		if(player.getId() == id){
			player.setName(null);
			player.setId(0);
			player.setWins(0);
			player.setLoss(0);
		}else{
			System.out.println("Gesuchte id "+id+" gibt es nicht.");
		}
	}
	
	/**
	 * 
	 * @param name
	 * @param score
	 * @return
	 */
	public Highscore createHighscore(String name, BigInteger score){
		Highscore hscore = new Highscore();
		hscore.setFrom(name);
		hscore.setScore(score);
		return hscore;
	}
	
	/**
	 * Unmarshal Quizgame
	 * @param file
	 * @return
	 * @throws JAXBException
	 */
	public Quizgame unmarshalQuizgame(String file) throws JAXBException  {
		Quizgame quiz = new Quizgame();
		JAXBContext context = JAXBContext.newInstance(Quizgame.class);
		Unmarshaller um = context.createUnmarshaller();
		try {
			quiz = (Quizgame) um.unmarshal(new FileReader(file));
		}
		catch (FileNotFoundException e) {
			System.err.println("File not Found");
		}
		catch (Exception e) {
			System.out.println("Fehler");
			e.printStackTrace();
			System.out.println(context.toString());
		}
		return quiz;
	}
	
	/**
	 * Unmarshal Players
	 * @param file
	 * @return
	 * @throws JAXBException
	 */
	public Players unmarshalPlayers(String file) throws JAXBException  {
		Players player = new Players();
		JAXBContext context = JAXBContext.newInstance(Players.class);
		Unmarshaller um = context.createUnmarshaller();
		try {
			player = (Players) um.unmarshal(new FileReader(file));
		}
		catch (FileNotFoundException e) {
			System.err.println("File not Found");
		}
		catch (Exception e) {
			System.out.println("Fehler");
			e.printStackTrace();
			System.out.println(context.toString());
		}
		return player;
	}
	
	public Players marshalPlayers(String file,Players player) throws JAXBException, IOException  {
		JAXBContext context = JAXBContext.newInstance(Players.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(player, System.out);
		
		Writer wr = null;
		try {
			wr = new FileWriter(file);
			m.marshal(player, wr);
		}
		finally {
			try {
				wr.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return player;
	}
}
