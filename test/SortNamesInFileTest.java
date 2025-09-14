import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SortNamesInFileTest {

	private final String testInputFile = "test-input.txt";
	private final String testOutputFile = "test-output.txt";

	@BeforeMethod
	public void setUp() throws IOException {
		// Create a temporary test input file
		List<String> names = Arrays.asList("Janet Parsons", "Vaughn Lewis", "Adonis Julius Archer",
				"Shelby Nathan Yoder", "Marin Alvarez", "London Lindsey", "Beau Tristan Bentley");
		Files.write(Paths.get(testInputFile), names, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
	}

	@AfterMethod
	public void tearDown() throws IOException {
		// Delete test files after tests
		Files.deleteIfExists(Paths.get(testInputFile));
		Files.deleteIfExists(Paths.get(testOutputFile));
	}

	@Test
	public void testReadAndSort() throws IOException {
		List<String> sortedNames = SortNamesInFile.readAndSort(testInputFile);

		// Expected order by last name
		List<String> expected = Arrays.asList("Marin Alvarez", "Adonis Julius Archer", "Beau Tristan Bentley",
				"Vaughn Lewis", "London Lindsey", "Janet Parsons", "Shelby Nathan Yoder");

		assertEquals(sortedNames, expected, "The names should be sorted by last name correctly");
	}

	@Test
	public void testWriteToFile() throws IOException {
		List<String> sortedNames = SortNamesInFile.readAndSort(testInputFile);

		// Write to output file
		SortNamesInFile.writeToFile(testOutputFile, sortedNames);

		// Read back from file
		List<String> readBack = Files.readAllLines(Paths.get(testOutputFile));

		assertEquals(readBack, sortedNames, "The file contents should match the sorted names list");
	}
}
