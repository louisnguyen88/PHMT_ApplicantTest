# Tree Search Program

## Purpose

The Tree Search Program is a Java-based application that constructs a tree data structure and enables users to search for specific nodes based on integer IDs. Each node in the tree contains an integer ID and a corresponding character. The program allows users to:
- Input an integer to search for the corresponding character in the tree.
- Receive feedback on whether the integer was found in any node.
- Exit the program by entering `-1`.

The program demonstrates clean code practices, following SOLID principles, and robust error handling with the use of Java's `Optional` and `Logger` for logging unexpected issues.

## Features
- **Recursive Tree Search**: Searches for nodes recursively to find a matching integer ID.
- **Error Handling**: Catches invalid inputs (e.g., non-integer values), logs warnings, and prompts the user to re-enter a valid input.
- **SOLID Principles**: Code structure is modular, following best practices for readability, maintainability, and testing.

## Algorithm

The search algorithm implemented in this program is a **Depth-First Search (DFS)** with recursion. Here’s how it works:

1. **Base Case**: The algorithm starts at the root node and checks if the current node is `null`. If it is, the algorithm returns an empty result (`Optional.empty()`), signaling that the node was not found along that path.

2. **Match Check**: If the current node's integer ID matches the target ID, the algorithm immediately returns the character associated with that node in an `Optional` to indicate a successful search.

3. **Recursive Calls**: If there’s no match at the current node, the algorithm:
   - Recursively searches the left subtree.
   - If a match is found in the left subtree, it returns the result without exploring the right subtree.
   - If the left subtree does not yield a result, it then searches the right subtree.

4. **Return Result**: The first match found is returned up the recursive chain. If no match is found in either subtree, an empty result is returned.

5. **Big-O notation**: Space Complexity = O(H), where H is tree height / Time Complexity = O(N)


This DFS-based recursive approach is efficient for searching in binary tree structures. By exploring each node only once and stopping early if a match is found, the algorithm minimizes unnecessary operations.
## How to Build and Execute

### Prerequisites

- Java Development Kit (JDK) 11 or higher

### Running the Program

1. **Clone or Download the Repository**: Make sure to navigate into the project directory.

2. **Compile the Program**:
    - From the root directory, compile all Java files:
      ```bash
      javac -d out src/main/java/com/example/treedatastructure/**/*.java
      ```

3. **Run the Program**:
    - Execute the `Main` class:
      ```bash
      java -cp out com.example.treesearch.Main
      ```

4. **Interacting with the Program**:
    - The program will prompt you to enter an integer.
    - Enter a valid integer to search for a corresponding character in the tree.
    - To exit, enter `-1`.
   
### Example Execution
- Enter the integer to search for (or -1 to exit): 3 Character found: X

- Enter the integer to search for (or -1 to exit): 99 Integer not found in any leaf node.

- Enter the integer to search for (or -1 to exit): pdsg Invalid input. Please enter a valid integer. Please try again with a valid input.

- Enter the integer to search for (or -1 to exit): -1 Exiting the search program.