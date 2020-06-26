package pr2;

import java.io.*;
import java.util.Scanner;

public class Main {

    private static File fileToRead = new File("C:/Users/gukan/IdeaProjects/Pr2/src/input.txt");
    private static File fileToWriteArr = new File("C:/Users/gukan/IdeaProjects/Pr2/src/input.txt");
    private static File fileToWriteResArr = new File("C:/Users/gukan/IdeaProjects/Pr2/src/output.txt");

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Symbol to find: ");
        String toFind = scanner.nextLine();
        System.out.println("Array size: ");
        int sizeOfArray = scanner.nextInt();
        System.out.println("Number pf repeats to find: ");
        int numberOfRepeats= scanner.nextInt();

        ArrayKeeper arrayKeeper = new ArrayKeeper(sizeOfArray);
        arrayKeeper.writeFile(fileToWriteArr);
        ArraySorter arraySorter = new ArraySorter();
        arrayKeeper.readFile(fileToRead);
        arrayKeeper.findLinesWithRepeats(arrayKeeper.getArray(), numberOfRepeats,toFind);
        ArrayKeeper.setArray(arraySorter.getArraySorted(arrayKeeper.getArray()));

        if(ArrayKeeper.getArray().size()==0){
            System.out.println("No repeats found");
        }
        else {
            if (arrayKeeper.writeFile(fileToWriteResArr)) {System.out.println("\nSuccessfully wrote to the file: "+fileToWriteResArr+"\n");
                System.out.println("Sorted Array: ");
                for(String line : arrayKeeper.getArray()) {
                    System.out.println(arrayKeeper.getArray().indexOf(line) +" " + line);

                }}
        }


    }
}


