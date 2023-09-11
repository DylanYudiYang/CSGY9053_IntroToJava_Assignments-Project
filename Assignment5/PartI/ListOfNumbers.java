import java.io.*;
import java.util.List;
import java.util.ArrayList;
 
public class ListOfNumbers {
	
    private ArrayList rdfTripleList;
    private String fileName;
 
    public ListOfNumbers () {
        // create an ArrayList of Pairs of Integers
    	rdfTripleList = new ArrayList<RDFTriple<Integer, Integer, Integer>>();
    }
    
    public ArrayList getRdfTripleList() {
    	return this.rdfTripleList;
    }
    
    //Method I add to see content in rdfTripleList without writing it to outFile.txt
    public void printRdfTripleList() {
        for (int i = 0; i < rdfTripleList.size(); i++)
            System.out.println(((RDFTriple<Integer, Integer, Integer>) rdfTripleList.get(i)).getSubj() + " " + ((RDFTriple<Integer, Integer, Integer>) rdfTripleList.get(i)).getPred()+ " " + ((RDFTriple<Integer, Integer, Integer>) rdfTripleList.get(i)).getObj());
    }
    
    public void createList() {
    	for (int i = 0 ; i< 100 ; i++) {
    		Integer number1 = (int) (Math.random()*10000);
    		Integer number2 = (int) (Math.random()*10000);
    		Integer number3 = (int) (Math.random()*10000);
    		// fill the existing list with RDFTriple objects
    		// of three numbers.
    		RDFTriple<Integer, Integer, Integer> triple = new RDFTriple<Integer, Integer, Integer>(number1, number2, number3);
    		rdfTripleList.add(triple);
    	}
    }
    

    public ListOfNumbers (String fileName) {
    	this();
    	this.fileName = fileName;	
    }
    
    public void readList() {
        rdfTripleList = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                String[] nums = line.split(" ");
                Integer num1 = Integer.parseInt(nums[0]);
                Integer num2 = Integer.parseInt(nums[1]);
                Integer num3 = Integer.parseInt(nums[2]);
                rdfTripleList.add(new RDFTriple<Integer, Integer, Integer>(num1, num2, num3));
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format: " + e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing file: " + e.getMessage());
            }
        }
    }

    
    public void writeList() {
        PrintWriter out = null;
        String outFile = "outFile.txt";
        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter(outFile));
            for (int i = 0; i < rdfTripleList.size(); i++)
                out.println(((RDFTriple<Integer, Integer, Integer>) rdfTripleList.get(i)).getSubj() + " " + ((RDFTriple<Integer, Integer, Integer>) rdfTripleList.get(i)).getPred()+ " " + ((RDFTriple<Integer, Integer, Integer>) rdfTripleList.get(i)).getObj());
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " +
                                 e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }
    
    public static void cat(String fileName) throws IOException {
        RandomAccessFile input = null;
        String line = null;
        File file = new File(fileName);
        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            return;
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
    	ListOfNumbers listOfNumbers = new ListOfNumbers("numberfile.txt");
    	System.out.println("------------ Test cat ------------");
    	ListOfNumbers.cat("numberfile.txt");
    	System.out.println("------------ Test readList ------------");
    	listOfNumbers.readList();
    	System.out.println("Read numberfile.txt to rdfTripleList");
    	System.out.println("------------ Test writeList ------------");
    	listOfNumbers.writeList();    	
    	System.out.println("------------ Test createList ------------");   	
    	listOfNumbers.createList();
    	listOfNumbers.printRdfTripleList(); // print current rdfTripleList
    	
    }

}
