/*
 * 
 */
package test;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

/**
 * 
 */


import static org.junit.Assert.*;



/**
 * @author luka
 *
 */
public class TwitterPorukaTest {

	private TwitterPoruka tp;

	/**
	 * Pravi novi objekat klase TwitterPoruka pre svakog testa i dodeljuje atributu tp.
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		TwitterPoruka tp = new TwitterPoruka();
	}

	/**
	 * Postavlja vrednost atributa tp na null nakon svakog testa.
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		tp = null;
	}

	@Test
	public void testSetKorisnik(){
		String imeKorisnika = "Marko Markovic";

		tp.setKorisnik(imeKorisnika);

		assertEquals(imeKorisnika, tp.getKorisnik());
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull(){
		tp.setKorisnik(null);
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazan(){
		tp.setKorisnik("");
	}

	@Test
	public void testGetKorisnik(){
		tp.setKorisnik("Marko Markovic");

		assertEquals("Marko Markovic", tp.getKorisnik());
	}

	@Test
	public void testSetPorukaSveOk(){
		String poruka = "Sto je danas lep i suncan dan";
		tp.setPoruka(poruka);
		assertEquals(poruka, tp.getPoruka());
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull(){
		tp.setPoruka(null);
	}
	
	

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaDugString(){
		tp.setPoruka("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
				+ "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"
				+ "CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC"
				+ "DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD "
				+ "EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
	}

	@Test
	public void testGetPoruka(){
		tp.setPoruka("Sto je danas lep i suncan dan");

		assertEquals("Sto je danas lep i suncan dan", tp.getPoruka());
	}
	
	@Test
	public void testToString(){
		tp.setKorisnik("Marko Markovic");
		tp.setPoruka("Sto je danas lep i suncan dan");
		
		assertEquals("KORISNIK:"+"Marko Markovic"+" PORUKA:"+"Sto je danas lep i suncan dan", tp.toString());
	}

}
