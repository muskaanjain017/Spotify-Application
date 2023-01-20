import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private List<Songs> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
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

    public List<Songs> getSongs() {
        return songs;
    }

    public void setSongs(List<Songs> songs) {
        this.songs = songs;
    }

    public boolean findSong(String title){
        for(Songs s : songs){
            if(s.getName().equals(title))
                return true;
        }
        return false;
    }
    void addSongtoAlbum(String title, double duration){
        Songs s = new Songs(title,duration);

        if(findSong(s.getName())==true){
            System.out.println("Song is already present in album");
        }
        else{
            songs.add(s);
            System.out.println("New Song has been added");
        }
        return;
    }

    public void addToPlaylistFromAlbum(String title, LinkedList<Songs> playlist){
        if(findSong(title)==true){
            for(Songs s: songs){
                if(s.getName().equals(title)){
                    playlist.add(s);
                    System.out.println("Song has been added to your playlist");
                    break;
                }
            }
        }
        else{
            System.out.println("Song is not present in the Album");
        }
        return;
    }
    public void addToPlaylistFromAlbum(int trackNo, LinkedList<Songs> playlist){
        int index = trackNo-1;
        if(index>=0 && index<songs.size()){
            playlist.add(songs.get(index));
            System.out.println("Song has been added to your playlist");
        }
        else{
            System.out.println("Invalid track number");
        }
        return;
    }

}
