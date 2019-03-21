import java.util.Arrays;
public class Merge{
  public static void mergesort(int[]data){
    mergesort(data,0,data.length-1);//Length MINUS ONE?????????
  }
  private static void mergesort(int[]data, int lo, int hi){
    if (hi <= lo){
      return;
    }
    int mi = (hi+lo)/2;
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
      ary[i]=data[low+i];
    }
    for(int i = 0; mid+1 < hig; i++){
      ary2[i]=data[mid+1+i];
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
 //Sort testing code
  private static final int INCREASE = 0;
  private static final int DECREASE = 1;
  private static final int STANDARD = 2;
  private static final int SMALL_RANGE = 3;

  private static String name(int i){
    if(i==INCREASE)return "Increassing";
    if(i==DECREASE)return "Decreassing";
    if(i==STANDARD)return "Normal Random";
    if(i==SMALL_RANGE)return "Random with Few Values";
    return "Error categorizing array";

  }

  private static int create(int min, int max){
    return min + (int)(Math.random()*(max-min));
  }

  private static int[]makeArray(int size,int type){
    int[]ans =new int[size];
    if(type == STANDARD){
      for(int i = 0; i < size; i++){
        ans[i]= create(-1000000,1000000);
      }
    }
    else if(type == INCREASE){
      int current = -5 * size;
      for(int i = 0; i < size; i++){
        ans[i]= create(current,current + 10);
        current += 10;
      }
    }
    else if(type == DECREASE){
      int current = 5 * size;
      for(int i = 0; i < size; i++){
        ans[i]= create(current,current + 10);
        current -= 10;
      }
    }
    else if(type == SMALL_RANGE){
      for(int i = 0; i < size; i++){
        ans[i]= create(-5,5);
      }
    }
    else{
      ans = new int[0];//empty is default
    }
    return ans;
  }

  public static void main(String[]args){
    if(args.length < 2)return;
    
    int size =  Integer.parseInt(args[0]);
    int type =   Integer.parseInt(args[1]);

    int [] start = makeArray(size,type);
    int [] result = Arrays.copyOf(start,start.length);
    Arrays.sort(result);
    
    long startTime = System.currentTimeMillis();
    mergesort(start);
    long elapsedTime = System.currentTimeMillis() - startTime;
    if(Arrays.equals(start,result)){
      System.out.println("PASS Case "+name(type)+"\t array, size:"+start.length+"\t"+elapsedTime/1000.0+"sec ");
    }else{
      System.out.println("FAIL ! ERROR ! "+name(type)+" array, size:"+size+"  ERROR!");
    }
  }

}
