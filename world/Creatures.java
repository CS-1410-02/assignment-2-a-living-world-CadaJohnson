package world;

class Creatures extends Blob{
    public boolean Alive = true;
    private int Fullness = 3;
    public int Health = 2;
    private boolean Sick = false;

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

    public void LiveDay(){
       if (Alive){
            if (r.nextInt(0, 100) >= 60){
                Fullness--;
            }
            if (r.nextInt(0, 100) >= 20){
                Sick = true;
            }
            
            EvaluateHealth();
        }
    }

    public boolean ShouldReproduce(int Probability){
        if (Alive && r.nextInt(0, 100) <= Probability){
            return true;
        }
        return false;
    }

    private void Dies(){
        Alive = false;
        System.out.println(Name + " is dead :(");
    }
}




