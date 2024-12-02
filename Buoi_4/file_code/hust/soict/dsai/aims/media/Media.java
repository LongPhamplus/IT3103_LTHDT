package hust.soict.dsai.aims.media;

import java.util.Comparator;

import hust.soict.dsai.aims.comparator.MediaComparatorByCostTitle;
import hust.soict.dsai.aims.comparator.MediaComparatorByTitleCost;

public class Media {
	private int id;
	private String title;
	private String category;
	private double cost;
	
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public double getCost() {
		return cost;
	}
		public void setId(int id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public Media(int id, String title, String category, double cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	@Override
	public boolean equals(Object o) {
		Media media = (Media) o;
		try {
			String title = media.getTitle();
			return title.equals(this.getTitle());
		} catch (NullPointerException err) {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Media {" + "id: " + id + ", title: '" + title + "'" + ", category: '" + category + "'" + ", cost: " + cost + "}"; 
	}
}
