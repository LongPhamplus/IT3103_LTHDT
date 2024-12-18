package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.interfaces.Playable;

public class Track implements Playable {
	
	private String title;
	private int length;
	
	public void play() throws PlayerException {
	    if (this.getLength() > 0) {
	        System.out.println("Playing DVD: " + this.getTitle());
	        System.out.println("DVD length: " + this.getLength());
	    } else {
	        throw new PlayerException("ERROR: DVD length is non-positive!");
	    }
	}
	
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
	@Override
	public boolean equals(Object o) {
		Track track = (Track) o;
		return track.getTitle().equals(this.getTitle()) && track.getLength() == this.getLength();
	}
}
