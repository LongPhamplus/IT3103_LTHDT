package hust.soict.dsai.aims.media;

import hust.soict.dsai.interfaces.Playable;

public class DigitalVideoDisc extends Disc implements Playable{
	
	
	private static int nbDigitalVideoDiscs = 0;
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
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
