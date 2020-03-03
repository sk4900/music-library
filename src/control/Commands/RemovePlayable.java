package control.Commands;

import model.PersonalLibrary;
import model.Playable;

import java.io.IOException;

public class RemovePlayable implements Action{
    private Playable playable;
    private PersonalLibrary library;

    public RemovePlayable(Playable playable){
        this.playable = playable;
    }
    public void performAction(){
        try {
            library.remove(playable);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
