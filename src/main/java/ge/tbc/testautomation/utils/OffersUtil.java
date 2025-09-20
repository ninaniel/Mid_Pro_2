//package ge.tbc.testautomation.utils;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Random;
//
//public class OffersUtil {
//    static Random random;
//
//    public static List<Integer> getRandomIndicesOfMaxCount(int offersCount, int maxCount) {
//        random = new Random();
//
//        int count = Math.min(maxCount, offersCount);
//
//        List<Integer> indices = new ArrayList<>();
//        for (int i = 0; i < offersCount; i++) {
//            indices.add(i);
//        }
//        Collections.shuffle(indices, random);
//
//        // take up to maxCount
//        return new ArrayList<>(indices.subList(0, count));
//    }
//}
