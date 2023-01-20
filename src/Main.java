import java.util.*;

public class Main {
    public static List<Album> albums = new ArrayList<>();
    public static void main(String[] args) {
        Album album1 = new Album("Atif's Songs", "Atif Aslam");
        album1.addSongtoAlbum("Dil Meri Na Sune", 5.6);
        album1.addSongtoAlbum("Tera Hoga Hoon", 6);
        album1.addSongtoAlbum("Tere Sang Yaara", 6.5);

        Album album2 = new Album("Arijit's Songs", "Arijit Singh");
        album2.addSongtoAlbum("Sunn raha h tu", 4);
        album2.addSongtoAlbum("Galti Se Mistake", 3.8);
        album2.addSongtoAlbum("Naina", 5.8);

        albums.add(album1);
        albums.add(album2);

        System.out.println(album1.findSong("Tere Sang Yaara"));

        LinkedList<Songs> myPlayList = new LinkedList<>();
        album2.addToPlaylistFromAlbum(2, myPlayList);
        album2.addToPlaylistFromAlbum(1, myPlayList);
        album1.addToPlaylistFromAlbum("Dil Meri Na Sune", myPlayList);
        album1.addToPlaylistFromAlbum("Tera Hoga Hoon", myPlayList);

        play(myPlayList);
    }

    public static void play(LinkedList<Songs> playList){
        Scanner sc = new Scanner(System.in);
        ListIterator<Songs> itr = playList.listIterator();

        boolean isForward = false;

        if(playList.size()>0){
            System.out.print("You are currently playing: ");
            System.out.println(itr.next());
            isForward = true;
        }
        else{
            System.out.println("List is empty");
            return;
        }

        System.out.println("Enter your choice");
        printMenu();
        boolean quit = false;
        while(quit!=true){
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    if(isForward==false){
                        itr.next();
                        isForward = true;
                    }
                    if(itr.hasNext()){
                        System.out.println(itr.next());
                    }
                    else{
                        System.out.println("You are at the end of your playlist");
//                        isForward = false;
                    }
                    break;
                case 2:
                    if(isForward==true){
                        itr.previous();
                        isForward=false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println(itr.previous());
                    }
                    else{
                        System.out.println("You are at the start of your playlist");
//                        isForward = true;
                    }
                    break;
                case 3:
                    if(isForward == true) {
                        if(itr.hasPrevious()==true) {  // not required to check if always true
                            System.out.println(itr.previous());
                            isForward = false;
                        }
                    }
                    else{
                        if(itr.hasNext()==true){ // not required to check if always true
                            System.out.println(itr.next());
                            isForward=true;
                        }
                    }
                    break;
                case 4:
                    printMenu();
                    break;
                case 5:
                    if(playList.size()<0){
                        System.out.println("Your Playlist is empty");
                    }
                    else{
//                        if (isForward == true) {
//                            if (itr.hasPrevious()) {
//                                playList.remove(itr.previous());
                                System.out.println("Your current song is deleted");
                                itr.remove();
//                            }
//                            else {
//                                System.out.println("You don't have any current song");
//                            }
//                        } else {
//                            if (itr.hasNext()) {
//                                playList.remove(itr.next());
//                                System.out.println("Your current song is deleted");
//                                itr.remove();
//                            }
//                            else {
//                                System.out.println("You don't have any current song");
//                            }
//                        }
                    }
                    break;
                case 6:
                    for(Songs s : playList){
                        System.out.println(s);
                    }
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }
    }
    public static void printMenu(){
        System.out.println("1 - Play next song");
        System.out.println("2 - Play previous song");
        System.out.println("3 - Repeat current song");
        System.out.println("4 - Show menu again");
        System.out.println("5 - Delete the current song");
        System.out.println("6 - Print all the songs in playlist");
        System.out.println("7 - Exit");


    }

}