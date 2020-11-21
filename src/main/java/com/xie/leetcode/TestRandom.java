package com.xie.leetcode;

import java.util.Random;

public class TestRandom {

    public static void main(String[] args) {
//        65.593847, -167.775429
//        66.097855, -63.011964
//        67.276871, -112.797019
//        28.160447, -99.264041

        Random ran = new Random();
        for (int i = 0; i < 1000; i++) {
            double lat = ran.nextDouble() * 30 + 30;
            double lng = -(ran.nextDouble() * 100 + 60);
            System.out.println(String.format("'http://localhost:4666/nominatim/reverse?format=json&lat=%.6f&lon=%.6f'", lat, lng));
        }
    }
}
