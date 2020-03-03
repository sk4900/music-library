package control.Commands;

import model.PersonalLibrary;
import model.Playable;

public class RateRelease implements Action {
    private Playable playable;
    private PersonalLibrary library;
    public RateRelease(Playable playable){
        this.playable = playable;
    }
    public void performAction(){
        library.rateRelease(playable);

    }
}
