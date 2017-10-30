import java.util.Comparator;

public class Song implements Comparable<Song>
{
	private String artist;
	private String title;
	private String lyrics;
	
	public Song(String artist, String title, String lyrics)
	{
		this.artist = artist;
		this.title = title;
		this.lyrics = lyrics;
	}

	public String getArtist()
	{
		return artist;
	}

	public String getTitle()
	{
		return title;
	}

	public String getLyrics()
	{
		return lyrics;
	}
	
	public String toString()
	{
		return artist + ", \"" + title + "\"";
	}

	/* 
	 * the default comparison of songs
	 * primary key: artist, secondary key: title
	 * used for sorting and searching the song array
	 * if two songs have the same artist and title they are considered the same
	 */
	public int compareTo(Song song2)
	{
		if(this.artist.compareToIgnoreCase(song2.artist) != 0)
			return this.artist.compareToIgnoreCase(song2.artist);
		else if(this.title.compareToIgnoreCase(song2.title) != 0)
			return this.title.compareToIgnoreCase(song2.title);
		else
			return 0;
	}
	
	public static class CmpArtist implements Comparator<Song>
	{
		 public int compare(Song s1, Song s2)
		 {
			 if(s1.getArtist().compareToIgnoreCase(s2.getArtist()) > 0)
				 return 1;
			 else if(s1.getArtist().compareToIgnoreCase(s2.getArtist()) < 0)
				 return -1;
			 else
				 return 0;
		 }
	}
}
