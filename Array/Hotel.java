public class Hotel {
    private int hotelId;
    private String location;
    private int[] rooms; // Array format: [suites, deluxe, standard]

    public Hotel(int hotelId, String location, int[] rooms) {
        this.hotelId = hotelId;
        this.location = location;
        this.rooms = rooms;
    }

    public int getHotelId() {
        return hotelId;
    }

    public String getLocation() {
        return location;
    }

    public int[] getRooms() {
        return rooms;
    }

    public static void listHotels(Hotel[] hotels, String location) {
        System.out.println("Hotels in " + location + ":");
        for (Hotel hotel : hotels) {
            if (hotel.getLocation().equalsIgnoreCase(location)) {
                System.out.println("Hotel ID: " + hotel.getHotelId() + ", Location: " + hotel.getLocation() + ", Rooms: " + arrayToString(hotel.getRooms()));
            }
        }
    }

    public static void listHotels(Hotel[] hotels, int roomType) {
        String[] roomTypes = {"Suite", "Deluxe", "Standard"};
        System.out.println("Total number of rooms of type " + roomTypes[roomType] + " in each hotel:");
        for (Hotel hotel : hotels) {
            System.out.println("Hotel ID: " + hotel.getHotelId() + ", Location: " + hotel.getLocation() + ", " + roomTypes[roomType] + " rooms: " + hotel.getRooms()[roomType]);
        }
    }

    private static String arrayToString(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i]);
            if (i < array.length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        // Creating hotels
        Hotel[] hotels = new Hotel[3];
        hotels[0] = new Hotel(1, "Mumbai", new int[]{20, 40, 60});
        hotels[1] = new Hotel(2, "Delhi", new int[]{30, 50, 70});
        hotels[2] = new Hotel(3, "Bangalore", new int[]{25, 45, 65});

        // Listing hotels by location
        Hotel.listHotels(hotels, "Mumbai");

        // Listing total number of rooms of a certain type in each hotel
        Hotel.listHotels(hotels, 1); // Type 1 represents "Deluxe" rooms
    }
}
