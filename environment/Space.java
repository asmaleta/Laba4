package laba3.environment;


import java.util.ArrayList;

public class Space implements ISpace {
    private int coordinatex;
    private int coordinatey;
    private String name ;
    private ArrayList objects;

    public Space( String name, int x, int y){
        this.coordinatex = x;
        this.coordinatey = y;
        this.name = name;
        this.objects = new ArrayList();
    }
    @Override
    public String toString() {
        return "Space [имя = " + this.getName() +", координата x= " + this.getCoordinatex() + ", координата y= " + this.getCoordinatey() + "]";
    }
    @Override
    public int hashCode(){
        int result = 5;
        result = this.getName().hashCode() * 7 + result;
        return result;
    }

    @Override
    public boolean equals (Object o){
        if (this == o) {
            return true;
        }

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Space space = (Space) o;
        return this.getCoordinatex() == space.getCoordinatex() &&
                this.getCoordinatey() == space.getCoordinatey() &&
                this.getName().equals(space.getName());
    }

    public ArrayList getObjects() {
        return objects;
    }
    public void addToSpace(Object object) {
        this.objects.add(object);
    }
    public void exitSpace(Object object) {
        this.objects.remove(object);
    }
    public int getCoordinatex() {
        return coordinatex;
    }

    public int getCoordinatey() {
        return coordinatey;
    }

    public String getName() {
        return name;
    }
}
