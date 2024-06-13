import java.util.ArrayList;

public class FileReadWrite {
    public static void main(String[] args) {
        String inputFile = "F:\\abc.txt";
        String outputFile = "F:\\result.txt";

        ReadInputWriteOutput fileProcessor = new ReadInputWriteOutput();

        ArrayList<Integer> numbers = fileProcessor.readInput(inputFile);

        if (!numbers.isEmpty()) {
            int sum = calculateSum(numbers);
            double average = calculateAverage(sum, numbers);

            boolean isWritten = fileProcessor.writeOutput(outputFile, sum, average);
            if (isWritten) {
                System.out.println("Written successfully");
            } else {
                System.out.println("couldn't write successfully");
            }
        } else {
            System.out.println("File is corrupt");
        }
    }
}
    private static int calculateSum(ArrayList<Integer> numbers){
        int sum =0;
        for(int num:numbers){
            sum = sum+ num;
        }
        return sum;
    }

    private static double calculateAverage(int sum,ArrayList<Integer> numbers){
        return (double)sum/numbers.size();
    }
}

