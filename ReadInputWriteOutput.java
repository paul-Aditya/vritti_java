import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;

public class ReadInputWriteOutput {
    public ArrayList<Integer> readInput(String inputPath){
        ArrayList<Integer> list = new ArrayList<>();

        try(BufferedReader line= new BufferedReader(new FileReader(inputPath)))
        {
            String str;
            while((str=line.readLine())!=null){
                try{
                    list.add(Integer.parseInt(str));
                }
                catch(NumberFormatException e){
                    System.out.println("line is not an Integer: "+ str);
                    return new ArrayList<>();
                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Such File is not found"+ inputPath);
        }
        catch(IOException e){
            System.out.println("Doesn't have the permission to read the file");
        }

        return list;
    }

    public boolean writeOutput(String outputPath, int sum, double average){
        try( BufferedWriter wrt = new BufferedWriter(new FileWriter(outputPath))){
            wrt.write("sum :"+ sum +"\n");
            wrt.write("average :"+ average +"\n");
            return true;
        }
        catch(IOException e){
            System.out.println("Doesn't have the permission to write the write");
            return false;
        }
    }
}
