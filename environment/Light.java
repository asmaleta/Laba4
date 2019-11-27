package laba3.environment;

public class Light {
    private String name;
    private Space space;

    public Light(String name, Space space) {
        this.name = name;
        this.space = space;
    }
    public String toString() {

        return "Light[имя = " + this.getName() + ", место = "+ this.getSpace() + "]";
    }
    public String getName() {
        return name;
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

}

