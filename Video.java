/*
* Class for video songs
*/
package org.todito.music;
import java.math.BigInteger;
public class Video implements Comparable<Video>{
    private String videoId;
    private BigInteger currentLikes;
    
    public Video(String videoId, BigInteger currentLikes){
        this.videoId = videoId; 
        this.currentLikes = currentLikes; 
    }

    @Override
    public int compareTo(Video v) {
        // to get an ascending queue 
        return this.currentLikes.compareTo(v.currentLikes) * -1;
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
    
}
