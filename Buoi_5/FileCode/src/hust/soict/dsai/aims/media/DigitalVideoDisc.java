package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.interfaces.Playable;

public class DigitalVideoDisc extends Disc implements Playable{
	
	
	private static int nbDigitalVideoDiscs = 0;
	
	public void play() throws PlayerException {
	    if (this.getLength() > 0) {
	        System.out.println("Playing DVD: " + this.getTitle());
	        System.out.println("DVD length: " + this.getLength());
	    } else {
	        throw new PlayerException("ERROR: DVD length is non-positive!");
	    }
	}
	
	public DigitalVideoDisc(int id, String title, String category, String director, int length, double cost) {
		super(id, title, category, cost, director, length);

		nbDigitalVideoDiscs++;
		System.out.println("Numbers of DigitalVideoDiscs: " + DigitalVideoDisc.getNbDigitalVideoDiscs());
	}
	
	public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }
	

}
