package week1;

public class Counter {

   private int count;

   private int[] counterRecord = new int[5];

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

   private void recordCount() {

        for(int i = 0; i < 4; i++) {
               counterRecord[i] = counterRecord[i + 1];
               counterRecord[4] = count;
        }

   }
    
}//end of main class