/*
Faulty version, I misunderstood the question?

https://www.tutorialspoint.com/intstream-average-method-in-java

https://stackoverflow.com/questions/80476/how-can-i-concatenate-two-arrays-in-java

http://www.java2s.com/Tutorials/Java_Streams/Example/IntStream/Convert_int_array_to_IntStream.htm

https://www.tutorialspoint.com/java/lang/system_arraycopy.htm
*/

//import org.apache.commons.lang3.ArrayUtils;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.OptionalDouble;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //int[] nums = ArrayUtils.addAll(nums1, nums2);
        int[] nums = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, nums, 0, nums1.length);
        System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);
        IntStream numStream = Arrays.stream(nums);
        OptionalDouble avg = numStream.average();
        //double avg = numStream.average();
        return avg.getAsDouble();
    }
    /*
    public static void main(String[] args) {
        int[] n1 = {3};
        int[] n2 = {-2,-1};
        System.out.println(Solution(n1, n2));
        */
}

