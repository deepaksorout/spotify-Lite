import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private List<song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<song> getSongs() {
        return songs;
    }

    public void setSongs(List<song> songs) {
        this.songs = songs;
    }
    public boolean findSong(String title){
        for(song s:songs){
            if(s.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }
    public void addSongToAlbum(String title,double duration){
        song s1=new song(title,duration);
        if(findSong(title)==true){
            System.out.println("song is already present ");
        }
        else{
            songs.add(s1);
            System.out.println("New song added");
        }
        return;
    }
    public void addSongToPlaylist(String title, LinkedList<song> playlist){
        if(findSong(title)==true){
            for(song s:songs){
                if(s.getTitle().equals(title)){
                    playlist.add(s);
                    System.out.println("song added to playlist");
                    return;
                }
            }
        }
        else{
            System.out.println("song is not present in the album");
        }
        return;
    }
    public void addSongToPlaylist(int track,LinkedList<song> playlist){
        int index=track-1;
        if(index>0 && index<songs.size()){
            playlist.add(songs.get(index));
            System.out.println("song is added to playlist");
        }
        else{
            System.out.println("invalid track no.");
        }
        return ;
    }
}
