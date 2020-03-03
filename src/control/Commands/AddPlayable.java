package control.Commands;

import model.PersonalLibrary;
import model.Playable;

public class AddPlayable implements Action {
    private PersonalLibrary library;
    private Playable playable;
    public AddPlayable(Playable playable){
        this.playable = playable;
    }
    public void performAction() {
        library.add(playable);
    }
}
