package control.Commands;

import model.Playable;

public class Command {
    private Action action;
    public Command(Action action) {
        this.action = action;
    }
    public void commandRequest(Playable playable){
        action.performAction(playable);
    }
}

