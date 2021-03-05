import java.util.*;

class Hotel{
    public String hotelName;
    public  Integer hotelPrice;

    public Hotel(String hotelName, Integer hotelPrice) {
        this.hotelName = hotelName;
        this.hotelPrice = hotelPrice;
    }

    public String getName(){
        return hotelName;
    }

    public int getPrice(){
        return hotelPrice;
    }

    public String toString(){
        return "Hotel Name: "+hotelName +"Hotel Price: "+hotelPrice;
    }
}

public class HotelReservation implements HotelReservationInterface{

    Scanner scan = new Scanner(System.in);
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
       List lackWoodWeekDayPrice = Arrays.asList(110,80);
       List lackWoodWeekEndDayPrice = Arrays.asList(90,80);
       List bridgeWoodWeekDayPrice = Arrays.asList(160,110);
       List bridgeWoodWeekEndDayPrice = Arrays.asList(60,50);
       List ridgeWoodWeekDayPrice = Arrays.asList(220,100);
       List ridgeWoodWeekEndDayPrice = Arrays.asList(150,40);

       System.out.println("Enter Your DaysCount For Booking");
       int dayCount = scan.nextInt();
       addHotel(hotelName1, ((Integer) lackWoodWeekDayPrice.get(0)*dayCount));
       addHotel(hotelName2, ((Integer) bridgeWoodWeekDayPrice.get(0)*dayCount));
       addHotel(hotelName3,((Integer) ridgeWoodWeekDayPrice.get(0)*dayCount));

       System.out.println(getHotelMinPrice());

    }
    
    public Hotel getHotelMinPrice(){
        Hotel minPrice = hotelDetails
               .stream()
               .min(Comparator.comparing(Hotel :: getPrice))
               .orElseThrow(NoSuchElementException::new);
       return minPrice;
    }

    public void viewHotels() {
        getHotelDetails();
    }
}