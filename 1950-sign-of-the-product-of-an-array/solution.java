class Solution {
    public int arraySign(int[] nums) {
        int product=1;
        for(int x:nums){
            product *= x;
            if(product>0){
                product =1;
            }
            else if(product<0){
                product = -1;
            }
            else{
                product=0;
            }
        }
        return product;
    }
}
