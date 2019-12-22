package laba4.environment;

import laba4.creatures.Character;
import laba4.creatures.IDunamic;
import laba4.creatures.Rat;

public class Item implements IDunamic {

    private Space space;
    private String name;

   public Item(String name, Space space){
       this.name = name;
       this.setSpace(space);
    }


    @Override
    public void changeSpace(Space space) {
        getSpace().exitSpace(this);
        this.setSpace(space);
    }

    @Override
    public Space getSpace() {
        return space;
    }

    @Override
    public void setSpace(Space space) {
        space.addToSpace(this);
        this.space = space;
    }

    @Override
    public String getName() {
        return name;
    }
}
