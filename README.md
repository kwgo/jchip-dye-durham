jchip-dye-durham
# **Sort Names In File (Dye & Durham Coding Assessment)**

A Java program that **reads a list of names from a file, sorts them by last name**, and **writes the sorted list to a new file**. Handles **empty lines** and **single-word names**.  

---

## **Features**
- **Reads names from a text file** (one name per line)  
- **Sorts names alphabetically by last name**  
- **Handles names with no last name** (uses the first word)  
- **Supports thousands of names efficiently**  
- **Writes sorted names to a new file**  
- **Ignores empty lines**  
- **Includes TestNG test cases** for validation

## **Getting Started**

### **Prerequisites**
- **Java 8 or higher**  
- **Maven** or any IDE that supports Java (optional)  
- **TestNG** (for running tests)  

### File Structure
root/  
├── src/  
│   ├── SortNamesInFile.java  
│   ├── unsorted-names-list.txt   # Input file  
│   └── sorted-names-list.txt     # Output file (created after running)  
└── test/  
  &nbsp;&nbsp;&nbsp;&nbsp;└── SortNamesInFileTest.java  # TestNG test cases  

---
## **How to Run**

### **Compile**

**javac -d bin src/SortNamesInFile.java**

### **Run**

**java -cp bin SortNamesInFile**

---
## **Running Tests (TestNG)**

Make sure TestNG is in your classpath.

**Compile the test class:**

javac -cp "path/to/testng.jar;bin" -d bin test/SortNamesInFileTest.java

**Run tests:**

java -cp "path/to/testng.jar;bin" org.testng.TestNG test/SortNamesInFileTest.java

**Example**
  
Input (unsorted-names-list.txt)  
  
Janet Parsons  
Vaughn Lewis  
Adonis Julius Archer  
Shelby Nathan Yoder  
Marin Alvarez  
London Lindsey  
Beau Tristan Bentley  
  

Output (sorted-names-list.txt)  
  
Marin Alvarez  
Adonis Julius Archer  
Beau Tristan Bentley  
Vaughn Lewis  
London Lindsey  
Janet Parsons  
Shelby Nathan Yoder  
  
---
## **Notes**

- **Works with large files efficiently.**

- **Empty lines in the input file are ignored.**

- **Names with a single word are sorted using that word.**

