import java.util.Random;

public class HanoiTower {

    private int plateNumber;

    private Stack [] rods;

    private Random random;

    public HanoiTower(int plateNumber){

        //We have to follow 3 rules:
        //1.- We can only move one plate at the time
        //2.- We can only move the topmost plate of the rod
        //3.- We cannot place a disk over another smaller

         rods = new Stack[3];

        this.plateNumber = plateNumber;
        this.rods[0] = new Stack(plateNumber);
        this.rods[1] = new Stack(plateNumber);
        this.rods[2] = new Stack(plateNumber);

        random = new Random();

        start();

    }

    public void start(){
        System.out.println("------START PROCESS------");
        //we fill the first rod
        for (int i = 4; i > 0; i--) {
            rods[0].push(i);
        }

        completeHanoiTower();


    }

    public void movePlate(Stack originalRod, Stack destinyRod){

        if(destinyRod.empty() || (Integer) destinyRod.peek() > (Integer) originalRod.peek()){
            destinyRod.push(originalRod.pop());
        }else {
            System.out.println("You can't do that, because either it is bigger than the destiny's top");
            System.out.println("or that rod is empty");
        }

    }

    public void completeHanoiTower(){
        //number of stack
        int randomValue1 = random.nextInt(rods.length);
        int randomValue2 = random.nextInt(rods.length);
        while(!isSolved()){

            if(!rods[randomValue1].empty() && !rods[randomValue2].full()){
                movePlate(rods[randomValue1], rods[randomValue2]);
            }

            randomValue1 = random.nextInt(rods.length);
            randomValue2 = random.nextInt(rods.length);

            showRods();

        }

        showRods();

    }

    public boolean isSolved(){
        boolean areFirstStacksEmpty = true;
        for (int i = 0; i < rods.length - 1; i++) {
            if(!rods[i].empty()){
                areFirstStacksEmpty = false;
                break;
            }
        }
        //check if the last rod is completed
        return areFirstStacksEmpty && rods[rods.length - 1].full();

    }

    public void showRods(){
        System.out.println("Rod 1: ");
        rods[0].showElements();

        System.out.println("Rod 2: ");
        rods[1].showElements();

        System.out.println("Rod 3: ");
        rods[2].showElements();
    }

}
