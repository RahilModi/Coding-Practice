package com.programming.leetcode.Hard;

//https://leetcode.com/problems/consecutive-numbers-sum/discuss/129015/5-lines-C%2B%2B-solution-with-detailed-mathematical-explanation.
public class ConsecutiveNumberSum {

    //O(N) => TLE...
    public int consecutiveNumbersSum(int N) {
        int ans = N > 2 ? 1 : 0, sum = 0, begin = 1, crt = 1;
        while (crt <= (N+1)/2){
            if(sum == N) ans++;
            sum += crt++;
            while (sum > N) sum-=begin++;
        }
        if(sum == N) ans++;
        return ans;
    }

    /*
    Credit : pavan5 (leetcode)
    The thought process goes like this- Given a number N, we can possibly write it as a sum of 2 numbers, 3 numbers, 4 numbers and so on. Let's assume the fist number in this series be x. Hence, we should have
    x + (x+1) + (x+2)+...+ k terms = N
    kx + k*(k-1)/2 = N implies
    kx = N - k*(k-1)/2
    So, we can calculate the RHS for every value of k and if it is a multiple of k then we can construct a sum of N using k terms starting from x.
    Now, the question arises, till what value of k should we loop for? That's easy. In the worst case, RHS should be greater than 0. That is
    N - k*(k-1)/2 > 0 which implies
    k*(k-1) < 2N which can be approximated to
    k*k < 2N ==> k < sqrt(2N)
    Hence the overall complexity of the algorithm is O(sqrt(N))
     */
    public int consecutiveNumbersSumV1(int N) {
        int count = 1;
        for( int k = 2; k < Math.sqrt( 2 * N ); k++ ) {
            if ( ( N - ( k * ( k - 1 )/2) ) % k == 0) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        ConsecutiveNumberSum obj = new ConsecutiveNumberSum();
        System.out.println(obj.consecutiveNumbersSum(1));
        System.out.println(obj.consecutiveNumbersSum(5));
        System.out.println(obj.consecutiveNumbersSum(9));
        System.out.println(obj.consecutiveNumbersSum(15));
    }

}
