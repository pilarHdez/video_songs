package org.todito.music;
import java.math.BigInteger;
public class LikeTrackingServiceImpl implements LikeTrackingService{
    
    // List of all songs, to set likes the song must be in this list
    private List<Video> songs;
    
    /**
     * Set number of  likes in videoId, the video must be in the songs list
     * @param videoId identifier of video
     * @param currentLikes number of video likes
     * @param genre genre of the video
     * 
     */
    void recordLikes(String videoId, BigInteger currentLikes, String genre){
       // O(N) where N is the size list    
       songs.forEach(current -> 
            if(videoId.equals(current.getVideoId()) && genre.equals(current.getGenre()){
                current.setCurrentLikes(currentLikes);      
            }
        ); 
    }
    
    /**
     * Set number of  likes in videoId, the video must be in the songs list
     * @return list top 10 videos with most likes
     */
    List<Video> getTopLiked(){
        List<Video> top = new ArrayList<Video>();
        // O(N(Log(N)) + N) because NLogN for sorting and N to create the new List 
        // N is the size of the song list
        songs.stream().sorted().skip(this.songs.size() - 10)
        .forEach(current -> {
            top.add(current);
        });
        
        return top;
    }
    
    /**
     * @param genre genre of the song
     * @return number of likes of a genre
     */
    BigInteger getNumberOfLikesForGenre(String genre){
        BigInteger total = BigInteger.ZERO; 
        
        // O(N) where N is the size of the song list
        songs.forEach(current -> 
            if(genre.equals(current.getGenre())){
                total = total.add(BigInteger.ONE);     
            }
        ); 
        return total;
    }
}
