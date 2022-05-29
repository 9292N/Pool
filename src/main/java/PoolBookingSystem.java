
// 0 - empty
// 1 - not empty

import java.util.ArrayList;
import java.util.Scanner;

public class PoolBookingSystem {
    protected static ArrayList<Integer> places = new ArrayList<>();
    private static int indexToStart = 0;
    private static int indexToStart2 = 0;
    private static int countCorrectEmptyPlaces = 0;
    private static int countAnyEmptyPlaces = 0;
    private static int indexToAdd = 0;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        places.add(0, 0);
        places.add(1, 1);
        places.add(2, 0);
        places.add(3, 0);
        places.add(4, 0);
        places.add(5, 0);
        places.add(6, 1);
        places.add(7, 0);
        places.add(8, 1);
        places.add(9, 1);
        places.add(10, 0);
        places.add(11, 0);
        places.add(12, 1);
        places.add(13, 1);
        places.add(14, 0);
        places.add(15, 0);

        System.out.println("Status of deckchairs (0 - is empty | 1 - is full)");
        for (int i = 0; i < places.size(); i++) {
            System.out.printf("%2d: %2d\n", (i+1), places.get(i));
        }
        System.out.println();


        System.out.print("How many customers: ");
        fillPlaces(scan.nextInt());
        System.out.println("You added new customers: ");
        for (int i = 0; i < places.size(); i++) {
            System.out.printf("%2d: %2d\n", (i+1), places.get(i));
        }
        System.out.println();

        System.out.print("How many new deckchairs to add: ");
        addNewPlaces(scan.nextInt());
        for (int i = 0; i < places.size(); i++) {
            System.out.printf("%2d: %2d\n", (i+1), places.get(i));
        }
        System.out.println();


        System.out.println("Which custumers are leaving: ");
        clearPlaces(scan.nextInt(), scan.nextInt());
        for (int i = 0; i < places.size(); i++) {
            System.out.printf("%2d: %2d\n", (i+1), places.get(i));
        }
        System.out.println();
    }

    protected static int fillPlaces(int customers) {
        findCorrectEmptyPlaces(customers);
        findAnyEmptyPlaces(customers);

        if (countCorrectEmptyPlaces == customers) {
            for (int i = 0; i < customers; i++) {
                places.set(indexToStart % places.size(), 1);
                indexToStart++;
            }
            indexToAdd = indexToStart % places.size();
        } else if (countAnyEmptyPlaces == customers) {
            for (int i = 0; i < customers; i++) {
                places.set(indexToStart2 % places.size(), 1);
                indexToStart2++;
            }
            indexToAdd = indexToStart2 % places.size();
        } else {
            System.out.println("Es sind keine Plaetze frei");
        }

//        for JUnit test
        int counter = 0;
        for (int i = 0; i < places.size(); i++) {
            if (places.get(i) == 1) {
                counter++;
            }
        }
        return counter;
    }

    private static void findCorrectEmptyPlaces(int customers) {

        for (int i = 0; i < places.size() * 2; i++) {

            if (places.get(i % places.size()) == 0) {
                countCorrectEmptyPlaces++;
                if (countCorrectEmptyPlaces == customers && places.get((i + 1) % places.size()) != 0) {
                    indexToStart = i - customers + 1;
                    return;
                }
            } else {
                countCorrectEmptyPlaces = 0;
            }
        }
        countCorrectEmptyPlaces = 0;
    }

    private static void findAnyEmptyPlaces(int customers) {

        for (int i = 0; i < places.size() * 2; i++) {
            if (places.get(i % places.size()) == 0) {
                countAnyEmptyPlaces++;
                if (countAnyEmptyPlaces == customers) {
                    indexToStart2 = i - customers + 1;
                    return;
                }
            } else {
                countAnyEmptyPlaces = 0;
            }
        }
    }

    protected static int addNewPlaces(int newPlaces) {
        for (int i = 0; i < newPlaces; i++) {
            places.add(indexToAdd, 0);
        }

        return places.size();
    }

    protected static int clearPlaces(int placeToStartClear, int placeToEndClear) {
        int circle = (places.size() - placeToStartClear + placeToEndClear) % places.size();
        for (int i = 0; i <= circle; i++) {
            places.set((placeToStartClear - 1) % places.size(), 0);
            placeToStartClear++;
        }
//        for JUnit test
        int counter = 0;
        for (int i = 0; i < places.size(); i++) {
            if (places.get(i) == 0) {
                counter++;
            }
        }
        return counter;
    }
}

