 /* Write a program in Java to maintain the information of Movies which includes the information of name
of movie , type of movie( action , thriller , comedy ,drama ) , Hero name , Heroine , budget in Rs. Write
a program to accept the information of movies from user and sort them according to the budget of the
film. */

/*flow :
movie name,
type of movie,
hero name,
heroine name,
budget.
Use of sorting arrays by use of swapping
*/ 
import java.util.*;

class Movies {
    
    String name;
    String type;
    String hero;
    String heroine;
    double budget;
    
    public Movies(String name, String type, String hero, String heroine, double budget) {
        this.name = name;
        this.type = type;
        this.hero = hero;
        this.heroine = heroine;
        this.budget = budget;
    }
}

class MovieSorter {
    
    public static void movieSort(Movies[] ob, int n) {
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (ob[j].budget > ob[j + 1].budget) {
                    Movies temp = ob[j];
                    ob[j] = ob[j + 1];
                    ob[j + 1] = temp;
                    swapped = true;
                }
            }
            
            if (!swapped)
                break;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
                
        System.out.print("Enter number of the Movies: ");
        int n = sc.nextInt();
        sc.nextLine(); 
        
        Movies ob[] = new Movies[n];    //creates an array of objects
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Name of The Movie: ");
            String name = sc.nextLine();
            System.out.print("Enter type of the Movie: ");
            String type = sc.nextLine();
            System.out.print("Enter name of the Hero: ");
            String hero = sc.nextLine();
            System.out.print("Enter name of the Heroine: ");
            String heroine = sc.nextLine();
            System.out.print("Enter budget of the movie: ");
            double budget = sc.nextDouble();
            sc.nextLine(); 
            
            ob[i] = new Movies(name, type, hero, heroine, budget);
        }
        
        // Sort movies by budget
        movieSort(ob, n);
        
        // Display sorted movies
        for (Movies m : ob) {
            System.out.println(m.name);
            System.out.println(m.type);
            System.out.println(m.hero);
            System.out.println(m.heroine);
            System.out.println(m.budget);
        }
    }
}

