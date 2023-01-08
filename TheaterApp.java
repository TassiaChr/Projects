package projects;

public class TheaterApp {
    static boolean [][] arr = new boolean[30][12];
    //default value is false for boolean elements

    public static void main(String[] args) {
        book('B', 2);
        cancel('D', 5);
        cancel('B', 2);
    }

    public static void book(char column, int row) {
        //converting char column into an int
        int col = column - 'A';
        if (!arr[row][col]) {
            arr[row][col] = true;
            System.out.println("Seat booked successfully");
        } else {
            System.out.println("Seat is already booked");
        }
    }

    public static void cancel(char column, int row) {
        int col = column - 'A';
        if (arr[row][col]) {
            arr[row][col] = false;
            System.out.println("Booking cancelled");
        } else {
            System.out.println("Seat is not booked");
        }
    }
}
