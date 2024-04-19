package exam03;

public class Ex01 {
    public static void main(String[] args) {
        //Human human = new Human();  자료형 Human->Animal 바꿀 수 있다
        Animal human = new Human(); // Human, Animal
        //human.move();

        Animal tiger = new Tiger(); // Tiger, Animal
        //tiger.move();

        Animal bird = new Bird(); // Bird, Animal
        //bird.move();

        Animal[] animals = new Animal[3];
        animals[0] = human; // Animal animals[0] = human
        animals[1] = tiger; // Animal animals[1] = tiger
        animals[2] = bird; // Animal animals[2] = Bird

        //for(int i = 0; i < animals.length; i++){
        //    animals[i].move();
        //}

        for(Animal animal : animals){//향상된for문
            animal.move();
        }
    }
}
