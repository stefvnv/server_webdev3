package com.example.assessment_one;

import java.util.ArrayList;
import java.util.List;

public enum HouseDAO {
    instance;

    List<House> houses;

    private HouseDAO() {

        //create a list of houses
        houses = new ArrayList<>(4);

        //populate instances into houses list

        House houseOne = new House("Stefana the Cat", "865 Forest Street, Albuquerque", "3");
        houses.add(houseOne);

        House houseTwo = new House("Sierra the Dog", "76231 Puppy Street, California", "2");
        houses.add(houseTwo);

        House houseThree = new House("Barbie the Kitten", "9421 Animal Street, Chicago", "4");
        houses.add(houseThree);

        House houseFour = new House("Martina Curran", "326 Galway Street, New York", "7");
        houses.add(houseFour);
    }

    public List<House> list() {
        return houses;
    }
}