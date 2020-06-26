package pr2;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Tester {
    private static ArrayKeeper arrayKeeper;
    private static ArraySorter arraySorter = new ArraySorter();
    private static List<String>testString = new ArrayList<>();

    @Test
    public void testReadFile(){
        File fileToReadCorrect = new File("C:/Users/gukan/IdeaProjects/Pr2/src/input.txt");
        Boolean correctFile=arrayKeeper.readFile(fileToReadCorrect);
        File fileToReadIncorrect = new File("C:/Users/gukan/IdeaProjects/Pr2/src/input12.txt");
        Boolean incorrectFile=arrayKeeper.readFile(fileToReadIncorrect);
        Assert.assertEquals(true, correctFile);
        Assert.assertEquals(false, incorrectFile);
    }

    @Test
    public void testRepeatsFinder()
    {
        testString.clear();
        testString.add("TestLine");
        testString.add("testLine");
        testString.add("array should be created");
        testString.add("test team");
        testString.add("tttt");
        testString.add("mrewkvmrgtkttttmbktenbjtbtt");
        List<String> testStringResult = new ArrayList<>();
        testStringResult = arrayKeeper.findLinesWithRepeats(testString, 2 , "t");
        testString.remove(0);
        testString.remove(2);
        Assert.assertEquals(testString, testStringResult);
    }

    @Test
    public  void testArrayInitSize5(){
        List<String>EmptyArray = new ArrayList<>();
        arrayKeeper.setArray(EmptyArray);
        arrayKeeper = new ArrayKeeper(5);
        Assert.assertEquals(5, arrayKeeper.getArray().size());
    }

    @Test
    public  void testArraySorter(){
        testString.clear();
        testString.add("testLine");
        testString.add("test team");
        testString.add("tttt");
        testString.add("mrewkvmrgtkttttmbktenbjtbtt");
        List<String> testStringResult = new ArrayList<>();
        testStringResult = arraySorter.getArraySorted(testString);
        testString.clear();
        testString.add("tttt");
        testString.add("testLine");
        testString.add("test team");
        testString.add("mrewkvmrgtkttttmbktenbjtbtt");
        Assert.assertEquals(testString,testStringResult);
    }

}
