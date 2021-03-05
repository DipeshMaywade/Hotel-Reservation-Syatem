

public interface HotelReservationInterface {

    void addHotel(String hotelName, Integer hotelPrice, Integer hotelRating);

    void getHotelDetails();

    //Hotel getHotelMinPrice();

    Hotel getHotelBestRated();

    void viewHotels();

}

