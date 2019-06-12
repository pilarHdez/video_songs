package org.todito.music; 
import java.math.BigInteger; 

public class LikeTrackingServiceImpl implements LikeTrackingService{

    // Tree with all the songs
    private TreeMap<String, BigInteger> songs; 
    // Map to count the total of genre visited
    private HashMap<String, BigInteger> genreCount;
    
    // Limit top songs
    private static final int LIMIT_TOP = 10;

    // Dependency injection to the service
    public LikeTrackingServiceImpl(TreeMap<String, BigInteger> songs, HashMap<String, BigInteger> genreCount){
        this.songs = songs; 
        this.genreCount = genreCount;
    }
    
    /**
    * Set number of likes for the songs tree 
    * @param videoId id for the video 
    * @param currentLikes number of video likes 
    * @param genre genre of the video
    */
    synchronized void recordLikes(String videoId, BigInteger currentLikes, String genre){
        // O(NlogN) where N is the element in the Tree
        // Add song with the current likes
        this.songs.put(videoId, currentLikes);
        
        // O(1) update counter for the genre
        // Add 1 to the counter for genre
        this.genreCount.put(genre, this.genreCount.get(genre) != null ? BigInteger.ONE : this.genreCount.get(genre).add(BigInteger.ONE));
    }
    
    /**
     * @return list top 10 videos with most likes
    */
    synchronized List<String> getTopLiked(){
        // O(N) where N is the number of elements in the Tree
        return this.songs.keySet().stream().limit(LIMIT_TOP).collect(Collectors.toCollection(ArrayList::new));
    }
    
    
    /**
     * @genre of the song 
     * @return number of likes of a genre
    */
    synchronized BigInteger getNumberOfLikesForGenre(String genre){
        // O(1) get the counter for genre
        return this.genreCount.get(genre) != null ? this.genreCount.get(genre) : BigInteger.ZERO;
    }

}
