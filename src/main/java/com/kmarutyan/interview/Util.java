package com.kmarutyan.interview;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.IntStream;

enum PAIR{ KING, QUEEN};

enum SUIT{
    SPADE(0), HEAR(1), DIAMOND(2);

    private int value;
    SUIT(int faceValue){
        this.value = faceValue;
    }
}

public class Util {
    public static <PrintableToString> void print(PrintableToString... args) {
        for(PrintableToString pts: args)
            System.out.print(pts);
    }

    public static void print(String arg) {
        System.out.println(arg);
    }





    public static void main(String [] args){
        List <Integer> bl =  Arrays.asList(2, 4, 6, 9, 48);
        List rbl =  Arrays.asList(48, 9, 6, 4, 1);
        print(Collections.binarySearch(bl, 3));
        print(Collections.binarySearch(bl, 1));
        print(Collections.binarySearch(bl, 2));


        Comparator<Integer>  c = (Integer i, Integer j) ->  (-1)*(i-j);
        Comparator<Integer> c1  = (i1, i2) -> i1.compareTo(i2);
        Runnable r = () -> { int i = 3 + 5; System.out.println("");} ;

        Point point =  new Point(2,4);


        Arrays.asList("q", "a", "b", "c");
        String[] range =  Arrays.copyOfRange(new String[]{"a", "b", "c", "d"}, 0, 2);

        Arrays.copyOf(new String[]{"a", "b", "c", "d"}, 20);
        String[] copiedArray = Arrays.stream(range).toArray(String[]::new);

        print(Collections.binarySearch(bl, 4));
        print(Collections.binarySearch(rbl, 4, c));

        print(bl);
        print(String.valueOf(4));

        IntStream.range(0, 5).min();
        bl.stream().mapToInt(i-> Integer.valueOf(i.toString())).min();
        bl.stream().min(Integer::compare);

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.peek();
        stack.pop();
        stack.empty();

        ArrayList<String> list = new ArrayList<>();
        list.trimToSize();

    }

}
/*

toCharArray() //get char array of a String
charAt(int x) //get a char at the specific index
length() //string length
length //array size
substring(int beginIndex)
substring(int beginIndex, int endIndex)
Integer.valueOf()//string to integer
String.valueOf()/integer to string

    Arrays.sort()  //sort an array
    Arrays.toString(char[] a) //convert to string
    Arrays.copyOf(T[] original, int newLength)

    Arrays.copyOfRange(new String[]{"a", "b", "c", "d"}, 0, 2);
    Arrays.copyOf(new String[]{"a", "b", "c", "d"}, 20); // truncated or padded
    Arrays.deepToString(new String []{"a", "b", "c"})
    Arrays.fill(arrayRef, value )

    System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)

int[] a = {1,2,3,4};
boolean contains = IntStream.of(a).anyMatch(x -> x == 4);

List<Integer> list = Arrays.asList(1, 3, 5);
Integer[] ints = list.stream().toArray(Integer[]::new);
List<Integer> integerList1 = Arrays.stream(intArray).boxed().collect(Collectors.toList());

    list.stream().mapToInt(i -> i).min();
    list.stream().mapToInt(i -> i).max();
    list.stream().mapToInt(i -> i).sum();

    list.stream().min((Integer i1, Integer i2)-> i1 -i2 );

    IntStream.of(1,3,4);
    DoubleStream.of(1,23).sum();


    Comparator<Integer>  c = (Integer i, Integer j) ->  (-1)*(i-j);
    Comparator<Integer> c1  = (i1, i2) -> i1.compareTo(i2);
    Runnable r = () -> { int i = 3 + 5; System.out.println("");} ;


    .forEach(word -> map.compute( word, (k, v) -> (v == null) ? 1l : v+1l) );

 */