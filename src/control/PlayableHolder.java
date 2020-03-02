package control;

import model.Playable;

public interface PlayableHolder {
    boolean add(String[] playableData);
    public Playable get(String guid);
}
