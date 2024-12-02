package hust.soict.dsai.aims.comparator;

import java.util.Comparator;

import hust.soict.dsai.aims.media.Media;

public class MediaComparatorByTitleCost implements Comparator<Media>{
	
	@Override
	public int compare(Media obj1, Media obj2) {
		try {
			if (obj1.getTitle().compareTo(obj2.getTitle()) > 0) {
				return -1;
			} else if (obj1.getTitle().compareTo(obj2.getTitle()) < 0) {
				return 1;
			} else {
				if (obj1.getCost() > obj2.getCost()) {
					return -1;
				} else if (obj1.getCost() < obj2.getCost()){
					return 1;
				}
			}
		} catch (NullPointerException err) {
			if (obj1.getTitle() == null && obj2.getTitle() == null) {
				return -1;
			}
			if (obj1.getTitle() != null && obj2.getTitle() == null) {
				return -1;
			}
			if (obj1.getTitle() == null && obj2.getTitle() != null) {
				return 1;
			}
		}
		return 0;
	}
}
