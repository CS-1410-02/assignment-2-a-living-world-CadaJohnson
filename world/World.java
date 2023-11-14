package world;
import java.util.Random;

public class World {
    private Creatures CreatureBank[] = new Creatures[100];
    private String[] names = {"Smith","Johnson","Williams","Brown","Jones","Miller","Davis","Garcia","Rodriguez","Wilson","Martinez","Anderson","Taylor","Thomas","Hernandez","Moore","Martin","Jackson","Thompson","White","Lopez","Lee","Gonzalez","Harris","Clark","Lewis","Robinson","Walker","Perez","Hall","Young","Allen","Sanchez","Wright","King","Scott","Green","Baker","Adams","Nelson","Hill","Ramirez","Campbell","Mitchell","Roberts","Carter","Phillips","Evans","Turner","Torres","Parker","Collins","Edwards","Stewart","Flores","Morris","Nguyen","Murphy","Rivera","Cook","Rogers","Morgan","Peterson","Cooper","Reed","Bailey","Bell","Gomez","Kelly","Howard","Ward","Cox","Diaz","Richardson","Wood","Watson","Brooks","Bennett","Gray","James","Reyes","Cruz","Hughes","Price","Myers","Long","Foster","Sanders","Ross","Morales","Powell","Sullivan","Russell","Ortiz","Jenkins","Gutierrez","Perry","Butler","Barnes","Fisher","Henderson","Coleman","Simmons","Patterson","Jordan","Reynolds","Hamilton","Graham","Kim","Gonzales","Alexander","Ramos","Wallace","Griffin","West","Cole","Hayes","Chavez","Gibson","Bryant","Ellis","Stevens","Murray","Ford","Marshall","Owens","Mcdonald","Harrison","Ruiz","Kennedy","Wells","Alvarez","Woods","Mendoza","Castillo","Olson","Webb","Washington","Tucker","Freeman","Burns","Henry","Vasquez","Snyder","Simpson","Crawford","Jimenez","Porter","Mason","Shaw","Gordon","Wagner","Hunter","Romero","Hicks","Dixon","Hunt","Palmer","Robertson","Black","Holmes","Stone","Meyer","Boyd","Mills","Warren","Fox","Rose","Rice","Moreno","Schmidt","Patel","Ferguson","Nichols","Herrera","Medina","Ryan","Fernandez","Weaver","Daniels","Stephens","Gardner","Payne","Kelley","Dunn","Pierce","Arnold","Tran","Spencer","Peters","Hawkins","Grant","Hansen","Castro","Hoffman","Hart","Elliott","Cunningham","Knight","Bradley","Carroll","Hudson","Duncan","Armstrong","Berry","Andrews","Johnston","Ray","Lane","Riley","Carpenter","Perkins","Aguilar","Silva","Richards","Willis","Matthews","Chapman","Lawrence","Garza","Vargas","Watkins","Wheeler","Larson","Carlson","Harper","George","Greene","Burke","Guzman","Morrison","Munoz","Jacobs","Obrien","Lawson","Franklin","Lynch","Bishop","Carr","Salazar","Austin","Mendez","Gilbert","Jensen","Williamson","Montgomery","Harvey","Oliver","Howell","Dean","Hanson","Weber","Garrett","Sims","Burton","Fuller","Soto","Mccoy","Welch","Chen","Schultz","Walters","Reid","Fields","Walsh","Little","Fowler","Bowman","Davidson","May","Day","Schneider","Newman","Brewer","Lucas","Holland","Wong","Banks","Santos","Curtis","Pearson","Delgado","Valdez","Pena"};
    Random r = new Random();
    public static boolean SomethingHappened = false;
    
    public void RunDay(){
        //have each creature live their day
        for (int i = 0; i <= CreatureBank.length-1; i++){
            if (CreatureBank[i] != null){
                CreatureBank[i].LiveDay();
            }
        }
        
        // reproduced creatures
        Reduce();
        for (int i = 0; i <= CreatureBank.length-2; i++){
            if (CreatureBank[i] != null){
                if (CreatureBank[i].ShouldReproduce(60)){
                    CreateCreature();
                    System.out.println(" (Reproduced) ");
                }
            }
        }

        //randomly produce creatures 
        if (r.nextInt(0, 100) <= 40){
            CreateCreature();
            System.out.println(" (Randomly) ");
        }  
        
        if (SomethingHappened == false){
            System.out.println("No one was created");
        }
    }

    public void WriteHealth(){
        Reduce();
        System.out.println();
        for (int i = 0; i <= CreatureBank.length-1; i++){
            if (CreatureBank[i] != null){
                System.out.println(CreatureBank[i].Name + "'s Health: " + CreatureBank[i].Health);
            }
        }
    }

    private void CreateCreature(){
        Reduce();
        SomethingHappened = true;
        for (int i = 0; i <= CreatureBank.length-1; i++){
            if (CreatureBank[i] == null){
                CreatureBank[i] = new Creatures();
                String N = names[r.nextInt(0, names.length)];
                CreatureBank[i].SetName(N);
                System.out.print(N + " has been created!");
                break;
            }
        }
    }

    public void Reduce(){
        for (int i = 0; i <= CreatureBank.length-1; i++){
            if (CreatureBank[i] != null && !CreatureBank[i].Alive){
                CreatureBank[i]= null;
            }
        }
    }


}
