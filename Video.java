/*
* Class for video songs
*/
package org.todito.music;
import java.math.BigInteger;
public class Video{
    private String videoId;
    private BigInteger currentLikes;
    private String genre;
    
    public Video(String videoId, BigInteger currentLikes, String genre){
        this.videoId = videoId; 
        this.currentLikes = currentLikes; 
        this.genre = genre;
    }

    public String getVideoId(){
        return this.videoId;
    }
    
    public void setVideoId(String videoId){
        this.videoId = videoId;
    }
    
    public BigInteger getCurrentLikes(){
        return this.currentLikes;
    }
    
    public void setCurrentLikes(BigInteger currentLikes){
        this.currentLikes = currentLikes;
    }
    
    public String getGenre(){
        return this.genre;
    }
    
    public void setGenre(String genre){
        this.genre = genre;
    }
}
