import java.util.*;

class manage
{
  int[]room = new int[3];
  // 0 is standard
  // 1 deluxe
  // 2 suite
  String location;
  int id;

  manage(int a ,int b , int c, String l , int i)
  {
    //for (int j=0 ; i<3 ; i++)
    //{
    //    this.room[j]=a[j];
    //}
    this.room[0]=a;
    this.room[1]=b;
    this.room[2]=c;
    this.location=l;
    this.id=i;
  }

  void print()
  {
    System.out.println("Hotel location is: "+location);
    System.out.println("Hotel id is: "+id);
    System.out.printf("There are %d standard rooms",room[0]);
    System.out.printf("There are %d deluxe rooms",room[1]);
    System.out.printf("There are %d suite rooms",room[2]);
    System.out.println();

  }

  int ret_room(int a)
  {
    return room[a];
  }

}


public class HotelUser_Defined 
{
// use static static void , take object as parameter

static void ls_hotel_loc(manage m[] , String l )
{
  for (int i = 0; i < m.length; i++) 
  {
    if((m[i].location).equalsIgnoreCase(l))
    {
      m[i].print();
    }
  } 
}

static void ls_hotel_type(manage m[] , int room_type)
{
  int num=0;
  for (int i = 0; i < m.length; i++) 
  {
   num+=m[i].room[room_type];
  } 

  switch (room_type) {
      case 0:
      {
      System.out.printf("There are %d rooms of standard type",num);
      break;
      }
      case 1:
      {
      System.out.printf("There are %d rooms of deluxe type",num);
      break;
      }
      case 2:
      {
      System.out.printf("There are %d rooms of suite type",num);
      break;
      }
  
    default:
    {
      System.out.println("Acheivement unlocked: User is an idiot (¬_¬ )");
      break;
    }
  }

  
}

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("How many hotels are there?");
        int n = sc.nextInt();
        manage[] hotel = new manage[n];

        int[] room = new int[3];
        String loc;
        int id;
        for (int i = 0; i < n; i++) 
        {
            System.out.println("Enter info of hotel "+(i+1));
            System.out.print("Enter location: ");
            loc = sc.next();
            System.out.print("Enter hotel id: ");
            id = sc.nextInt();
            System.out.print("Enter number of Standard rooms: ");
            room[0]=sc.nextInt();
            System.out.print("Enter number of duplex rooms: ");
            room[1]=sc.nextInt();
            System.out.print("Enter number of suites: ");
            room[2]=sc.nextInt();
            hotel[i]= new manage(room[0],room[1],room[2],loc,id ); 
        }
        System.out.println("Enter location check: ");
        String loc_ck=sc.next();
        System.out.print("Enter room ckeck press 1 to check for standard , 2 for deluxe , 3 for suite : ");
        int room_chk = sc.nextInt();
        room_chk--;
        ls_hotel_loc(hotel, loc_ck);
        ls_hotel_type(hotel, room_chk);

        sc.close();
    }
}
