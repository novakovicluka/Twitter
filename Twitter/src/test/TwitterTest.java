

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.Twitter;
import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {
	
	private Twitter t;
	
	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}
	
	@Test
	public void testVratiSvePoruke(){
		t.unesi("Marko Markovic", "Sto je danas lep i suncan dan");
		
		assertEquals(1, t.vratiSvePoruke().size());
		assertEquals("Marko Markovic", t.vratiSvePoruke().getFirst().getKorisnik());
		assertEquals("Sto je danas lep i suncan dan", t.vratiSvePoruke().getFirst().getPoruka());
	}
	
	@Test
	public void testUnesi(){
		TwitterPoruka tp1 = new TwitterPoruka();
		tp1.setKorisnik("Donald Trump");
		tp1.setPoruka(" Donald J Trump for President");
		
		LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
		poruke.add(tp1);
		
		t.unesi("Donald Trump", " Donald J Trump for President");
		
		assertEquals(1, t.vratiSvePoruke().size());
		
		assertEquals(poruke.get(0).getKorisnik(), t.vratiSvePoruke().get(0).getKorisnik());
		assertEquals(poruke.get(0).getPoruka(), t.vratiSvePoruke().get(0).getPoruka());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void vratiPorukeNullTag(){
		t.vratiPoruke(50, null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void vratiPorukePrazanTag(){
		t.vratiPoruke(50, "");
	}
	
	@Test
	public void vratiPorukeMaxBrojNijePozitivan(){
		assertEquals(100, t.vratiPoruke(0, "tag").length);
	}
	
	@Test
	public void vratiPorukeSveOk(){
		TwitterPoruka[] tvit = new TwitterPoruka[2];
		tvit[0] = new TwitterPoruka();
		tvit[0].setKorisnik("Donald");
		tvit[0].setPoruka("FOR PRESIDENT");
		tvit[1] = new TwitterPoruka();
		tvit[1].setKorisnik("Trump");
		tvit[1].setPoruka("OF USA");
		
		t.unesi("Donald", "FOR PRESIDENT");
		t.unesi("Trump", "OF USA");
		
		TwitterPoruka[] testNiz = t.vratiPoruke(2, "OF USA");
		assertEquals(tvit[0].getKorisnik(), testNiz[0].getKorisnik());
		assertEquals(tvit[0].getPoruka(), testNiz[0].getPoruka());
		assertEquals(tvit[1].getKorisnik(), testNiz[1].getKorisnik());
		assertEquals(tvit[1].getPoruka(), testNiz[1].getPoruka());
	}

}