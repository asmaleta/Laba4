package laba3.environment;



public class Space implements ISpace {
    private int coordinatex;
    private int coordinatey;
    private String name;

    public Space( String name, int x, int y){
        this.coordinatex = x;
        this.coordinatey = y;
        this.name = name;

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
    public boolean CheckLight(Light light){
        if (light.getCoordinatex1() <= this.getCoordinatex() &&
                this.getCoordinatex() <= light.getCoordinatex2() &&
                light.getCoordinatey1() <= this.getCoordinatey() &&
                this.getCoordinatey() <= light.getCoordinatey2()){
            return true;
        }
        return false;
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
