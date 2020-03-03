package control;

import model.Playable;

public interface PlayableHolder {
    boolean add(String[] playableData);
    String[] getRelations(String guid);
    Playable get(String guid);
}
