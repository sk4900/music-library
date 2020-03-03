package control.Commands;

import model.PersonalLibrary;
import model.Playable;

public class AddPlayable implements Action {
    private PersonalLibrary library;

    public void performAction(Playable playable) {
        library.add(playable);
    }
}
