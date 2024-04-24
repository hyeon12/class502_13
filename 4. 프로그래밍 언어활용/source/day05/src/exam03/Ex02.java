package exam03;

public class Ex02 {
    public static void main(String[] args) {
        Animal[] animals = {new Human(), new Bird(), new Tiger()};
        // Animal[] animals = new Animal[3];
        // animals[0] = new Human();
        // animals[1] = new Bird();
        // animals[2] = new Tiger();

        for (Animal animal : animals) {
            animal.move(); //위의 human,bird,tiger 가 본체

            if(animal instanceof Human) {
                Human human = (Human) animal; //강제형변환
                human.reading(); //다운캐스팅
            } else if (animal instanceof Tiger) {
                Tiger tiger = (Tiger) animal; //강제형변환
                tiger.hunting(); //다운캐스팅
            }
        }
    }
}
