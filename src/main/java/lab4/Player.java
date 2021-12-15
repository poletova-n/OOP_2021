package lab4;

public class Player {
    @MyAnotation(count = 3)
    void playSong(){
        System.out.println("Playing song");
    }

    @MyAnotation(count = 4)
    void nextSong(){
        System.out.println("Move to next song");
    }
    @MyAnotation
    void previousSong(){
        System.out.println("Move to previous song");
    }
}
