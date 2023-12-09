package world;
import java.util.Random;

public class Blob{
    public String Name; 
    Random r = new Random();
    int determination = r.nextInt(3, 9);
    

    public void SetName(String name){
        Name = name;
    }

    public boolean findFood(){
        boolean[][] foodLocation = 
        {{false, false, false},
        {false, false, false},
        {false, false, false}};

        foodLocation[r.nextInt(0,3)][r.nextInt(0,3)] = true;

        for (int i = 0; i < determination; i++)    
        {
            if (foodLocation[r.nextInt(0,3)][r.nextInt(0,3)] = true)
            {
                return true;
            }
        }
        return false;
        //if it gets it, yay! hunger goes down
        //if not, the blob goes hungry :(
    }
}
