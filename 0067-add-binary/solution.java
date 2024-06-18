class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;

        int i = a.length()-1;
        int j = b.length()-1;

        StringBuilder sb = new StringBuilder();

        while(i >= 0 || j >= 0){
            int sum = 0;

            if(i>=0){
                sum += a.charAt(i) - '0';
            }
            if(j >= 0){
                sum += b.charAt(j) - '0';
            }

            sum += carry;
            carry = sum/2;
            sum = sum%2;

            sb.append(sum);
            i--;
            j--;
        }

        if(carry != 0){
            sb.append(carry);
        }

        return new String(sb.reverse());
    }
}
