package laba4;

import laba4.creatures.Character;
import laba4.creatures.IDunamic;
import laba4.creatures.Mumintroll;
import laba4.creatures.Rat;
import laba4.environment.Item;
import laba4.environment.Light;
import laba4.environment.Space;
import laba4.exceptions.NoLookAtYouselfExeption;


public class Main {
    public static void main(String[] args)  {

            Space  tochkaRyadom = new Space ("точка рядом с центром", 9, 9);
            Space centerOfRoom = new Space("центр комнаты", 9, 9);
            Space dinnerTable = new Space("круглый стол", 10, 11);
            Space angle = new Space ("угол", 0, 0 );
            Space floorUnderPalm = new Space("пол под пальмой", 3,3);
            Space floorNearByTable = new Space("пол рядом со столом ", 10,12);
            Space placeNearByTable = new Space("место рядом со столом ", 9,10);
            Item chesse = new Item("сыр",centerOfRoom);
            Item plateWithPorridge = new Item("тарелка с кашей",dinnerTable);
            Item sugarBowl = new Item("сахарница",dinnerTable);
            Item pancake = new Item("блинчик",dinnerTable);


            Light ray = new Light ("Луч света", tochkaRyadom );


            Mumintroll muminSon = new Mumintroll("Муми-тролль", 8 , Character.Gender.MALE, Character.Direction.EAST, centerOfRoom);
            Mumintroll muminMom = new Mumintroll("Муми-мама", 40, Character.Gender.FEMALE, Character.Direction.EAST,centerOfRoom );
            Mumintroll muminDad = new Mumintroll("Мумми-папа", 41, Character.Gender.MALE, Character.Direction.EAST, dinnerTable );
            Rat emma= new Rat("Эмма", 25, Character.Gender.FEMALE, Character.Color.GREY, Character.TypeOfSkin.SHRIVELED, angle, Character.Direction.EAST, "карман");
            muminMom.takeThing(plateWithPorridge);
            muminMom.putThing(plateWithPorridge,floorUnderPalm);

            muminDad.toRush(dinnerTable);
            muminSon.toRush(dinnerTable);
            muminMom.toRush(dinnerTable);
            muminDad.sitRound();
            muminSon.sitRound();
            muminMom.sitRound();

            muminSon.addThing(sugarBowl);
            muminSon.stopShort();

            muminMom.setDir(Character.Direction.WEST);
            muminSon.setDir(Character.Direction.WEST);
            muminDad.setDir(Character.Direction.WEST);
            try {
                    muminSon.watch(emma);
                    muminMom.watch(emma);
                    muminDad.watch(emma);
            }catch (NoLookAtYouselfExeption e){
                    System.out.println("Ошибка! Нельзя посмотреть на себя");
            }


            emma.go(tochkaRyadom);

            emma.shake("седыми усами");
            try {
                    emma.watchEvil(muminSon, muminMom, muminDad);
            }catch (NoLookAtYouselfExeption e){
                    System.out.println("Ошибка! Нельзя посмотреть на себя");
            }

            emma.go(placeNearByTable);
            emma.sit(false,dinnerTable);
            System.out.println(emma.getName() + " не ответила");
            emma.watch(chesse);
            emma.putInPocket(chesse);
            emma.searchItem(dinnerTable,pancake);




          }
    }


