package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Iterator;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.interfaces.*;

public class CompactDisc extends Disc implements Playable{
	
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public void play() throws PlayerException {
		if(this.getLength() > 0) {
			// TODO Play all tracks in the CD as you have implemented
			Iterator<Track> iter = tracks.iterator();
			Track nextTrack;
			while(iter.hasNext()) {
				nextTrack = (Track) iter.next();
				try {
					nextTrack.play();
				} catch (PlayerException e) {
					throw e;
				}
			}
		}else {
			throw new PlayerException("ERROR: CD length is non-positive!");
		}
	}
	
	public String getArtist() {
		return artist;
	}
	public ArrayList<Track> getTracks() {
		return tracks;
	}
	public int getLength() {
		return tracks.size();
	}
	public CompactDisc(int id, String title, String category, double cost, String director, int length, String artist, ArrayList<Track> tracks) {
		super(id, title, category, cost, director, length);
		
		this.artist = artist;
		this.tracks = tracks;
	}


	public void addTrack(Track track) {
		if (!tracks.contains(track)) { 
			tracks.add(track);
			System.out.println("Track added: " + track.getTitle());
		} else {
			System.out.println("Track already exists: " + track.getTitle());
		}
	}

	public void removeTrack(Track track) {
	     if (tracks.contains(track)) { 
            tracks.remove(track);
            System.out.println("Track removed: " + track.getTitle());
        } else {
            System.out.println("Track not found: " + track.getTitle());
        }
    }
}
