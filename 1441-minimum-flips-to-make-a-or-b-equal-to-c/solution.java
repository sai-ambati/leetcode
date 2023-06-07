class Solution {
    public int minFlips(int a, int b, int c) {
        int count=0;

        int tempA;
        int tempB;
        int tempC;
        for(int i =0; i<32; i++){
            tempA = (a&(1<<i))>0 ? 1:0;
            tempB = (b&(1<<i))>0 ? 1:0;
            tempC = (c&(1<<i))>0 ? 1:0;

            // System.out.println("tempA: "+tempA +"\t tempB: "+tempB + "\t tempC: "+tempC);
            if((tempA | tempB) != tempC){
                if(tempC == 1){
                    count++;
                    
                }
                else{
                    if(tempA == 1 && tempB ==1){
                        count += 2;
                    }
                    
                    else if((tempA ==1 && tempB == 0) || (tempA == 0 && tempB  ==1)){
                        count++;
                    }
                }
            }
            // System.out.println(i+ " " + count);
        }

        return count;

    }
}
