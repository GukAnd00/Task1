package pr2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayKeeper {

    private static List<String> allLines = new ArrayList<String >();

    public static void setArray( List<String> allLines) {
        ArrayKeeper.allLines = allLines;
    }

    public static  List<String> getArray(){
        return allLines;
    }

    public ArrayKeeper(int sizeOfArray) {
        List<String>TempArray = new ArrayList<String>();
        String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
        String CHAR_UPPER = CHAR_LOWER.toUpperCase();
        String NUMBER = "0123456789";
        String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;

        for (int l=0;l<sizeOfArray;l++){
            int lenghtOfLine=0;
            int min = 1;
            int max = 20;
            int diff = max - min;
            Random random = new Random();
            lenghtOfLine = random.nextInt(diff + 1) ;
            lenghtOfLine += min;
        if (lenghtOfLine< 1) throw new IllegalArgumentException();

        StringBuilder sb = new StringBuilder(lenghtOfLine);
        for (int u = 0; u < lenghtOfLine; u++) {
            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);

            sb.append(rndChar);
        }
            allLines.add(sb.toString());
        }
    }

    public static boolean readFile(File fileToRead){
        try {
            FileReader fr = new FileReader(fileToRead);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while(line!=null){
                allLines.add(line);
                line=reader.readLine();

            }return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<String> findLinesWithRepeats(List<String> allLines, int numberOfRepeats, String toFind){

        int k=0;
        while (k<allLines.size())
        {
            int i=0;
            int numberOfFindedRepeats=0;
            while(i<allLines.get(k).length()){
                if (allLines.get(k).substring(i,i+1).equals(toFind))
                { numberOfFindedRepeats++;}
                i++;
            }
            if (numberOfFindedRepeats<numberOfRepeats){allLines.remove(k);}
            else {k++;}
        }
        return allLines;
    }

    public static boolean writeFile(File fileToWrite){
        try {
            FileWriter myWriter = new FileWriter(fileToWrite);
            for (int i=0; i<allLines.size();i++){
                myWriter.write(allLines.get(i)+"\n");
                }
            myWriter.close();
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }

    }

}
