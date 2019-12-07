package laba3;

import laba3.creatures.Character;
import laba3.creatures.Mumintroll;
import laba3.creatures.Rat;
import laba3.environment.Light;
import laba3.environment.Space;

public class Main {
    public static void main(String[] args){
            Space  tochkaRyadom = new Space ("Точка рядом с центром", 11, 13);
            Space centerOfRoom = new Space("Центр комнаты", 10, 10);
            Space angle = new Space ("Угол", 0, 0 );
            Light ray = new Light ("Луч света", tochkaRyadom );

            Mumintroll muminSon = new Mumintroll("Муми-тролль", 8 , Character.Gender.MALE, Character.Direction.EAST, centerOfRoom );
            Mumintroll muminMom = new Mumintroll("Муми-мама", 40, Character.Gender.FEMALE, Character.Direction.EAST,centerOfRoom );
            Mumintroll muminDad = new Mumintroll("Мумми-папа", 41, Character.Gender.MALE, Character.Direction.EAST, centerOfRoom );
            Rat emma= new Rat("Эмма", 25, Character.Gender.FEMALE, Character.Color.GREY, Character.TypeOfSkin.SHRIVELED, angle, Character.Direction.EAST);

            muminMom.setDir(Character.Direction.WEST);
            muminSon.setDir(Character.Direction.WEST);
            muminDad.setDir(Character.Direction.WEST);
            muminSon.watch(emma);
            muminMom.watch(emma);
            muminDad.watch(emma);
            emma.go(tochkaRyadom);
            emma.shake();
            emma.watchEvil(muminSon, muminMom, muminDad);




          }
    }


