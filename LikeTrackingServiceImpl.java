package org.todito.music; 
import java.util.*; 
import java.math.BigInteger; 

public class LikeTrackingServiceImpl implements LikeTrackingService{

    // Queue with all the songs
    private PriorityQueue<Video> songs; 
    // Map to count the total of genre visited
    private HashMap<String, BigInteger> genreCount;
    
    // Limit top songs
    private static final int LIMIT_TOP = 10;

    // Dependency injection to the service
    public LikeTrackingServiceImpl(PriorityQueue<Video> songs, HashMap<String, BigInteger> genreCount){
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
        // O(logN) where N is the element in the Queue
        // Add song with the current likes
        this.songs.add(new Video(videoId, currentLikes));
        
        // O(1) update counter for the genre
        // Add 1 to the counter for genre
        this.genreCount.put(genre, this.genreCount.get(genre) != null ? BigInteger.ONE : this.genreCount.get(genre).add(BigInteger.ONE));
    }
    
    /**
     * @return list top 10 videos with most likes
    */
    synchronized List<String> getTopLiked(){
        
        List<String> topSongs = new ArrayList<String>;

        // O(1O log N) where N is the elements in the Queue
        Iterator itr = this.songs.iterator();
        for(int i= 0; i<LIMIT_TOP; i++){
            topSongs.add(itr.next().getVideoId());
        }

        return topSongs;
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
