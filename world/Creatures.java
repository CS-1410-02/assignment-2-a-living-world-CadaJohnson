package world;

class Creatures extends Blob{
    public boolean Alive = true;
    private int Fullness = 3;
    public int Health = 2;
    private boolean Sick = false;

    public void LiveDay(){
       if (Alive){
            boolean foundFood = findFood();
            if (foundFood = false){
                Fullness--;
            }
            else{
                Fullness++;
            }

            if (r.nextInt(0, 100) >= 20){
                Sick = true;
            }
            EvaluateHealth();
        }
    }
        private void EvaluateHealth(){
        if (Name == null) {
        Name = "Unnamed Creature";
        }
        if(Fullness == 0){
            Health--;
        }
        if(Sick){
            Health--;
        }
        if (Health <= 0){
            Dies();
        }
    }

    public boolean ShouldReproduce(int ReproduceProbability){
        if (Alive && r.nextInt(0, 100) <= ReproduceProbability){
            return true;
        }
        return false;
    }

    private void Dies(){
        Alive = false;
        System.out.println(Name + " is dead :(");
    }
}




