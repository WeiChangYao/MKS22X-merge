import java.util.Arrays;
public class Merge{
  public static void mergesort(int[]data){
    mergesort(data,0,data.length-1);
  }
  public static void iSort(int[]data){
    insertionSort(data, 0, data.length-1);
  }

  public static void insertionSort(int[] ary,int lo, int hi){
   for (int i = lo; i < hi; i++){
     int swap = ary[i];                   //saves that integer
     for (int j = i; !(j == -1); j--){
       if (j == 0) {                      //once it hits the end, it puts it in
         ary[j] = swap;
       } else{
       if (swap < ary[j-1]){              //check number before
         ary[j] = ary[j-1];               //put the thing before over there (j)
       }
       else{                              //check number before
         ary[j] = swap;                   //put the saved number there
         j = 0;                           //this way, j turns into 0 when this ends and ends the for loop
       } }
     }
   }
 }

  private static void mergesort(int[]data, int lo, int hi){
    if (lo >= hi){
      return;
    }
    else{
      int mi = (hi+lo)/2;
      mergesort(data,lo,mi);//left
      mergesort(data,mi+1,hi);//right
      merge(data,lo,mi,hi);
    }
  }
  private static void merge(int[] data, int low, int mid, int hig){
    int one = mid-low+1;
    int two = hig - mid;
    int[] ary = new int[one];
    int[] ary2 = new int[two];
    for(int i = 0; i < one; i++){
      ary[i]=data[low+i];
    }
    for(int i = 0; i < two; i++){
      ary2[i]=data[mid+1+i];
    }
    int c = 0;
    int c2 = 0;
    int c3 = low;
    while(c < one && c2 < two){
      //put the lower number
      if (ary[c] < ary2[c2]){
        data[c3] = ary[c];
        c++;
      }
      else{
        data[c3] = ary2[c2];
        c2++;
      }
      c3++;
    }
    //put the rest in
    while(c < one){
      data[c3] = ary[c];
      c++;
      c3++;
    }
    while(c2 < two){
      data[c3] = ary2[c2];
      c2++;
      c3++;
    }
  }
}
