package laba3.creatures;


import laba3.environment.Space;

public abstract class Character implements IDunamic {

    public enum Gender {MALE, FEMALE}

    ;

    public enum Direction {
        NORTH,
        SOUTH,
        EAST,
        WEST;

        public Direction inverseDirection(Direction dir) {
            switch (dir) {
                case EAST:
                    return WEST;
                case WEST:
                    return EAST;
                case NORTH:
                    return SOUTH;
                case SOUTH:
                    return NORTH;
                default:
                    return NORTH;
            }
        }
    }

    public enum Color {GREY, YELLOW, RED, BLACK, WHITE, GREEN, BROWN}

    ;

    public enum TypeOfSkin {SHRIVELED, SMOOTH}

    ;

    private Gender smbdGender;
    private TypeOfSkin type;
    private Color col;
    private String name;
    private int age;
    private Direction dir;
    private Space space;

    public Character(String name, int age, Gender smbdGender, Color col, TypeOfSkin type, Space space, Direction dir) {
        this.space = space;
        this.name = name;
        this.age = age;
        this.smbdGender = smbdGender;
        this.col = col;
        this.type = type;
        this.dir = dir;
    }

    public Character(String name, int age, Gender smbdGender, Direction dir, Space space) {
        this.name = name;
        this.age = age;
        this.smbdGender = smbdGender;
        this.dir = dir;
        this.space = space;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
        System.out.println("Персонаж " + this.getName() + " обернулся");
    }

    public int getAge() {
        return age;
    }

    public Gender getSmbdGender() {
        return smbdGender;
    }

    public Direction getDir() {
        return dir;
    }

    public String getName() {

        return name;
    }

    public final void watch(Character object) {
        if (this.watchNowThisObject(object)) {
            System.out.println("Персонаж " + this.getName() + " посмотрел на персонажа " + object.getName());
        } else {
            this.dir = dir.inverseDirection(object.dir);
            this.watch(object);
        }
    }

    public boolean watchNowThisObject(Character object) {
        return this.dir == dir.inverseDirection(object.dir);
    }


    public void go(Space space) {
        changeSpace(space);
    }

    public void changeSpace(Space space) {
        getSpace().exitSpace(this);
        this.setSpace(space);
        space.addToSpace(this);
    }

    public Color getCol() {
        return col;
    }

    public TypeOfSkin getType() {
        return type;
    }

    public Space getSpace() {
        return space;
    }


    @Override
    public void setSpace(Space space) {

        this.space = space;
    }

    @Override
    public int getCoordinatex() {
        return getSpace().getCoordinatex();
    }

    @Override
    public int getCoordinatey() {
        return getSpace().getCoordinatey();
    }
}
