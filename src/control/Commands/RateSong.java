package control.Commands;

import model.PersonalLibrary;
import model.Playable;

public class RateSong implements Action{
    private int rating;
    private PersonalLibrary library;
    private Playable playable;
    public RateSong(Playable playable, int rating){
        this.rating = rating;
        this.playable = playable;
    }
    public void performAction() {
        library.rateSong(rating, playable);
    }
}
