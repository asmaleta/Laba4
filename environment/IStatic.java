package laba3.environment;

public interface IStatic {

    default int getCoordinatex() {
        return 0;
    }

    default int getCoordinatey() {
        return 0;
    }
    String toString();
    String getName();

}
