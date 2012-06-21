package webservice;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Result;

import de.xml.Players;
import de.xml.Players.Player;
import de.xml.Quizgame;
import de.xml.Quizgame.Highscore;
import de.xml.Quizgame.Quizfrage.Antwort;
import de.xml.Quizgame.Quizfrage.Bild;


public class TestXMLWriter {	
	private static final String QUIZ_XML= "./././ressourceFiles/quiz.xml";
	private static final String PLAYER_XML= "./././ressourceFiles/player.xml";
	private static final String LINK="http://localhost:4434/bild/nr";
	
	/**
	 * @param args
	 * @return 
	 */
	//Erzeuegen von neuen XML Daten soll vom Client aus steuerbar sein, siehe mvqService.java 
	
	public static void main(String[] args) throws JAXBException, IOException {
//		URL url = new URL("http://advm1.gm.fh-koeln.de");
//		URL urlQuiz = new URL("http://advm1.gm.fh-koeln.de/~mi809/wba/xml/quiz.xml");
//		URL urlPlayer = new URL("http://advm1.gm.fh-koeln.de/~mi809/wba/xml/player.xml");
//		URLConnection connect = urlQuiz.openConnection();
//		
//		connect.setDoInput(true);
//		connect.setDoOutput(true);
//		System.out.println("URL-toString(): "+connect.toString());
//		System.out.println("URL-getContentType(): "+connect.getContentType());
//		System.out.println("URL-getContentEncoding(): "+connect.getContentEncoding());
//		System.out.println("URL-getContent(): "+connect.getContent());
//		OutputStream output = connect.getOutputStream();
//		
//		InputStream input = connect.getInputStream();
		
		
		ArrayList<Quizgame.Quizfrage> fragen = new ArrayList<Quizgame.Quizfrage>();
		ArrayList<Player> players = new ArrayList<Player>();
		
		Quizgame quiz = new Quizgame();
		Players player = new Players();
		XMLHelper creator = new XMLHelper();
		
		//Spieler benennen und Spielstand für aktuelles Spiel
		Player player1 = creator.createPlayer("Harald",1,299,1);
		Player player2 = creator.createPlayer("Bernd",2,299,1);
		players.add(player1);
		players.add(player2);
		player.getPlayer().addAll(players);
		
		//Elemente für Quizfrage deklarieren
		Highscore hscore = new Highscore();
		Quizgame.Highscore highscore = creator.createHighscore("Hans", BigInteger.valueOf(2000), hscore);
		//XMLGregorianCalendar time = new GregorianCalendar();
		Quizgame.Quizfrage.Bild link = new Bild();
		link.setLink(LINK);
		
		//Antwortliste mit bis zu 4 Möglichkeiten
		ArrayList<Antwort> antworten = creator.createAntwortList(true, "Die Vögel", false, "Drakula", false, "Hanni und Nanni", false, "Pokemon");
		ArrayList<Antwort> antworten2 = creator.createAntwortList(true, "Dragonball U", false, "Bones", false, "Zombie Land", false, "sDuck Tales");
		ArrayList<Antwort> antworten3 = creator.createAntwortList(true, "Dragonball GT", false, "Bones", false, "Zombie Land", false, "Duck Tales");
		ArrayList<Antwort> antworten4 = creator.createAntwortList(true, "Dragonball Z", false, "Bones", false, "Zombie Land", false, "Duck Tales");
		
		//Einzelne Filme mit Antwortauswahl von darüber
		Quizgame.Quizfrage frage = creator.createFrage("Komödie",1,null,link,antworten);
		fragen.add(frage);
		Quizgame.Quizfrage frage2 = creator.createFrage("Drama",2,null,link,antworten2);
		fragen.add(frage2);
		Quizgame.Quizfrage frage3 = creator.createFrage("Drama",3,null,link,antworten3);
		fragen.add(frage3);
		Quizgame.Quizfrage frage4 = creator.createFrage("Drama",4,null,link,antworten4);
		fragen.add(frage4);
		
		//Zuweisung der Element an das Root Quizgame
		quiz.getQuizfrage().addAll(fragen);
		quiz.setHighscore(highscore);
		
		//in XML umwandeln und in Quiz.xml schreiben
		
		JAXBContext context = JAXBContext.newInstance(Quizgame.class,Players.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(quiz, System.out);
		m.marshal(player, System.out);
		
		Writer wr = null;
		Writer wr2 = null;
		try {
			wr = new FileWriter(QUIZ_XML);
			wr2 = new FileWriter(PLAYER_XML);
			m.marshal(quiz, wr);
			m.marshal(player, wr2);
//			Result b;
//			m.marshal(quiz, b);
//			output.write((int)b);
		}
		finally {
			try {
				wr.close();
				wr2.close();
//				output.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
