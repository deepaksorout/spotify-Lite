import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Album a1=new Album("moosa","moosewala");
        Album a2=new Album("para","paradox");

        a1.addSongToAlbum("295",4.05);
        a1.addSongToAlbum("levels",5.00);
        a1.addSongToAlbum("so high",4.30);
        a1.addSongToAlbum("goat",4.25);

        a2.addSongToAlbum("jaadugar",4.50);
        a2.addSongToAlbum("rihaayi",4.55);
        a2.addSongToAlbum("glitch",4.35);
        a2.addSongToAlbum("chhore NCR Aale",5.25);

        LinkedList<song> playlist1=new LinkedList<>();

        a1.addSongToPlaylist("295",playlist1);
        a2.addSongToPlaylist("jaadugar",playlist1);
        a1.addSongToPlaylist(4,playlist1);
        a1.addSongToPlaylist(3,playlist1);
        a2.addSongToPlaylist(4,playlist1);

        play(playlist1);
    }
    public static void play(LinkedList<song> playlist){
        ListIterator<song> itr=playlist.listIterator();

        Scanner sc=new Scanner(System.in);
        boolean isforward=false;

        if(playlist.size()>0){
            System.out.println("currently playing");
            System.out.println(itr.next());
            isforward=true;
        }
        else{
            System.out.println("playlist is empty");
            return;
        }
        System.out.println("Enter your choice : ");
        printMenu();

        boolean quit=false;
        while(!quit){
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    if(isforward==false){
                        itr.next();
                        isforward=true;
                    }
                    if(itr.hasNext()){
                        System.out.println(itr.next());
                    }
                    else{
                        System.out.println("you have reached end of the playlist");
                    }
                    break;
                case 2:
                    if(isforward==true){
                        itr.previous();
                        isforward=false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println(itr.previous());
                    }
                    else{
                        System.out.println("you are at the start of the playlist");
                    }
                    break;
                case 3:
                    if(isforward==true){
                        if(itr.hasPrevious())
                            System.out.println(itr.previous());
                        else
                            System.out.println("song does not exist");

                        isforward=false;
                    }
                    else{
                        if(itr.hasNext())
                            System.out.println(itr.next());
                        else
                            System.out.println("song does not exist");

                        isforward=true;
                    }
                    break;
                case 4:
                    printMenu();
                    break;
                case 5:
                    break;
                case 6:
                    printsongs(playlist);
                    break;
                case 7:
                    quit=true;
                    break;
            }
        }
    }

    public static void printsongs(LinkedList<song> playlist){
        for(song s:playlist){
            System.out.println(s);
        }
        return;
    }
    public static void printMenu(){
        System.out.println("1 - play next song");
        System.out.println("2 - play previous song");
        System.out.println("3 - repeat the current song");
        System.out.println("4 - show menu again");
        System.out.println("5 - delete the current song");
        System.out.println("6 - print all songs in playlist");
        System.out.println("7 - exit");
    }
}