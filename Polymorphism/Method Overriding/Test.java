/*
Create a class named Movie that can be used with your video rental business. 
The Movie class should track the Motion Picture Association of America (MPAA) rating (e.g., Rated G, PG-13, R), ID Number, and movie title 
with appropriate accessor and mutator methods. 
Also create an equals() method that overrides Object ’s equals() method,where two movies are equal if their ID number is identical.
Next, create three additional classes named Action, Comedy, and Drama that are derived from Movie. 
Finally, create an overridden method named calcLateFees that takes as input the number of days a movie is late and returns the late fee for that movie.
The default late fee is $2/day. Action movies have a late fee of $3/day, comedies are $2.50/day, and dramas are $2/day. 
Test your classes from a main method.

Extend the previous problem with a Rental class. 
This class should store a Movie that is rented, an integer representing the ID of the customer that rented the movie, 
and an integer indicating how many days late the movie is. Add a method that calculates the late fees for the rental. 
In your main method, create an array of type Rental filled with sample data of all types of movies. 
Then, create a method named lateFeesOwed that iterates through the array and returns the total amount of late fees that are outstanding.
*/

import java.util.Scanner;

 class Movie {
    String rating;
    long id;
    String title;

    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public boolean equals(Movie movie) {
        return this.id == movie.id;
    }

    public double calculateFees(int days) {
        return days * 2;
    }
}

class Action extends Movie {
    public double calculateFees(int days) {
        return days * 3;
    }
}

class Comedy extends Movie {
    public double calculateFees(int days) {
        return days * 2.5;
    }
}

class Drama extends Movie {

}

class Rental {
    Movie movie;
    int custID;
    int days;
    static double total;

    public Rental(Movie movie, int custID, int days) {
        this.movie = movie;
        this.custID = custID;
        this.days = days;
        total += movie.calculateFees(days);
    }

    public double calculateFees(int days) {
        return movie.calculateFees(days);
    }
    

}

public class Test {
    public static void main(String[] args) {
        Movie movie1 = new Movie();
        movie1.setRating("Rated G");
        movie1.setId(1);
        movie1.setTitle("Movie 1");

        Movie movie2 = new Drama();
        movie2.setRating("Rated PG-13");
        movie2.setId(2);
        movie2.setTitle("Drama");

        Movie movie3 = new Action();
        movie3.setRating("Rated R");
        movie3.setId(3);
        movie3.setTitle("Action");

        Movie movie4 = new Comedy();
        movie4.setRating("Rated G");
        movie4.setId(4);
        movie4.setTitle("Comedy");

        Rental[] rentals = {
            new Rental(movie2, 129, 5),
            new Rental(movie3, 456, 10),
            new Rental(movie4, 789, 20)
        };

        System.out.println("Drama fees: " + rentals[0].calculateFees(5));
        System.out.println("Action fees: " + rentals[1].calculateFees(10));
        System.out.println("Comedy fees: " + rentals[2].calculateFees(20));
        System.out.println("The total rent is: " + Rental.total);


    }
}
