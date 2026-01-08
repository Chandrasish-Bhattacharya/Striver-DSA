// Fruit Into Baskets

// Problem Statement: There is only one row of fruit trees on the farm, oriented left to right. An integer array called fruits represents the trees, where fruits[i] denotes the kind of fruit produced by the ith tree.
// The goal is to gather as much fruit as possible, adhering to the owner's stringent rules :

// There are two baskets available, and each basket can only contain one kind of fruit. The quantity of fruit each basket can contain is unlimited.
// Start at any tree, but as you proceed to the right, select exactly one fruit from each tree, including the starting tree. One of the baskets must hold the harvested fruits.
// Once reaching a tree with fruit that cannot fit into any basket, stop.
// Return the maximum number of fruits that can be picked.

// Input :fruits = [1, 2, 1]
// Output :3
// Explanation : We will start from first tree.
// The first tree produces the fruit of kind '1' and we will put that in the first basket.
// The second tree produces the fruit of kind '2' and we will put that in the second basket.
// The third tree produces the fruit of kind '1' and we have first basket that is already holding fruit of kind '1'. So we will put it in first basket.
// Hence we were able to collect total of 3 fruits.

// Input : fruits = [1, 2, 3, 2, 2]
// Output : 4
// Explanation : we will start from second tree.
// The first basket contains fruits from second , fourth and fifth.
// The second basket will contain fruit from third tree.
// Hence we collected total of 4 fruits.

import java.util.HashMap;
import java.util.HashSet;

public class FruitIntoBaskets {
    public int bruteForce(int[] fruits) {
        int maxFruit = 0;
        for (int i = 0; i < fruits.length; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j < fruits.length; j++) {
                set.add(fruits[j]);
                maxFruit = Math.max(maxFruit, j - i + 1);
                if (set.size() > 2) {
                    break;
                }
            }
        }
        return maxFruit;
    }

    public int better(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap();
        int l = 0, r = 0, maxFruit = 0;
        while (r < fruits.length) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 1) + 1);

            while (map.size() > 2) {
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(l) == 0) {
                    map.remove(fruits[l]);
                }

                l++;

            }
            maxFruit = Math.max(maxFruit, r - l + 1);
            r++;
        }
        return maxFruit;
    }

    public int optimal(int[] fruits){
        int l = 0 , r = 0 , maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap();

        while(r < fruits.length){
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            if(map.size() > 2){
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if(map.get(fruits[l]) == 0) map.remove(fruits[l]);
                    l++;
            }
            if(map.size() <= 2) maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        FruitIntoBaskets obj = new FruitIntoBaskets();
        int[] fruits = { 1, 2, 3, 2, 2 };
        System.out.println(obj.optimal(fruits)); // Output: 3
    }
}
