package laba3.creatures;

import laba3.environment.IStatic;
import laba3.environment.Space;

public interface IDunamic extends IStatic {
    void changeSpace(Space space);
    void setSpace(Space space);
    Space getSpace();
}
