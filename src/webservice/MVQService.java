package webservice;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlSeeAlso;


import de.xml.Players;
import de.xml.Quizgame;
import de.xml.Players.Player;
import de.xml.Quizgame.Quizfrage;
import de.xml.Quizgame.Quizfrage.Antwort;
import de.xml.Quizgame.Quizfrage.Bild;

@SuppressWarnings("unused")
@Path( "/quiz" )
public class MVQService {
	private static final String QUIZ_XML= "./././ressourceFiles/quiz.xml";
	private static final String PLAYER_XML= "./././ressourceFiles/player.xml";
	private static final String LINK="http://localhost:4434/bild/nr";
	
	private static ArrayList<Player> playerslist = new ArrayList<Player>(); // Liste aler Player, wird in Players angehängt
	private static Players players = new Players(); // Parent knoten mit allen Player
	
	/**
	 * Gesamtes XML Datenstruktur von Quizgame. Zeige alle Quizfragen, -antworten, -genres,  -highscore zu den genres und Spieler mit höchst Highscore aller Genres	
	 * @return
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	@GET @Produces( "application/xml" )
	public Quizgame getAll() throws JAXBException, FileNotFoundException
	{		
		XMLHelper marsh = new XMLHelper();
		Quizgame quiz = marsh.unmarshalQuizgame(QUIZ_XML);
		return quiz;
	}
		
	/**
	 * Zeige Inhalt aus player.xml registrierten Spieler 
	 * @return
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	@Path("/players")
	@GET @Produces( "application/xml" )
	public Players getAllPlayer() throws JAXBException, FileNotFoundException
	{
		XMLHelper marsh = new XMLHelper();
		Players players = marsh.unmarshalPlayers(PLAYER_XML);
		return players;
	}
	
	/**
	 * player.xml wird durch neuen Spieler mit "eindeutiger" ID und Name überschrieben.
	 * id ist momentan eine zufällige Zahl zwischen 0 und 100
	 * @return void
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	@Path("/player")
	@GET @Produces( "application/xml" )
	public Players setPlayer(@QueryParam("name")String name) throws JAXBException, FileNotFoundException, IOException
	{
		XMLHelper creator = new XMLHelper();
		Random rand = new Random();
		//Spieler benennen und Spielstand für aktuelles Spiel
		Player player1 = creator.createPlayer(name, rand.nextInt(100), 0, 0);
		playerslist.add(player1);
		players.getPlayer().addAll(playerslist);
		
		creator.marshalPlayers(PLAYER_XML, players);
		return players;
		
	}
	
	/**
	 * Spieler kann sich entgültig aus der player.xml entfernen.
	 * Die player.xml wird mit nicts aussagenden Daten befüll und der name wird gelöscht.
	 * @param id
	 * @return
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Path("/player/delete/{id}")
	@GET @Produces( "application/xml" )
	public Players killPlayer(@PathParam("id")int id) throws JAXBException, FileNotFoundException, IOException
	{
		if(playerslist.getId()==id){
			playerslist.remove(player);
		}
		return players;
	}
	
	/**
	 * Spielerdaten updaten
	 * @param id
	 * @param wins
	 * @param loss
	 * @return
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Path("/player/update/{id}")
	@GET @Produces( "application/xml" )
	public Players updatePlayer(@PathParam("id") int id, @QueryParam("wins") int wins, @QueryParam("loss") int loss) throws JAXBException, FileNotFoundException, IOException
	{
		
		
		
		return null;
	}
	
	
	/**
	 * Zeige alle Quizfragen zum Genre (nicht für Spieler relevant)
	 * @param genre
	 * @return
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	@Path("/fragen/{genre}")
	@GET @Produces( "application/xml" )
	public Quizgame getFrage(@PathParam("genre") String genre) throws JAXBException, FileNotFoundException
	{
		de.xml.ObjectFactory obj = new de.xml.ObjectFactory();
			
		XMLHelper marsh = new XMLHelper();
		Quizgame quiz = marsh.unmarshalQuizgame(QUIZ_XML);
			
		Quizgame gen = obj.createQuizgame();
		Iterable<Quizfrage> fragen = gen.getQuizfrage();
		String sam;
		ArrayList<Quizfrage> liste = new ArrayList<Quizfrage>();
			
		// alle Quizfragen durchlaufen und genre vgl.
		for ( Quizfrage i: fragen ) {
			sam = fragen.iterator().next().getGenre();
			if (sam.compareToIgnoreCase(genre) != 0){
				System.out.println("Fehler bei Genre"); 
			}
			else {
			    liste.add(i);
			}
		}
		return gen;	
	}

	/**
	 * Einzelne Quizfrage mit Antworten zum Genre
	 * @param genre
	 * @param i
	 * @return
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	@Path("/fragen/{genre}/{id}")
	@GET @Produces( "application/xml" )
	public Quizgame getFrage(@PathParam("genre") String genre,@PathParam("id") int i) throws JAXBException, FileNotFoundException
	{
		de.xml.ObjectFactory obj = new de.xml.ObjectFactory();
		XMLHelper marsh = new XMLHelper();
		Quizgame quiz = marsh.unmarshalQuizgame(QUIZ_XML);
			
		Quizgame frage = obj.createQuizgame();
		Quizfrage gen = obj.createQuizgameQuizfrage();
		frage.getQuizfrage().add(quiz.getQuizfrage().get(i-1));
			
		try {
			String test = gen.getGenre();
			if (test.compareToIgnoreCase(genre) != 0){
				System.out.println(test);
				return frage;
			}
		}
		catch (NullPointerException e){
			System.out.println("Genre nicht gefunden.");
		}
			
		return frage;
	}

	/**
	 * Zeige alle Quizfragen mit Bilder, Genre und Antworten (nicht für Spieler relevant)
	 * @return
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	@Path("/fragen")
	@GET @Produces( "application/xml" )
	public Quizgame getAllFragen() throws JAXBException, FileNotFoundException
	{
		de.xml.ObjectFactory obj = new de.xml.ObjectFactory();
		XMLHelper marsh = new XMLHelper();
		Quizgame quiz = marsh.unmarshalQuizgame(QUIZ_XML);
			
		Quizgame frage = obj.createQuizgame();
		frage.getQuizfrage();
		return frage;
	}

}
