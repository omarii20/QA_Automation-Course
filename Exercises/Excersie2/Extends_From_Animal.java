package Exercises.Excersie2;
class Extends_From_Animal {
    static class CAT extends Animal_Abstract {
        public CAT(String gender, double weight) {
            super(gender, weight);
        }
        public void move() {
            System.out.println("Cat is moving.");
        }
        public Animal mate(Animal partner) {
            return new CAT("Male", 15.0); // Dog mating logic (simplified for example)
        }
    }

    static class DOG extends Animal_Abstract {
        public DOG(String gender, double weight) {
            super(gender, weight);
        }
        public void move() {
            System.out.println("DOG is moving.");
        }
        public Animal mate(Animal partner) {
            return new DOG("Male", 15.0); // Dog mating logic (simplified for example)
        }
    }

   static class HORSE extends Animal_Abstract {
        public HORSE(String gender, double weight) {
            super(gender, weight);
        }
        public void move() {
            System.out.println("Cat is moving.");
        }
        public Animal mate(Animal partner) {
            return new HORSE("Male", 15.0); // Dog mating logic (simplified for example)
        }
    }
   static class SHEEP extends Animal_Abstract {
        public SHEEP(String gender, double weight) {
            super(gender, weight);
        }
        public void move() {
            System.out.println("Cat is moving.");
        }
        public Animal mate(Animal partner) {
            return new SHEEP("Male", 15.0); // Dog mating logic (simplified for example)
        }
    }
}