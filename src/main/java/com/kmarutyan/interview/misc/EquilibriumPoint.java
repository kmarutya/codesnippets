package com.kmarutyan.interview.misc;

import java.util.Arrays;

public class EquilibriumPoint {

    public static int findEquilibrium(int [] data){
        //sanity checks
        if (data ==  null  || data.length < 3 ){
            return -1;
        }

        int n = data.length;
        int [] partSums  = Arrays.copyOf(data, n);
        Arrays.parallelPrefix(partSums, (a,b) -> a+b);

        int totalSum  = Arrays.stream(data).sum();

//        System.out.println(Arrays.deepToString( Arrays.stream(data).boxed().toArray( Integer[]::new )));
//        System.out.println(Arrays.deepToString( Arrays.stream(partSums).boxed().toArray( Integer[]::new )));
        for(int i = 1; i < data.length -1; i++){
            int leftSum = partSums[i-1];
            int rightSum =   totalSum - partSums[i-1] - data[i];
//            System.out.println(String.format("%d %d", i, data[i]) );
//            System.out.println(String.format("Left sum = %d, right sum = %d", leftSum, rightSum));
            if( leftSum == rightSum){
                return i;
            }
        }

        return -1;
    }
    public static int findEquilibriumPositiveNums(int [] data){
        int n = data.length;
        int left = 0;
        int right = n-1;
        int eqp = (right - left)/2;
        int [] checkedIndecies = new int [n];
        while(true){
          eqp = left + (right - left)/2;
            System.out.println(String.format("Current point %d . left = %d, right = %d ", eqp, left, right));

            if(checkedIndecies[eqp] > 0){
            eqp = -1;
            break;
          }
          else
              checkedIndecies[eqp] = 1;
          int sumLeft = Arrays.stream(Arrays.copyOfRange(data, 0, eqp )).sum();
          int sumRight = Arrays.stream(Arrays.copyOfRange(data, eqp+1, n)).sum();
          System.out.println(String.format("Current point %d . Sum left = %d, sum right = %d ", eqp, sumLeft, sumRight));
          if(sumLeft == sumRight) {
              break;
          }
          else if (sumLeft < sumRight){
              left = eqp;
          }
          else{
              right = eqp;
          }
        }
        return eqp;
    }

    public static void main(String[] args){

        System.out.println(String.format("Equilibrium point is %d", findEquilibrium(new int []{1,3 ,4, 2,4})));
        System.out.println(String.format("Equilibrium point is %d", findEquilibrium(new int []{1,3, 5, 2, 2})));
        System.out.println(String.format("Equilibrium point is %d", findEquilibrium( new int[]{ -7, 1, 5, 2, -4, 3, 0 })));
        System.out.println(String.format("Equilibrium point is %d", findEquilibrium( new int[]{ -7, 1, 5, 2, 3, -4, 3, 1 })));

    }
}
