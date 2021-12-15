package molod.yuliya.project;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Main class
 * @author Molod Yuliya
 * @version 1.0
 */
public class Main{
    /**
     * Main method
     * @param args main arguments
     */
    public static void main(String[] args) throws IOException, CsvValidationException {
        String filePath = "C:\\Users\\User\\Downloads\\foreign_names\\foreign_names.csv";
        String separator = ";";
        List <Person> personList = new ArrayList <> ();
        try (InputStream in = Main.class.getClassLoader().getResourceAsStream(filePath)){
            CSVReaderBuilder csvReaderBuilder = new CSVReaderBuilder(new FileReader(filePath));
            CSVReader csvReader = csvReaderBuilder.withSkipLines(1).build();
            if (csvReader == null)
                throw new FileNotFoundException(filePath);
               String[] nextLine;
               while ((nextLine = csvReader.readNext()) != null) {
                   nextLine = nextLine[0].split(separator);
                   if (nextLine.length > 2){
                       Person person = new Person(nextLine[0], nextLine[1], nextLine[2], nextLine[3], nextLine[5], new Subdivision(nextLine[4].charAt(0) - 'A', nextLine[4]));
                       personList.add(person);
                   }
               }
        }
        catch(FileNotFoundException | CsvValidationException e){
            e.printStackTrace();
        }
        finally {
            System.out.printf("%-8s%-16s%-8s%-12s%-6s%-6s%-8s%n", "Id", "Name", "Sex", "Date", "SubD", "SDId", "Salary");
            for(int index = 1; index < personList.size(); index++){
                System.out.printf("%-8s", personList.get(index).getId());
                System.out.printf("%-16s", personList.get(index).getName());
                System.out.printf("%-8s", personList.get(index).getSex());
                System.out.printf("%-12s", personList.get(index).getDate());
                System.out.printf("%-6s", personList.get(index).getDivision().divisionGetName());
                System.out.printf("%-6s", personList.get(index).getDivision().divisionGetId());
                System.out.printf("%-8s", personList.get(index).getSalary());
                System.out.println();
            }
        }
    }
}

