import org.junit.Assert;
import org.junit.Test;

public class PoolBookingSystemTest {
    PoolBookingSystem poolBookingSystem = new PoolBookingSystem();

    public void beforeMethod(){
        poolBookingSystem.places.add(0, 0);
        poolBookingSystem.places.add(1, 1);
        poolBookingSystem.places.add(2, 1);
        poolBookingSystem.places.add(3, 1);
        poolBookingSystem.places.add(4, 1);
        poolBookingSystem.places.add(5, 1);
        poolBookingSystem.places.add(6, 1);
        poolBookingSystem.places.add(7, 1);
        poolBookingSystem.places.add(8, 1);
        poolBookingSystem.places.add(9, 1);
        poolBookingSystem.places.add(10, 1);
        poolBookingSystem.places.add(11, 1);
        poolBookingSystem.places.add(12, 1);
        poolBookingSystem.places.add(13, 1);
        poolBookingSystem.places.add(14, 1);
        poolBookingSystem.places.add(15, 0);
    }

    @Test
    public void fillPlacesTest() {

        int customer = 2;
        beforeMethod();
        int newValue = poolBookingSystem.fillPlaces(customer);

        Assert.assertEquals(newValue, 16);
    }

    @Test
    public void addNewPlacesTest() {
        int newPlaces = 5;
        beforeMethod();
        int newValue = poolBookingSystem.addNewPlaces(newPlaces);

        Assert.assertEquals(newValue, 21);
    }

    @Test
    public void clearPlacesTest() {
        int placeToStartClear = 10;
        int placeToEndClear = 12;
        beforeMethod();

        int newValue = poolBookingSystem.clearPlaces(placeToStartClear, placeToEndClear);

        Assert.assertEquals(newValue, 5);
    }

}
