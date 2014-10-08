package SimpleJavaExample;

public class Song {

	String title;
	String artist;
	String style;
	String venue;
	
	Song(String t, String a, String s, String v){
		title = t;
		artist = a;
		style = s;
		venue = v;
	}
	
	public void getTitle(){
		System.out.print(title);
	}
	public void getArtist(){
		System.out.print(artist);
	}
	public void getStyle(){
		System.out.print(style);
	}
	public void getVenue(){
		System.out.print(venue);
	}
	
}
