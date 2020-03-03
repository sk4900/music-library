package control.Commands;

import model.PersonalLibrary;
import model.Playable;

import java.io.IOException;

public class RemovePlayable implements Action{

    private PersonalLibrary library;

    public void performAction(Playable playable){
        try {
            library.remove(playable);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
