import java.util.Comparator;

/**
 * Comparator class defining how <code>Songs</code> will be compared
 */
public class SongComparator implements Comparator<Song>
{
	public int compare(Song s1, Song s2)
	{
		if(s1.getArtist().compareToIgnoreCase(s2.getArtist()) > 0)
			return 1;
		else if(s1.getArtist().compareToIgnoreCase(s2.getArtist()) < 0)
			return -1;
		else
		{
			if(s1.getTitle().compareToIgnoreCase(s2.getTitle()) < 0)
				return -1;
			else if(s1.getTitle().compareToIgnoreCase(s2.getTitle()) > 0)
				return 1;
		}
		
		return 0;
	}
}	
