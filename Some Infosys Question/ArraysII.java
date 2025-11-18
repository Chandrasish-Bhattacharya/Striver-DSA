// You are given an array ARR which has N integers. You want to construct a new array RES using ARR by following the below algorithm:
// 1. 	Initially, RES is empty
// 2. 	Start at any index of ARR
// 3. 	Choose a direction (left or right) and iterate over the elements of ARR starting from the chosen index in the chosen direction
// 4. 	Add each iteration element to the end of the RES
// Additionally, it is given that the array ARR is cyclic. 
// This means that after the last element you will iterate to the first one and vice versa. 
// The value of RES is the sum of the bitwise XOR value of all the prefixes of it. 
// That means the value of RES can be defined as follows:
// value(RES) = RES[0] + (RES[0]^RES[1]) + (RES[0]^RES[1]^RES[2]) + ............ + (RES[0]^RES[1]^RES[2]......^RES[N-1])
// Find the maximum possible value of RES.
// I/P: N = 10 , ARR = [7 8 5 5 9 2 2 0 1 6]
// O/P: 99
// RES = [5 8 7 6 1 0 2 2 9 5]
// value(RES) = 5 + (5^8) + (5^8^7) + .......
// value(RES) = 5 + 13 + 10 + 12 + 13 + 13 + 13 + 13 + 13 + 13
public class ArraysII {
    public static int sol(int[] arr){
        int[] res = new int[arr.length];
        
    }
    public static void main(String[] args) {
        System.out.println(5^8);
    }
}
