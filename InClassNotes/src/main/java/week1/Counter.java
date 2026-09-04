package week1;

public class Counter {

   private int count;

   public Counter() {
        count = 0;
   }

   public Counter(int count) {
        this.count = count;
   }

   public int getCount() {
        return this.count;
   }

   public void increment() {
        count = count + 1;
        recordCount();
   }

   public void increment(int delta) {
        count = count + delta;
        recordCount();
   }

   public void reset() {
        count = 0;
        recordCount();
   }

   public static void recordCount() {

        int[] counterRecord = new int[5];

        for(int i = 0; i < 5; i++) {

              counterRecord[i] = 

        }

   }
    


    //9. Add a fixed-size history array that records the last 5 states of the counter. All logic must happen inside of the object and be hidden from the user.
}//end of main class