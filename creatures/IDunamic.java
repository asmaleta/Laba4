package laba4.creatures;

import laba4.environment.IStatic;
import laba4.environment.Space;

public interface IDunamic extends IStatic {
    void changeSpace(Space space);
    void setSpace(Space space);
    Space getSpace();
}
