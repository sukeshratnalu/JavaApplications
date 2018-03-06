import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetExample {
    public static void main(String args[]){
        int count[]={10,20,30,30,40,50,60,30,40,10};
        System.out.println("Before entering to Set: "+ count);
        Set set = new HashSet();
        try{
            for(int i = 0; i< count.length; i++){
                set.add(count[i]);
            }
            System.out.println("After entering to Set: "+set);
            SortedSet sortedSet = new TreeSet(set);
            System.out.println("After sorting set: " + sortedSet);
            System.out.println("first Element: " + sortedSet.first());
            System.out.println("last Element: " + sortedSet.last());
            System.out.println("is 10 contains: " + set.contains(10));
            System.out.println("is set empty: " + set.isEmpty());
            System.out.println("size of set: " + set.size());
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
