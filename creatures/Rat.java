package laba3.creatures;

import laba3.environment.IStatic;
import laba3.environment.Space;
import laba3.environment.Light;

import java.util.ArrayList;

public class Rat extends Character {

    public Pocket pocket = new Pocket("карман");

    public Rat(String name, int age, Gender smbdGender, Color col, TypeOfSkin type, Space space, Direction dir) {
        super(name, age, smbdGender, col, type, space, dir);
    }

    @Override
    public String toString() {
        return "Rat [имя = " + this.getName() + ", возраст = " + this.getAge() + ", пол = " + this.getSmbdGender() + ", смотрит на  " +
                this.getDir() + ", цвет = " + this.getCol() + ", выглядит  " +
                this.getType() + ", находится " + this.getSpace() + "]";
    }

    @Override
    public int hashCode() {
        int result = 5;
        result = this.getName().hashCode() * 7 + result;
        result = this.getCol().hashCode() * 7 + result;
        result = this.getSmbdGender().hashCode() * 7 + result;
        result = this.getType().hashCode() * 7 + result;
        result = this.getAge() + result;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Rat rat = (Rat) o;
        return this.getSmbdGender() == rat.getSmbdGender() &&
                this.getAge() == rat.getAge() &&
                this.getName().equals(rat.getName()) &&
                this.getCol() == rat.getCol() &&
                this.getType() == rat.getType();
    }


    @Override
    public void go(Space space) {
        ArrayList objects = this.getSpace().getObjects();
        Boolean goAwayFromDark = true;

        for (Object obj : objects) {
            if (obj instanceof Light){
                goAwayFromDark = false;
            }
        }

        if (goAwayFromDark){
            System.out.println(this.getName() + " отделилась от темного " + this.getSpace().getName() );
        }

        System.out.println(this.getName() + " движется и шаркает к " + space.getName() );
        changeSpace(space);
        objects = space.getObjects();

        for (Object obj : objects) {
            if (obj instanceof Light){
                this.blink((Light) obj);
            }
        }

}



    public final void watchEvil (Character... smbd){
        for (Character i: smbd) {
            System.out.println(this.getName() + " злобно посмотрела на " + i.getName());
        }
    }


    public final void blink (Light ray) {
            System.out.println(this.getName() + " моргает от " + ray.getName());

    }

        public final void shake ()
        {
            System.out.println(this.getName() + " трясет усами");
        }
    public void putInPocket (IDunamic thing, Pocket pocket) {
        this.deleteThing(thing);
        System.out.println(this.getName() + " положил " + thing.getName() +" в "+ pocket.getName());
    }
    public void takeOutOfPocet(IDunamic thing) {
        this.addThing(thing);
        System.out.println(this.getName() + " взял из  " + thing.getName());
    }

    public static class Pocket implements IStatic {
        private String name;
        private ArrayList<IDunamic> things = new ArrayList ();
        public Pocket(String name, IDunamic ... things) {
            this.name = name;
            for(IDunamic obj : things) {
                this.things.add(obj);
            }
        }

        @Override
        public String toString() {
            return this.getName();
        }

        public String getName() {
            return name;
        }

        public ArrayList<IDunamic> getThings() {
            return things;
        }
        public void addThing(IDunamic thing) {
            this.things.add(thing);
        }

        public void devNullThings() {
            this.things = new ArrayList<IDunamic>();
        }
        public void deleteThing(IDunamic thing) {
            this.things.remove(thing);
        }


    }

}