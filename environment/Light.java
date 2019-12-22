package laba4.environment;

public class Light implements IStatic {
    private String name;
    private Space space;

    public Light(String name, Space space) {
        this.name = name;
        this.setSpace(space);
    }
    public String toString() {

        return "Light[имя = " + this.getName() + ", находится "+ this.getSpace() + "]";
    }
    public String getName() {
        return name;
    }

    @Override
    public int getCoordinatex() {
        return space.getCoordinatex();
    }
    @Override
    public int  getCoordinatey() {
        return space.getCoordinatey();
    }

    public void changeSpace (Space space){
        getSpace().exitSpace(this);
        this.setSpace(space);
    }

    public void setSpace(Space space) {
        space.addToSpace(this);
        this.space = space;
    }

    public Space getSpace() {
        return space;
    }

    @Override
    public int hashCode(){
        int result = 5;
        result = this.getName().hashCode() * 7 + result;
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
        Light light = (Light) o;
        return this.getName().equals(light.getName());
    }

}


