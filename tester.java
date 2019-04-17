import java.util.Arrays;

public class tester{
    public static void main(String[] args){
        String[] names = {"Hello", "Jared", "Abricorn"};
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        //sort(names, 0, 1);
        sort(names, names.length);
        sort(arr, arr.length);
        System.out.println(Arrays.toString(names));
        
    }

    public static void sort(String[] names, int index, int nextIndex){
        if(index > names.length){
            return;
        } else{
            if(names[index].compareTo(names[nextIndex]) >= 0){
                String temp = names[index];
                names[index] = names[nextIndex];
                names[nextIndex] = temp;
            }
            sort(names, index++, nextIndex++);
        }
    }
    public static void sort(String[] names, int n){
        if(n == 1){
            return;
        } else {
            for(int i = 0; i < n-1; i++){
                if(names[i].compareTo(names[i+1]) >= 0){
                    String temp = names[i];
                    names[i] = names[i+1];
                    names[i+1] = temp;
                }
            }
            sort(names, n-1);
        }
    }
    public static void sort(int[] names, int n){
        if(n == 1){
            return;
        } else{
           for (int i =0; i < n-1; i++){
            if(names[i] > names[i+1]){
                int temp = names[i];
                names[i] = names[i+1];
                names[i+1] = temp;
            }
           }
           sort(names, n-1);
        }
    }
}