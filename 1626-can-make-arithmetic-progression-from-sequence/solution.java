import java.util.*;
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        boolean flag=true;
        int p[]=new int[arr.length-1];
        for(int i=0;i<arr.length-1;i++){
            p[i]=arr[i+1]-arr[i];
        }
        for(int j=0;j<(p.length-1);j++){
            if(p[j] != p[j+1]){
                flag=false;
                break;
            }
        }
        return flag;
    }
}
