package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws FileNotFoundException {

	// reading from text file cities.txt
        File file=new File("src/cities.txt");
        Scanner scanner = new Scanner(file);

        //creating arrays to store cities  with the length cast to integer type
        String [] cities = new String[1000];
        int j=0;
        //as long has cities.txt has items, populate an array to store cities
        while (scanner.hasNextLine() && j< cities.length){
         //System.out.println(scanner.nextLine());
             cities[j]=scanner.nextLine();
             j++;

        }
        //System.out.println(Arrays.toString(cities));


        // reading from text file population.txt
        File secondFile=new File("src/population.txt");
        Scanner scanner2 = new Scanner(secondFile);

        //creating arrays to store population with the length  of array cast to integer type
        int [] population = new int[1000];
        int i=0;
        //as long has population.txt has items, populate an array to store population
        while (scanner2.hasNextInt() && i< population.length){
            //System.out.println(scanner2.nextLine());
            population[i]=scanner2.nextInt();
            i++;

        }
       // System.out.println(Arrays.toString(population));
        //temporary storage for population before storage
        int[] tempPopulation=new int[1000];
        for (int f=0; f< population.length;f++){
            tempPopulation[f]=population[f];
        }

        //converting array to list
        List list=Arrays.asList(tempPopulation);

        //sort the population  array in order to get the largest city
        Arrays.sort(population);
        int largestCity =population[population.length-1]; //last element after sorting
        int secondLargestCity=population[population.length-2];
       // System.out.println(largestCity);
        //System.out.println(Arrays.toString(population));


        //obtaining index of largest before it was sorted
        int indexOfLargest=-1;
        for (int f = 0; f < tempPopulation.length; f++) {
            if (tempPopulation[f] == largestCity) {
                indexOfLargest=f;
            }
        }

       // System.out.println(indexOfLargest);

        //obtaining index of second largest before it was sorted
        int indexOfSecondLargest=-1;
        for (int f = 0; f < tempPopulation.length; f++) {
            if (tempPopulation[f] == secondLargestCity) {
                indexOfSecondLargest=f;
            }
        }


        System.out.println();
        System.out.println();


        System.out.println("U.S Cities Analytics");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Largest City:"+"                    " +cities[indexOfLargest] +" "+"(population"+"  "+largestCity+")");
        System.out.println("second largest City:"+"             " +cities[indexOfSecondLargest] +" "+"(population"+"  "+secondLargestCity+")");


        // reading from text file lat.txt
        File thirdFile=new File("src/lat.txt");
        Scanner scanner3 = new Scanner(thirdFile);

        //creating arrays to store latitude with the  of   type   Double
        Double [] latitude = new Double[1000];
        int w=0;
        //as long has  lat.txt has items, populate an array to store population
        while (scanner3.hasNextDouble() && w< latitude.length){
            //System.out.println(scanner2.nextLine());
            latitude[w]= scanner3.nextDouble();
            w++;

        }
        //System.out.println(Arrays.toString(latitude));


        // reading from text file long.txt
        File fourthFile=new File("src/long.txt");
        Scanner scanner4 = new Scanner(fourthFile);

        //creating arrays to store longitude  of  type   Double
        Double  [] longitude = new   Double[1000];
        int x=0;
        //as long has long.txt has items, populate an array to store population
        while (scanner4.hasNextDouble() && x< longitude.length){
            //System.out.println(scanner2.nextLine());
            longitude[x]= scanner4.nextDouble();
            x++;

        }
      //  System.out.println(Arrays.toString(longitude));

        //array to hold distances
        Double [] distances =new Double[1000];

     for (int f=0; f<latitude.length&& f< longitude.length;f++)  {
         double lat2=latitude[f];
         double lng2=longitude[f];
         double lat1=latitude[indexOfLargest];
         double lng1=longitude[indexOfLargest];


        double earthRadius = 6371; //  kilometer output

         double dLat = Math.toRadians(lat2-lat1);
         double dLng = Math.toRadians(lng2-lng1);

         double sindLat = Math.sin(dLat / 2);
         double sindLng = Math.sin(dLng / 2);

         double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                 * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));

         double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

         double dist = earthRadius * c;


         distances[f]= dist;
     }
    // System.out.println(Arrays.toString(distances));

     //temporary location to store distances before sorting them to identify the smallest
        Double[] tempDistances=new Double[1000];
        for (int f=0;f<distances.length;f++){
            tempDistances[f]=distances[f];
        }


        //sort distances to determine the smallest
        Arrays.sort(distances);
       // System.out.println(Arrays.toString(tempDistances));
       // System.out.println(Arrays.toString(distances));
        Double smallestDistance=distances[1];//second index element

        int indexOfClosestDistance=-1;
        for (int f = 0; f < tempDistances.length; f++) {
            if (tempDistances[f] == smallestDistance) {
                indexOfClosestDistance=f;
            }
        }

       // System.out.println(indexOfClosestDistance);

        String nameOfClosestCity= cities[indexOfClosestDistance ];//next element after new york
        int populationOfClosestCity=tempPopulation[indexOfClosestDistance];
       // System.out.println(nameOfClosestCity);
        //System.out.println(distances[1]);

        System.out.println("");
        System.out.println("");



        System.out.println("U.S Cities Analytics");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Largest City:"+"                    " +cities[indexOfLargest] +" "+"(population"+"  "+largestCity+")");
        System.out.println("second largest City:"+"             " +cities[indexOfSecondLargest] +" "+"(population"+"  "+secondLargestCity+")");
        System.out.println("Closest City to"+" "+cities[indexOfLargest]+": "+"       "+nameOfClosestCity +" "+"(population"+"  "+populationOfClosestCity+")");


    }
}
