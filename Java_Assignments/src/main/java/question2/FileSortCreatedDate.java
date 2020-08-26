package question2;

import org.apache.commons.io.comparator.LastModifiedFileComparator;

import java.io.File;
import java.util.Arrays;

public class FileSortCreatedDate {
    public static void main(String[] args) {

        File dir = new File(System.getProperty("user.home"));
        File[] files = dir.listFiles();

        if (files != null) {
            // Sort files in ascending order based on file's last
            // modification date.
            System.out.println("Ascending order.");
            Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_COMPARATOR);
            FileSortCreatedDate.displayFileOrder(files);

            System.out.println("------------------------------------");

            // Sort files in descending order based on file's last
            // modification date.
            System.out.println("Descending order.");
            Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
            FileSortCreatedDate.displayFileOrder(files);
        }

        //if no Comparator passed like Arrays.sort(files) then it gives output after files created after
    }

    private static void displayFileOrder(File[] files) {
        for (File file : files) {
            System.out.printf("%2$td/%2$tm/%2$tY - %s%n", file.getName(),
                    file.lastModified());
        }
    }
}
