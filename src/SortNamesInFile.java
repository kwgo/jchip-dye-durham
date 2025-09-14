import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortNamesInFile {

	static List<String> readAndSort(String fileName) throws IOException {
		List<String> sortedNames = Files.lines(Paths.get(fileName)).map(String::trim) // remove leading/trailing spaces
				.filter(s -> !s.isEmpty()) // skip empty lines
				.sorted(Comparator.comparing((String name) -> {
					String[] parts = name.split("\\s+");
					return parts.length > 1 ? parts[parts.length - 1] : " "; // put name on top if no last name
				}).thenComparing(name -> name)).collect(Collectors.toList()); // and sort the first name

		return sortedNames;
	}

	static void writeToFile(String fileName, List<String> sortedNames) throws IOException {
		Files.write(Paths.get(fileName), sortedNames, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
	}

	public static void main(String[] args) throws IOException {
		String inputFile = "src/unsorted-names-list.txt";
		String outputFile = "src/sorted-names-list.txt";
		
		System.out.println("Working dir = " + Paths.get("").toAbsolutePath());

		List<String> sortedNames = readAndSort(inputFile);

		sortedNames.forEach(System.out::println);

		writeToFile(outputFile, sortedNames);
	}

}
