package laba3.creatures;


import laba3.environment.Space;

public abstract class Character implements ILiving {

    public enum Gender {MALE, FEMALE};
    public enum Direction {NORTH, SOUTH, EAST, WEST};
    public enum Color {GREY, YELLOW, RED, BLACK, WHITE, GREEN, BROWN};
    public enum TypeOfSkin {SHRIVELED, SMOOTH};

    private Gender smbdGender;
    private TypeOfSkin type;
    private Color col;
    private String name;
    private int age;
    private Direction dir;
    private Space space;

    public Character(String name, int age, Gender smbdGender, Color col, TypeOfSkin type, Space space,  Direction dir )
    {
        this.space = space;
        this.name = name;
        this.age = age;
        this.smbdGender = smbdGender;
        this.col = col;
        this.type = type;
        this.dir = dir;
    }

    public Character(String name, int age, Gender smbdGender, Direction dir,Space space )
    {
        this.name = name;
        this.age = age;
        this.smbdGender = smbdGender;
        this.dir = dir;
        this.space = space;
    }

    public void setDir (Direction dir) {
        this.dir = dir;
        System.out.println("Персонаж " + this.getName() + " обернулся");
    }
    public int getAge() {
        return age;
    }
    public Gender getSmbdGender() {
        return smbdGender;
    }
    public Direction getDir(){
        return dir;
    }
    public String getName() {

        return name;
    }

    public final void watch (Character object) {
        if (this.watchNowThisObject(object)) {
            System.out.println("Персонаж " + this.getName() + " посмотрел на персонажа " + object.getName());
        }
        else {
            this.changeDirInvertArgument(object);
            this.watch(object);
        }
    }

    public void changeDirInvertArgument (Character object) {
        if (object.dir == Direction.EAST) { this.setDir(Direction.WEST); }
        if (object.dir == Direction.WEST) { this.setDir(Direction.EAST); }
        if (object.dir == Direction.NORTH) { this.setDir(Direction.SOUTH); }
        if (object.dir == Direction.SOUTH) { this.setDir(Direction.NORTH); }
    }

    public boolean watchNowThisObject (Character object) {
        if (object.dir==Direction.EAST && this.dir==Direction.WEST || object.dir == Direction.WEST &&
                this.dir == Direction.EAST || object.dir == Direction.NORTH &&
                this.dir == Direction.SOUTH || object.dir == Direction.SOUTH &&
                this.dir == Direction.NORTH) {
            return true;
        }
        return false;
    }


    public final void go (Space centerOfRoom) {
        if (this.space.getCoordinatex() == centerOfRoom.getCoordinatex()) {
            this.space = centerOfRoom;
            System.out.println(this.getName() + " движется вдоль стены");
        } else {
            this.space = centerOfRoom;
            System.out.println(this.getName() + " отделилась от стены");
        }
    }
    public Color getCol(){
        return col;
    }

    public TypeOfSkin getType() {
        return type;
    }

    public Space getSpace() {
        return space;
    }

    public void moveToSpace(Space space){
        this.space = space;
        System.out.println(this.getName()+" переместился в " + space.getName());

    }

    @Override
     public void setSpace(Space space) {

        this.space = space;
    }

    @Override
    public int getCoordinatex() {
        return space.getCoordinatex();
    }

    @Override
    public int getCoordinatey() {
        return space.getCoordinatey();
    }
}
