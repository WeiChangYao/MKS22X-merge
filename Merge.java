import java.util.Arrays;
public class Merge{
  public static void mergesort(int[]data){
    mergesort(data,0,data.length-1);
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
