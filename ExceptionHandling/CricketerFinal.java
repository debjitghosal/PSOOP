/* Write a java program for :
Define a class Cricketer which has:-

Attributes:-

● player_name

● runs_hit

● innings_count

● not_out_count

● batting_avg

Methods:-get_avg

Make a cricket team with 11 cricketers. For each cricketer, find his batting

average. Handle all different errors while calculating this. Also, make a method

which will find the list of cricketers in ascending order of their batting average

and also display the cricketer stats in this order.

If the average of the batting average of the entire team is less than 20 runs then throw a user-defined exception.

Note- handle errors like ArrayIndexOutOfBoundsException, ArithmeticException,ArrayStoreException, NumberFormatException, etc
*/
/*
FLow:
first make a class for exceptions
create class for cricketer
override class
make main class
*/
import java.util.Scanner;
import java.util.Arrays;

class LowTeamBattingAverageException extends Exception {
    public LowTeamBattingAverageException(String message) {
        super(message);
    }
}

class Cricketer {
    String playerName;
    int runsHit;
    int inningsCount;
    int notOutCount;
    double battingAvg;

    public Cricketer(String playerName, int runsHit, int inningsCount, int notOutCount) {
        this.playerName = playerName;
        this.runsHit = runsHit;
        this.inningsCount = inningsCount;
        this.notOutCount = notOutCount;
    }

    public double getAvg() {
        if (inningsCount == 0) {
            return 0.0;
        }
        return (double) runsHit / (inningsCount - notOutCount);
    }

    public String getPlayerName() {
        return playerName;
    }

    public double getBattingAvg() {
        return battingAvg;
    }

    @Override
    public String toString() {
        return "Player Name: " + playerName +
                ", Runs Hit: " + runsHit +
                ", Innings Count: " + inningsCount +
                ", Not Out Count: " + notOutCount +
                ", Batting Average: " + battingAvg;
    }
}

public class CricketerFinal {
    public static void main(String[] args) {
        Cricketer[] team = new Cricketer[11];
   
        team[0] = new Cricketer("Player1", 500, 20, 2);
        team[1] = new Cricketer("Player2", 600, 25, 3);
        team[2] = new Cricketer("Player3", 300, 35, 6);
        team[3] = new Cricketer("Player4", 600, 25, 8);
        team[4] = new Cricketer("Player5", 600, 45, 6);
        team[5] = new Cricketer("Player6", 600, 15, 8);
        team[6] = new Cricketer("Player7", 600, 75, 4);
        team[7] = new Cricketer("Player8", 600, 65, 6);
        team[8] = new Cricketer("Player9", 600, 55, 3);
        team[9] = new Cricketer("Player10", 600, 5, 1);
        team[10] = new Cricketer("Player11", 600, 45, 6);
        
       
        try {
            double teamAvg = 0.0;
            int playerCount = 0;
            for (Cricketer player : team) {
                if (player != null) {
                    player.battingAvg = player.getAvg();
                    teamAvg += player.getBattingAvg();
                    playerCount++;
                }
            }
            if (playerCount != 0) {
                teamAvg /= playerCount;
            }
            if (teamAvg < 20) {
                throw new LowTeamBattingAverageException("Team's average batting average is below 20 runs.");
            }
            Arrays.sort(team, (a, b) -> Double.compare(a.getBattingAvg(), b.getBattingAvg()));
            System.out.println("Cricketers sorted by batting average:");
            for (Cricketer player : team) {
                if (player != null) {
                    System.out.println(player);
                }
            }
        } catch (LowTeamBattingAverageException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ArithmeticException | NullPointerException | ArrayIndexOutOfBoundsException | ArrayStoreException | NumberFormatException e) {
            System.out.println("Error: " + e.getClass().getSimpleName() + " occurred while calculating batting average.");
        }
    }
}


