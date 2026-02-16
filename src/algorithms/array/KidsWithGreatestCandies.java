package algorithms.array;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> arr=new ArrayList<>();
        int max=candies[0];
        for (int i=0;i<candies.length;i++){
            if(max<candies[i]){
                max=candies[i];
            }
        }

        for (int i=0;i<candies.length;i++){
            if(candies[i]+extraCandies>=max){
                arr.add(true);
            }
            arr.add(false);
        }
        return arr;
    }
    public static void main(String args[]){

    }
}
