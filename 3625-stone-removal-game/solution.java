class Solution {
    public boolean canAliceWin(int n) {
        if(n<10){
            return false;
        }
        int temp = 10;
        boolean alice = true;
        while(n>0){
            n = n-temp;
            temp--;
            if(n<temp){
                return alice;
            }
            alice = !alice;
        }
        return alice;
    }
}
