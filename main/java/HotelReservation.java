import java.util.*;

class Hotel{
    public String hotelName;
    public  Integer hotelPrice;
    public Integer hotelRating;

    public Hotel(String hotelName, Integer hotelPrice, Integer hotelRating) {
        this.hotelName = hotelName;
        this.hotelPrice = hotelPrice;
        this.hotelRating = hotelRating;
    }

    public int getPrice(){
        return hotelPrice;
    }

    public int getRating(){
        return hotelRating;
    }

    public String toString(){
        return "Hotel Name: "+hotelName +"\nHotel Price: "+hotelPrice+ "\nRating: " +hotelRating+"\n";
    }
}

public class HotelReservation implements HotelReservationInterface{

    Scanner scan = new Scanner(System.in);
    public ArrayList<Hotel> hotelDetails;

    public HotelReservation(){
       hotelDetails = new ArrayList<>();
   }

   @Override
   public void addHotel(String hotelName, Integer hotelPrice, Integer hotelRating) {
       Hotel adder = new Hotel(hotelName,hotelPrice,hotelRating);
       hotelDetails.add(adder);
   }

   public void getHotelDetails(){
       String hotelName1 = "LakeWood";
       String hotelName2 = "BridgeWood";
       String hotelName3 = "RidgeWood";
       Integer lakeWoodRating = 3;
       Integer bridgeWoodRating = 4;
       Integer ridgeWoodRating = 5;

       List lackWoodWeekDayPrice = Arrays.asList(110,80);
       List lackWoodWeekEndDayPrice = Arrays.asList(90,80);
       List bridgeWoodWeekDayPrice = Arrays.asList(160,110);
       List bridgeWoodWeekEndDayPrice = Arrays.asList(60,50);
       List ridgeWoodWeekDayPrice = Arrays.asList(220,100);
       List ridgeWoodWeekEndDayPrice = Arrays.asList(150,40);

       System.out.println("For Login As A Normal Customer Enter 1\nFor Login As A Rewarded Customer Enter 2");
       int customerType = scan.nextInt();
       int index = customerType-1;

       System.out.println("Choose Your Option\n 1 For WeekDays\n 2 For WeekEndDays");
       int dayOption = scan.nextInt();

       System.out.println("Enter Your DaysCount For Booking");
       int dayCount = scan.nextInt();

       switch (dayOption){
           case 1:
               addHotel(hotelName1, ((Integer) lackWoodWeekDayPrice.get(index)*dayCount),lakeWoodRating);
               addHotel(hotelName2, ((Integer) bridgeWoodWeekDayPrice.get(index)*dayCount),bridgeWoodRating);
               addHotel(hotelName3,((Integer) ridgeWoodWeekDayPrice.get(index)*dayCount),ridgeWoodRating);
               break;
           case 2:
               addHotel(hotelName1, ((Integer) lackWoodWeekEndDayPrice.get(index)*dayCount),lakeWoodRating);
               addHotel(hotelName2, ((Integer) bridgeWoodWeekEndDayPrice.get(index)*dayCount),bridgeWoodRating);
               addHotel(hotelName3, ((Integer) ridgeWoodWeekEndDayPrice.get(index)*dayCount),ridgeWoodRating);
               break;
           default:
               addHotel("No Hotel Available",null,null );
               System.out.println("Invalid Option");
       }

       System.out.println("Sort Hotel By \n1 For Minimum Price Hotel \n2 For Best Rating Hotel \n3 For All Hotel ");
       int sortOption = scan.nextInt();
       switch (sortOption){
           case 1:
               System.out.println(getHotelMinPrice());
               break;
           case 2:
               System.out.println(getHotelBestRated());
               break;
           case 3:
               System.out.println(hotelDetails);
               break;
           default:
               System.out.println("Invalid Sorting Option Try Again");
       }
    }

    public Hotel getHotelMinPrice(){
        Hotel minPrice = hotelDetails
               .stream()
               .min(Comparator.comparing(Hotel :: getPrice))
               .orElseThrow(NoSuchElementException::new);
       return minPrice;
    }

    public Hotel getHotelBestRated(){
        Hotel bestRated = hotelDetails
                .stream()
                .max(Comparator.comparing(Hotel :: getRating))
                .orElseThrow(NoSuchElementException::new);
        return bestRated;
    }

    public void viewHotels() {
        getHotelDetails();
    }
}
