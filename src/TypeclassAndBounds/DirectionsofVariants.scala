package TypeclassAndBounds


class Forest

class LionAsAnimal extends Forest

class WhiteLion extends LionAsAnimal

class DessertLion extends LionAsAnimal

class TigerAsAnimal extends Forest

class BengalTiger extends TigerAsAnimal

class SiberianTiger extends TigerAsAnimal

class ForestZoo[+A](f:A)

class typeAnimal(d: ForestZoo[LionAsAnimal])

class contraZoo[-A](f:A)

class typeContraAnimal(d: contraZoo[LionAsAnimal])


object DirectionsofVariants {
  def main(args: Array[String]) : Unit = {
    val covariantZoo1 = new typeAnimal(new ForestZoo[LionAsAnimal] (new LionAsAnimal))
    println(covariantZoo1)  //prints TypeclassAndBounds.ForestZoo@5f184fc6

    //below throws error as it is covariant and only its base class and subclass are accessible, superclass is not
    //val covariantZoo2 = new typeAnimal(new ForestZoo[Forest] (new LionAsAnimal))
    //println(covariantZoo2)  //prints TypeclassAndBounds.ForestZoo@5f184fc6    

    //below works as WhiteLion is subtype of LionAsAnimal
    val covariantZoo3 = new typeAnimal(new ForestZoo[WhiteLion] (new WhiteLion))
    println(covariantZoo3)  //TypeclassAndBounds.typeAnimal@3feba861    

    //below throws error as it is contravariant and only its base class and superclass are accessible, subclass is not
    //val contravariantZoo4 = new typeContraAnimal(new contraZoo[WhiteLion] (new WhiteLion))
    //println(covariantZoo4)  //TypeclassAndBounds.typeAnimal@3feba861       

    val contravariantZoo5 = new typeContraAnimal(new contraZoo[Forest] (new Forest))
    println(contravariantZoo5)  //TypeclassAndBounds.typeContraAnimal@5b480cf9         
  }
}