class Solution {
    public int minimumCost(int[] nums, int k) {
        long ans = 0;
        long mod = 1000000007;
        long i = 0;

        long cur = k;

        for(long x:nums){
            // while(cur < x){
            //     i++;
            //     cur += k;
            //     ans = (ans%mod + i%mod)%mod;
            // }
            if(cur < x){
                long diff = x-cur;

                long steps=0;

                if(diff%k == 0){
                    steps = diff/k;
                }
                else{
                    steps = diff/k+1;
                }
        
                long ft = (i+1)%mod;
                long lt = (i+steps)%mod;

                long temp = ((steps%mod*(ft + lt))/2)%mod;

                ans = (ans%mod + temp%mod)%mod;

                i += steps;

                cur += steps * k;
                // System.out.print(steps + " " + i+" ");
            }

            cur -= x;

            // System.out.println(x + " " + i);
        }

        return (int)ans;
    }
}
