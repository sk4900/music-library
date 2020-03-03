package control.Commands;

import model.PersonalLibrary;
import model.Playable;

public class RateSong implements Action{
    private int rating;
    private PersonalLibrary library;
    public RateSong(int rating){
        this.rating = rating;
    }
    @Override
    public void performAction(Playable playable) {
        library.rateSong(rating, playable);
    }
}
