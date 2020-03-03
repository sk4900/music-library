package control.Commands;

import model.PersonalLibrary;
import model.Playable;

public class RateRelease implements Action {

    private PersonalLibrary library;

    public void performAction(Playable playable){
        library.rateRelease(playable);

    }
}
