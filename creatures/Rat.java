package laba3.creatures;

import laba3.environment.Space;
import laba3.environment.Light;
import sun.font.TrueTypeFont;

import java.util.ArrayList;

public class Rat extends Character {

    //
    public Rat(String name, int age, Gender smbdGender, Color col, TypeOfSkin type, Space space, Direction dir) {
        //
        super(name, age, smbdGender, col, type, space, dir);
        //
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
        result = this.getAge() * 7 + result;
        result = this.getCol().hashCode() * 7 + result;
        result = this.getSmbdGender().hashCode() * 7 + result;
        result = this.getType().hashCode() * 7 + result;
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
        return this.getCoordinatex() == rat.getCoordinatex() &&
                this.getCoordinatey() == rat.getCoordinatey() &&
                this.getName().equals(rat.getName());
    }

    @Override
    public void go(Space space) {
        ArrayList objects = this.getSpace().getObjects();
        Boolean goAwayFromDark = true;
        for (Object obj : objects) {
            if (obj instanceof Light){ goAwayFromDark = false; }
        }
        if (goAwayFromDark){
            System.out.println(this.getName() + " отделилась от темного " + this.getSpace().getName() );
        }
        System.out.println(this.getName() + " движется и шаркает");
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

}