package org.example;

import java.util.Scanner;

public class TrappingRainWater {
    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int lMax = 0;
        int rMax = 0;

        int water = 0;

        while (left <= right) {

            lMax = Math.max(height[left], lMax);
            rMax = Math.max(height[right], rMax);

            if (lMax < rMax) {
                water = water + lMax - height[left++];
            } else {
                water = water + rMax - height[right--];
            }
        }
        return water;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci la lunghezza dell'array height (compresa tra 1 e 2 * 10^4):");
        int length = scanner.nextInt();

        if (length < 1 || length > 2 * Math.pow(10, 4)) {
            System.out.println("La lunghezza dell'array non è valida.");
            return;
        }

        int[] height = new int[length];

        System.out.println("Inserisci gli elementi dell'array height (compresi tra 0 e 10^5):");
        for (int i = 0; i < length; i++) {
            int h = scanner.nextInt();

            if (h < 0 || h > Math.pow(10, 5)) {
                System.out.println("Il valore inserito non è valido.");
                return;
            }

            height[i] = h;
        }

        TrappingRainWater solution = new TrappingRainWater();
        int result = solution.trap(height);

        System.out.println("La quantità totale di acqua trattenuta è: " + result);

        scanner.close();
    }
}
