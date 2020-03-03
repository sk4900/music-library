package control.Commands;

import model.Playable;

public interface Action {
    void performAction(Playable playable);
}
