package pr2;

import java.util.List;

public class ArraySorter {

    public static List<String> getArraySorted(List<String> allLines) {

        boolean isSorted = false;

        while(!isSorted) {

            isSorted = true;

            for(int i=0;i<allLines.size()-1;i++) {
            if((allLines.get(i).length())<(allLines.get(i+1).length())){
                isSorted = false;
                String buf=allLines.get(i);
                allLines.set(i,allLines.get(i+1));
                allLines.set(i+1, buf);
            }
            }

        }
        return allLines;
    }

}
