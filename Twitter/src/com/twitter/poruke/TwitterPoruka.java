package com.twitter.poruke;

public class TwitterPoruka {
/**
 * atribut koji opisuje koji korisnik ostavlja poruku na tviter nalogu
 */
	private String korisnik;
	/**
	 * atribut koji nam pokazuje poruku koju je ostavio korisnik na tviter nalogu
	 */
	
	private String poruka;
	
	/**
	 * metoda koja vraca korisnika koji je ostavio odredjenu poruku
	 * @return korisnik
	 */
	public String getKorisnik() {
	return korisnik;
	}
	/**
	 * metoda koja postavlja novu vrednost korisnika
	 * @param korisnik
	 */
	
	public void setKorisnik(String korisnik) {
	if (korisnik==null || korisnik == "")
	throw new RuntimeException(
	"Ime korisnika mora biti uneto");
	this.korisnik = korisnik;
	}
	
	/**
	 * metoda koja vraca poruku 
	 * @return poruka
	 */
	public String getPoruka() {
	return "poruka";
	}
	/**
	 * metoda koja postavlja novu vrednost poruke
	 * @param poruka
	 */
	public void setPoruka(String poruka) {
	if (poruka==null || this.poruka.length()>140)
	throw new RuntimeException(
	"Poruka mora biti uneta i mora imati najvise 140 znakova");
	this.poruka = poruka;
	}
	/**
	 * metoda toString koja vraca u celosti koji je korisnik postavio koju poruku u obliku jedne recenice tj stringa
	 */
	public String toString(){
	return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
	} 
}
