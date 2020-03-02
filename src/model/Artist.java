package model;

import com.sun.istack.internal.Nullable;

public class Artist implements Playable{
    private String guid, name, disamb;

    public Artist(String id, String artistName, @Nullable String desc) {
        guid = id;
        name = artistName;
        disamb = desc;
    }

    public String getGUID() {return guid;}

    public String getName() {return name;}


}
