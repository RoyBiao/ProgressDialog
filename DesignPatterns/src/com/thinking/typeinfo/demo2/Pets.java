//: typeinfo/pets/Pets.java
// Facade to produce a default PetCreator.
package com.thinking.typeinfo.demo2;
import java.util.*;

import com.thinking.typeinfo.demo2.creator.LiteralPetCreator;
import com.thinking.typeinfo.demo2.creator.PetCreator;
import com.thinking.typeinfo.demo2.model.Pet;

public class Pets {
  public static final PetCreator creator =
    new LiteralPetCreator();
  public static Pet randomPet() {
    return creator.randomPet();
  }
  public static Pet[] createArray(int size) {
    return creator.createArray(size);
  }
  public static ArrayList<Pet> arrayList(int size) {
    return creator.arrayList(size);
  }
} ///:~
