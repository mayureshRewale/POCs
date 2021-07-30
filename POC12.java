import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.week2.Emp;

class Movies{
	double rateing;
	String name;
	int year;
	
	public Movies(double rate, String name, int year) {
		super();
		this.rateing = rate;
		this.name = name;
		this.year = year;
	}
	
}

class RateComp implements Comparator<Movies>{

	@Override
	public int compare(Movies o1, Movies o2) {
		
		if (o1.rateing < o2.rateing)
			return -1;
		else if (o1.rateing > o2.rateing)
			return 1;
		else
			return 0;
		
	}
	
}

class NameComp implements Comparator<Movies>{

	@Override
	public int compare(Movies o1, Movies o2) {
		return o1.name.compareTo(o2.name);
	}
	
}

class YearComp implements Comparator<Movies>{

	@Override
	public int compare(Movies o1, Movies o2) {
		
		if (o1.year < o2.year)
			return -1;
		else if (o1.year > o2.year)
			return 1;
		else
			return 0;
		
	}
	
}

class RevYear implements Comparator<Movies>{

	@Override
	public int compare(Movies o1, Movies o2) {
		
		if (o1.year > o2.year)
			return -1;
		else if (o1.year < o2.year)
			return 1;
		else
			return 0;
		
	}
	
}

public class POC12 {

	public static void main(String[] args) {
		
		ArrayList<Movies> movie = new ArrayList<Movies>();
		movie.add(new Movies(5.6, "Voyager", 2012));
		movie.add(new Movies(8.6, "Imitation Game", 2010));
		movie.add(new Movies(6.4, "Avengers", 2013));
		movie.add(new Movies(7.4, "BlackWidow", 2021));
		movie.add(new Movies(8.8, "John Wick", 2011));
		
		System.out.println("Sort by Ratings");
		Collections.sort(movie, new RateComp());
		for(Movies mo : movie)
			System.out.println(mo.name + " ------------ " + mo.rateing + " ------------ " + mo.year);
		
		System.out.println("------------------------------------------------------------------------------------");
		
		System.out.println("Sort by Name");
		Collections.sort(movie, new NameComp());
		for(Movies mo : movie)
			System.out.println(mo.name + " ------------ " + mo.rateing + " ------------ " + mo.year);
		
		System.out.println("------------------------------------------------------------------------------------");
		
		System.out.println("Sort by Year");
		Collections.sort(movie, new YearComp());
		for(Movies mo : movie)
			System.out.println(mo.name + " ------------ " + mo.rateing + " ------------ " + mo.year);
		
		System.out.println("------------------------------------------------------------------------------------");
		
		System.out.println("Revesre Sort by Year");
		Collections.sort(movie, new RevYear());
		for(Movies mo : movie)
			System.out.println(mo.name + " ------------ " + mo.rateing + " ------------ " + mo.year);
		
		System.out.println("------------------------------------------------------------------------------------");
		
	}

}
