import java.util.ArrayList;

public class sebsequence {
    public void subsecence(int idx , int[] arr , ArrayList<Integer> list){
        if(idx == arr.length){
            for(Integer it : list){
                System.out.print(it + " ");
            }
            System.out.println();
            return;
        }

        int curr = arr[idx];
        list.add(curr);
        subsecence(idx + 1, arr, list);
        list.remove(list.size() - 1);

        subsecence(idx + 1, arr, list);
        return;
    }
    public static void main(String[] args){
        int[] arr = {3 , 1 ,2};
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        sebsequence ans = new sebsequence();
        ans.subsecence(0, arr, list);
    }
}
