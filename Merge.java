public class Merge{
  public static void mergesort(int[]data){
    return mergesort(data,0,data.length-1);//Length MINUS ONE?????????
  }
  private static void mergesort(int[]data, int lo, int hi){
    if (hi <= lo){
      return;
    }
    /*int mid = 0;
    if (data.length%2 == 1){
      mid = data.length/2;
    }
    else{
      mid = data.length/2-1;
    }*/
    mergesort(data,lo,lo+(hi-lo)/2);//left
    mergesort(data,lo+1,hi);//right

  }
}
