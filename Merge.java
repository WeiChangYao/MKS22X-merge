public class Merge{
  public static void mergesort(int[]data){
    mergesort(data,0,data.length-1);//Length MINUS ONE?????????
  }
  private static void mergesort(int[]data, int lo, int hi){
    if (hi <= lo){
      return;
    }
    int mi = lo+(hi-lo)/2;
    mergesort(data,lo,mi);//left
    mergesort(data,mi+1,hi);//right
    merge(data,lo,mi,hi);
  }
  private static void merge(int[] data, int low, int mid, int hig){
    int one = mid-low+1;
    int two = hig - mid;
    int[] ary = new int[one];
    int[] ary2 = new int[two];
    for(int i = 0; i < mid; i++){
      ary[i]=data[i];
    }
    for(int i = 0; mid+1 < hig; i++){
      ary2[i]=data[i];
      mid++;
    }
    int[] ary3 = new int[hig+1];
    int c = 0;
    int c2 = 0;
    int c3 = 0;
    while(c < ary.length & c2 < ary2.length){
      if (ary[c] < ary2[c2]){
        ary3[c3] = ary[c];
        c++;
        c3++;
      }
      else{
        ary[c3] = ary2[c2];
        c2++;
        c3++;
      }
    }
    while(c < ary.length){
      ary3[c3] = ary[c];
      c++;
      c3++;
    }
    while(c2 < ary2.length){
      ary[c3] = ary2[c2];
      c2++;
      c3++;
    }
  }


}
