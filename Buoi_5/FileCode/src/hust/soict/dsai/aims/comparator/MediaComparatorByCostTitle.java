package hust.soict.dsai.aims.comparator;

import java.util.Comparator;

import hust.soict.dsai.aims.media.Media;

public class MediaComparatorByCostTitle implements Comparator<Media>{
	@Override
	public int compare(Media obj1, Media obj2) {
		if (obj1.getCost() > obj2.getCost()) {
			return -1;
		} else if (obj1.getCost() < obj2.getCost() ) {
			return 1;
		} else {
			if (obj1.getTitle() != null && obj2.getTitle() != null) {
				return -obj1.getTitle().compareTo(obj2.getTitle());
			}
			if (obj1.getTitle() == null && obj2.getTitle() != null) {
				return 1;
			}
			if (obj1.getTitle() != null && obj2.getTitle() == null) {
				return -1;
			}
			return 0;
		}
	}
}
