package control.Commands;

import model.Playable;

public class Command {
    private Action action;
    private Playable playable;

    public Command(Action action, Playable playable) {
        this.action = action;
        this.playable = playable;
    }
    public void commandRequest(){
        action.performAction();
    }
}

