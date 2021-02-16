import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws IOException {
       Path path = FileSystems.getDefault().getPath("//sapdata/bi$/DEV"); //("src" + File.separator + "in.java");
        boolean isbefore = LocalTime.parse("06:30").isBefore(LocalTime.parse("07:30"));
        System.out.println(Files.exists(Path.of(String.valueOf(path), "sample.txt")));


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYYMMdd");

        String dateNow = formatter.format(LocalDate.now());
        if(LocalTime.now().isAfter(LocalTime.parse("03:30")) && LocalTime.now().isBefore(LocalTime.parse("16:30"))){
            System.out.println(dateNow);

        }
        else {
            System.out.println(false);
        }

       // Files.createFile(path);

//       try {
//           Files.walkFileTree(path, new PrintNames());
//       }
//       catch (IOException e){
//           System.out.println(e.getMessage());
//       }

    }

    private static void printFile(Path path) {
        try (BufferedReader fileReader = Files.newBufferedReader(path)) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch(IOException e){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }

    }

