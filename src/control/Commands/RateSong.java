package control.Commands;

import model.PersonalLibrary;
import model.Playable;

public class RateSong implements Action{
    private PersonalLibrary library;
    private int rating;
    public RateSong(PersonalLibrary library, int rating){
        this.library = library;
    }
    public void performAction(Playable playable) {
        library.rateSong(rating, playable);
    }
}
