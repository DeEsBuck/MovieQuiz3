package webservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.XMLGregorianCalendar;

public class TestMethods {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws JAXBException, FileNotFoundException, IOException{
		MVQService test = new MVQService();
		
		
		test.updateHighscore("ccc", BigInteger.valueOf(10000));
		System.out.println("getHighscorePlayer(): "+test.getHighscorePlayer());
		System.out.println("getHighscore(): "+test.getHighscore());
		System.out.println("\n");
		
		
//		String link = new String();
//		String genre = new String();
//		XMLGregorianCalendar time = null;
//		String[] antworten = null;
//		test.getFrageDatas(1, link, genre, time);
//		System.out.println("link: "+link);
//		System.out.println("genre: "+genre);
//		System.out.println("time: "+time);
//		System.out.println("antworten: "+antworten);
		System.out.println("getFrageBild(): "+test.getFrageBild(3));
		System.out.println("getFrageGenre(): "+test.getFrageGenre(1));
		System.out.println("getFragetime(): "+test.getFragetime(1));
		for(int i=0; i<test.getAntworten(3).size(); i++){
			System.out.println("getAntworten("+(i+1)+"): "+test.getAntworten(3).get(i));
		}
		

		System.out.println("\n");
//		String name;
//		int loss;
//		int wins;
//		test.getPlayerData(1, name, loss, wins);
		test.setPlayer("Hannes");
		int zahl = test.getPlayerid("Hannes");
		test.updatePlayer(zahl, 200, 900);
		System.out.println("getAllPlayer(): "+test.getAllPlayer().getPlayer());
		System.out.println("getPlayerName(): "+test.getPlayerName(zahl));
		System.out.println("getPlayerWinners(): "+test.getPlayerWinners(zahl));
		System.out.println("getPlayerLooses(): "+test.getPlayerLooses(zahl));
		
	}

}
