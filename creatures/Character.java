package laba4.creatures;


import laba4.environment.IStatic;
import laba4.environment.Space;
import laba4.exceptions.NegativeAgeExeption;
import laba4.exceptions.NoLookAtYouselfExeption;

import java.util.ArrayList;

public abstract class Character implements laba4.creatures.IDunamic {

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
    private ArrayList<IDunamic> things = new ArrayList();
    private Gender smbdGender;
    private TypeOfSkin type;
    private Color col;
    private String name;
    private int age;
    private Direction dir;
    private Space space;

    public Character(String name, int age, Gender smbdGender, Color col, TypeOfSkin type, Space space, Direction dir) {
        this.setSpace(space);
        this.name = name;
        this.smbdGender = smbdGender;
        this.col = col;
        this.type = type;
        this.dir = dir;
        if (age > -1){
            this.age = age;
        }
        else {
            throw new NegativeAgeExeption("возраст не может быть отрицаткльным");
        }
    }

    public Character(String name, int age, Gender smbdGender, Direction dir, Space space) {
        this.name = name;
        this.smbdGender = smbdGender;
        this.dir = dir;
        this.setSpace(space);
        if (age > -1){
            this.age = age;
        }
        else {
            throw new NegativeAgeExeption("возраст не может быть отрицаткльным");
        }
    }
    public Character(String name, int age, Gender smbdGender, Direction dir, Space space, IDunamic... things ) {
        this.name = name;
        this.smbdGender = smbdGender;
        this.dir = dir;
        this.setSpace(space);
        for(IDunamic obj : things) {
            this.things.add(obj);
        }
        if (age > -1){
            this.age = age;
        }
        else {
            throw new NegativeAgeExeption("возраст не может быть отрицаткльным");
        }
    }
    public Character(String name, int age, Gender smbdGender, Color col, TypeOfSkin type, Space space, Direction dir, IDunamic... things) {
        this.name = name;
        this.smbdGender = smbdGender;
        this.col = col;
        this.type = type;
        this.dir = dir;
        this.setSpace(space);
        for(IDunamic obj : things) {
            this.things.add(obj);
        }
        if (age > -1){
            this.age = age;
        }
        else {
            throw new NegativeAgeExeption("возраст не может быть отрицаткльным");
        }
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

    public void watch(Character object) throws NoLookAtYouselfExeption {
        if (object.equals(this))
        {
            throw new  NoLookAtYouselfExeption("Ошибка! Нельзя посмотреть на себя");
        }

        if (this.watchNowThisObject(object)) {
            System.out.println("Персонаж " + this.getName() + " посмотрел на персонажа " + object.getName());
        } else {
            this.dir = dir.inverseDirection(object.dir);
            this.watch(object);
        }
    }
    public void watch(IDunamic object) {
            System.out.println("Персонаж " + this.getName() + " посмотрел на  " + object.getName());
    }

    public boolean watchNowThisObject(Character object) {
        return this.dir == dir.inverseDirection(object.dir);
    }

    public void sit (boolean sit ,Space space){
        if (sit){
            System.out.println(this.getName() + " сел в место " + space.getName());
        }
        else{
            System.out.println(this.getName() + " не сел в место " + space.getName());
        }
    }

    public void go(Space space) {
        changeSpace(space);
    }

    public void changeSpace(Space space) {
        getSpace().exitSpace(this);
        this.setSpace(space);
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
        space.addToSpace(this);
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

    public ArrayList<IDunamic> getThings() {
        return things;
    }
    public void addThing(IDunamic thing) {
        this.things.add(thing);
    }
    public void takeThing(IDunamic thing) {
        this.addThing(thing);
        System.out.println(this.getName() + " взял " + thing.getName());
    }
    public void devNullThings() {
        this.things = new ArrayList<IDunamic>();
    }
    public void deleteThing(IDunamic thing) {
        this.things.remove(thing);
    }
    public void putThing(IDunamic thing, Space space) {
        this.deleteThing(thing);
        System.out.println(this.getName() + " положил " + thing.getName() +" в место : "+ space.getName());
    }
}
