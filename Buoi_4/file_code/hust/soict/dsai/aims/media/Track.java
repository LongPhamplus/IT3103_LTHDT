package hust.soict.dsai.aims.media;

import hust.soict.dsai.interfaces.Playable;

public class Track implements Playable {
	
	private String title;
	private int length;
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
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
