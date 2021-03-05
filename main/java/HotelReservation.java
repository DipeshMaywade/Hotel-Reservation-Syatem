import java.util.*;

class Hotel{
    public String hotelName;
    public  Integer hotelPrice;

    public Hotel(String hotelName, Integer hotelPrice) {
        this.hotelName = hotelName;
        this.hotelPrice = hotelPrice;
    }

    public String toString(){
        return "Hotel Name: "+hotelName +"Hotel Price: "+hotelPrice;
    }
}

public class HotelReservation implements HotelReservationInterface{

    public ArrayList<Hotel> hotelDetails;

    public HotelReservation(){
       hotelDetails = new ArrayList<>();
   }

   @Override
   public void addHotel(String hotelName, Integer hotelPrice) {
       Hotel adder = new Hotel(hotelName,hotelPrice);
       hotelDetails.add(adder);
   }

   public void getHotelDetails(){
       String hotelName1 = "LakeWood";
       String hotelName2 = "BridgeWood";
       String hotelName3 = "RidgeWood";
       Integer lackWoodPrice1 = 100;
       Integer bridgeWoodPrice1 = 160;
       Integer ridgeWoodPrice1 = 220;

       addHotel(hotelName1,lackWoodPrice1);
       addHotel(hotelName2, bridgeWoodPrice1);
       addHotel(hotelName3,ridgeWoodPrice1);
   }

   public void viewHotels(){
       getHotelDetails();
       System.out.println(hotelDetails);
    }
}
