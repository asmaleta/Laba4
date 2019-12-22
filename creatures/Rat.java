package laba4.creatures;

import laba4.environment.IStatic;
import laba4.environment.Item;
import laba4.environment.Space;
import laba4.environment.Light;
import laba4.exceptions.NoLookAtYouselfExeption;

import java.util.ArrayList;

public class Rat extends Character {

    private Pocket pocket;

    public Rat(String name, int age, Gender smbdGender, Color col, TypeOfSkin type, Space space, Direction dir, String namePocet) {
        super(name, age, smbdGender, col, type, space, dir);
        this.pocket = new Pocket(namePocet);
    }
    public Rat(String name, int age, Gender smbdGender, Color col, TypeOfSkin type, Space space, Direction dir, String namePocet, IDunamic ... things) {
        super(name, age, smbdGender, col, type, space, dir);
        this.pocket = new Pocket(namePocet);
        for(IDunamic obj : things) {
            this.getPocket().getThings().add(obj);
        }

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



    public final void watchEvil (Character... smbd) throws NoLookAtYouselfExeption {
        for (Character i: smbd){
            if (i.equals(this)){
                throw new  NoLookAtYouselfExeption("Ошибка! Нельзя посмотреть на себя");
            }
        }
        for (Character i: smbd) {
            System.out.println(this.getName() + " злобно посмотрела на " + i.getName());
        }
    }


    public final void blink (Light ray) {

            System.out.println(this.getName() + " моргает от " + ray.getName());

    }

        public final void shake (String name)
        {
            class ShakeObject {
                private String name;
                ShakeObject (String name){
                    this.name = name;
                }

                public String getName() {
                    return name;
                }
            }
            System.out.println(this.getName() + " трясет " + (new ShakeObject(name)).getName());
        }

    public Pocket getPocket() {
        return pocket;
    }

    public void putInPocket (IDunamic thing) {
        this.getPocket().deleteThing(thing);
        System.out.println(this.getName() + " сунула " + thing.getName() +" в "+ getPocket().getName());
    }
    public void takeOutOfPocet(IDunamic thing) {
        this.getPocket().addThing(thing);
        System.out.println(this.getName() + " взял из "+ getPocket().getName() + thing.getName());
    }

    public void searchItem (Space space, Item item) {
        ISight iSight = new ISight() {
            @Override
            public void sight(ArrayList<Item> items) {
                System.out.println("Взгляд блуждает по " + space.getName());
                for (Object obj: items) {
                    if (obj instanceof Item && (((Item) obj).getName().equals(item.getName()))) {
                        System.out.println("Взгляд остановился на " + item.getName());
                        break;
                    }
                }
            }
        };
        iSight.sight(space.getObjects());
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
        public Pocket(String name) {
            this.name = name;
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