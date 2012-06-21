package webservice;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;


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
	public Players getAllPlayer() throws JAXBException, FileNotFoundException
	{
		XMLHelper marsh = new XMLHelper();
		Players players = marsh.unmarshalPlayers(PLAYER_XML);
		return players;
	}
	
	/**
	 * player.xml wird durch neuen Spieler mit "eindeutiger" ID und Name überschrieben.
	 * id ist momentan eine zufällige Zahl zwischen 0 und 10000
	 * @return void
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	public void setPlayer(String name) throws JAXBException, FileNotFoundException, IOException
	{
		XMLHelper creator = new XMLHelper();
		Random rand = new Random();
		Player player1 = creator.createPlayer(name, rand.nextInt(10000), 0, 0);
		playerslist.add(player1);
		players.getPlayer().add(player1);
		
		creator.marshalPlayers(PLAYER_XML, players);		
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
	public void killPlayer(int id) throws JAXBException, FileNotFoundException, IOException
	{
		XMLHelper creator = new XMLHelper();
		Player found = new Player();
		for(int i=0;i < players.getPlayer().size();i++){
			found = players.getPlayer().get(i);
			if (found.getId()==id){
				players.getPlayer().remove(i);
				creator.marshalPlayers(PLAYER_XML, players);
			}
		}
	}
	
	/**
	 * Anzeigen der Spieler Daten 
	 * OHNE FUNKTION, NICHT VERWENDEN!!!!
	 * @param id
	 * @return
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void getPlayerData(int jid, String name, int loss, int wins) throws JAXBException, FileNotFoundException, IOException
	{
		Player found = new Player();
		
		for(int i=0;i < players.getPlayer().size();i++){
			found = players.getPlayer().get(i);
			if (found.getId()==jid){
				name = found.getName();
				wins = found.getWins();
				loss = found.getLoss();
			}
		}
	}
	
	
	/**
	 * 
	 * @param jid
	 * @return
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public int getPlayerid(String jid) throws JAXBException, FileNotFoundException, IOException
	{
		Player found = new Player();
		for(int i=0;i < players.getPlayer().size();i++){
			found = players.getPlayer().get(i);
			if (found.getName()==jid){
				return found.getId();
			}
		}
		return found.getId();
	}
	
	/**
	 * 
	 * @param jid
	 * @return
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String getPlayerName(int jid) throws JAXBException, FileNotFoundException, IOException
	{
		Player found = new Player();
		for(int i=0;i < players.getPlayer().size();i++){
			found = players.getPlayer().get(i);
			if (found.getId()==jid){
				return found.getName();
			}
		}
		return found.getName();
	}
	
	/**
	 * 
	 * @param jid
	 * @return
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public int getPlayerWinners(int jid) throws JAXBException, FileNotFoundException, IOException
	{
		Player found = new Player();
		for(int i=0;i < players.getPlayer().size();i++){
			found = players.getPlayer().get(i);
			if (found.getId()==jid){
				return found.getWins();
			}
		}
		return found.getWins();
	}
	
	/**
	 * 
	 * @param jid
	 * @return
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public int getPlayerLooses(int jid) throws JAXBException, FileNotFoundException, IOException
	{
		Player found = new Player();
		for(int i=0;i < players.getPlayer().size();i++){
			found = players.getPlayer().get(i);
			if (found.getId()==jid){
				return found.getLoss();
			}
		}
		return found.getLoss();
	}
	
	/**
	 * Spielerdaten updaten
	 * @param id
	 * @param wins
	 * @param loss
	 * @return void
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void updatePlayer(int id, int wins, int loss) throws JAXBException, FileNotFoundException, IOException
	{
		Player found = new Player();
		XMLHelper creator = new XMLHelper();
		for(int i=0;i < players.getPlayer().size();i++){
			found = players.getPlayer().get(i);
			creator.updatePlayer(id, wins, loss, found);
			creator.marshalPlayers(PLAYER_XML, players);
		}
	}
	
	/**
	 * Gebe zur Frage <code>nr</code> alle Daten über Parameter zurück 
	 * OHNE FUNKTION, NICHT VERWENDEN!!!!
	 * @param nr
	 * @param link
	 * @param genre
	 * @param time
	 * @param antworten
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	public void getFrageDatas(Integer nr, String link, String genre, XMLGregorianCalendar time) throws JAXBException, FileNotFoundException
	{
		de.xml.ObjectFactory obj = new de.xml.ObjectFactory();
		XMLHelper marsh = new XMLHelper();
		Quizfrage found = obj.createQuizgameQuizfrage();
		Antwort antw = obj.createQuizgameQuizfrageAntwort();
		Quizgame frage = marsh.unmarshalQuizgame(QUIZ_XML);
		
		for(int i=0; i<frage.getQuizfrage().size(); i++){
			found = frage.getQuizfrage().get(i);
			if (found.getNr() == nr.intValue()){
				link = found.getBild().getLink();
				genre = found.getGenre();
				time = found.getTime();
				for(int j=0; j<frage.getQuizfrage().get(i).getAntwort().size(); j++){
					antw = frage.getQuizfrage().get(i).getAntwort().get(j);
					System.out.println("\nAntwort"+(j+1)+":"+antw.getValue());
				}
			}
		}
		
	}
	
	/**
	 * Gebe Antworten Liste zu Frage <code>nr</code>
	 * @param nr
	 * @return ArrayList<String>
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	public ArrayList<String> getAntworten(Integer nr) throws JAXBException, FileNotFoundException
	{
		de.xml.ObjectFactory obj = new de.xml.ObjectFactory();
		XMLHelper marsh = new XMLHelper();
		Quizfrage found = obj.createQuizgameQuizfrage();
		Antwort antw = obj.createQuizgameQuizfrageAntwort();
		Quizgame frage = marsh.unmarshalQuizgame(QUIZ_XML);
		ArrayList<String> antworten = new ArrayList<String>();
		
		for(int i=0; i<frage.getQuizfrage().size(); i++){
			found = frage.getQuizfrage().get(i);
			if (found.getNr() == nr.intValue()){
				for(int j=0; j<frage.getQuizfrage().get(i).getAntwort().size(); j++){
					antw = frage.getQuizfrage().get(i).getAntwort().get(j);
					antworten.add(antw.getValue());
				}
			}
		}
		return antworten;
	}
	
	/**
	 * Gebe zur Frage <code>nr</code> die Zeit
	 * @param nr
	 * @return String
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	public XMLGregorianCalendar getFragetime(Integer nr) throws JAXBException, FileNotFoundException
	{
		de.xml.ObjectFactory obj = new de.xml.ObjectFactory();
		XMLHelper marsh = new XMLHelper();
		Quizfrage found = obj.createQuizgameQuizfrage();
		Antwort antw = obj.createQuizgameQuizfrageAntwort();
		Quizgame frage = marsh.unmarshalQuizgame(QUIZ_XML);
		XMLGregorianCalendar time = null;
		
		for(int i=0; i<frage.getQuizfrage().size(); i++){
			found = frage.getQuizfrage().get(i);
			if (found.getNr() == nr.intValue()){
				time = found.getTime();
			}
		}
		
		return time;
	}
	
	/**
	 * Gebe zur Frage <code>nr</code> das genre
	 * @param nr
	 * @return String
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	public String getFrageGenre(Integer nr) throws JAXBException, FileNotFoundException
	{
		de.xml.ObjectFactory obj = new de.xml.ObjectFactory();
		XMLHelper marsh = new XMLHelper();
		Quizfrage found = obj.createQuizgameQuizfrage();
		Antwort antw = obj.createQuizgameQuizfrageAntwort();
		Quizgame frage = marsh.unmarshalQuizgame(QUIZ_XML);
		String genre = new String();
		
		for(int i=0; i<frage.getQuizfrage().size(); i++){
			found = frage.getQuizfrage().get(i);
			if (found.getNr() == nr.intValue()){
				genre = found.getGenre();
			}
		}
		
		return genre;
	}
	
	/**
	 * Gebe zur Frage <code>nr</code> den Link zum Bild 
	 * @param nr
	 * @return String
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	public String getFrageBild(Integer nr) throws JAXBException, FileNotFoundException
	{
		de.xml.ObjectFactory obj = new de.xml.ObjectFactory();
		XMLHelper marsh = new XMLHelper();
		Quizfrage found = obj.createQuizgameQuizfrage();
		Antwort antw = obj.createQuizgameQuizfrageAntwort();
		Quizgame frage = marsh.unmarshalQuizgame(QUIZ_XML);
		String bild = new String();
		
		for(int i=0; i<frage.getQuizfrage().size(); i++){
			found = frage.getQuizfrage().get(i);
			if (found.getNr() == nr.intValue()){
				bild = found.getBild().getLink();
			}
		}
		
		return bild;
	}
	
	/**
	 * Zeige höchsten Score mit Spieler
	 * @return BigInteger
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	public BigInteger getHighscore() throws JAXBException, FileNotFoundException
	{
		de.xml.ObjectFactory obj = new de.xml.ObjectFactory();
		XMLHelper marsh = new XMLHelper();
		Quizgame.Highscore highscore = obj.createQuizgameHighscore();
		Quizgame hscore = marsh.unmarshalQuizgame(QUIZ_XML);
		highscore = hscore.getHighscore();
		BigInteger quizHighscore = highscore.getScore();
		
		return quizHighscore;
	}
	
	/**
	 * Name des Highscore Besitzers
	 * @return String
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	public String getHighscorePlayer() throws JAXBException, FileNotFoundException
	{
		de.xml.ObjectFactory obj = new de.xml.ObjectFactory();
		XMLHelper marsh = new XMLHelper();
		Quizgame.Highscore highscore = obj.createQuizgameHighscore();
		Quizgame hscore = marsh.unmarshalQuizgame(QUIZ_XML);
		highscore = hscore.getHighscore();
		String name = highscore.getFrom();
		
		return name;
	}
	
	/**
	 * Update höchsten Score 
	 * @param name
	 * @param score
	 * @returnQuizgame
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void updateHighscore(String name, BigInteger score) throws JAXBException, FileNotFoundException, IOException
	{	
		de.xml.ObjectFactory obj = new de.xml.ObjectFactory();
		XMLHelper creator = new XMLHelper();
		Quizgame unquiz = creator.unmarshalQuizgame(QUIZ_XML);
		Quizgame.Highscore highscore = obj.createQuizgameHighscore();		
		
		Quizgame.Highscore hscore = creator.createHighscore(name, score, highscore);
		unquiz.setHighscore(hscore);
		creator.marshalQuizgame(QUIZ_XML, unquiz);
	}
}
