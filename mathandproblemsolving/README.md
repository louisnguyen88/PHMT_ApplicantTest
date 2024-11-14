# Equation Calculator Project

## Overview

The Equation Calculator Project is a Java application that calculates the result of an expression derived from a set of input values. This project uses both **Divide and Conquer** and the **Inclusion-Exclusion Principle** to compute the result efficiently. It also constructs and formats the equation based on the input values, using systematic addition and subtraction of their products as per the inclusion-exclusion principle.

## Algorithm & Data Structures
### Divide and Conquer with Inclusion-Exclusion Principle
This project uses a divide-and-conquer approach to apply the inclusion-exclusion principle for calculating the result. Here’s how it works:
1. **Divide Step**: The input list is recursively split into halves until each subset reaches a manageable size.
2. **Calculate Partial Results**:
    - For each subset, it calculates the sum and products of elements based on the inclusion-exclusion principle.
    - Inclusion-exclusion is applied to account for overlapping sets by adding and subtracting products as required.
3. **Combine Step**: The results from each half are combined iteratively to compute the final result.

#### Inclusion-Exclusion Principle
The inclusion-exclusion principle is used to calculate results involving overlapping sets. In this project, it is applied to calculate products across subsets:
- Add all single values.
- Subtract pairwise products.
- Add triple products, and so on, until all subsets are accounted for.
This approach significantly reduces the time complexity compared to directly computing all subsets for large inputs.

### Key Data Structures
- **Array of Doubles (`double[]`)**: Used to store the input values provided by the user. The array structure ensures efficient access and storage of numeric data.
- **List of Doubles (`List<Double>`)**: Used to manage subsets during recursive calculations. Lists provide flexibility for dynamic sizing as subsets are generated.

### Time Complexity
The time complexity for the divide-and-conquer approach to calculating the inclusion-exclusion result is:
- **Divide-and-Conquer Calculation**: \(O(n \log n)\)
    - The recursive division of the input into halves reduces the overall number of operations, achieving a time complexity of \(O(n \log n)\), which is efficient even for large values of \(n\) (up to 100,000).
    - By using this approach, the algorithm avoids the exponential growth that would occur if it calculated all possible subsets.
- **Partial Product Computation**: \(O(n^2)\) for subset products
    - For each divide-and-conquer merge step, the algorithm computes pairwise products, which requires a time complexity of \(O(n^2)\). While this is higher than \(O(n)\), the overall \(O(n \log n)\) complexity is maintained as the products are calculated only on smaller merged subsets.

## Meeting Requirements
This algorithm and data structure selection ensures the following:
- **Supports a Maximum of 100,000 Input Elements**:  
  The divide-and-conquer algorithm is optimized to handle up to 100,000 input elements, with \(O(n \log n)\) time complexity making it feasible for this input size.

- **Accurate Calculations**:
  The algorithm uses the inclusion-exclusion principle precisely, ensuring that overlapping subsets are accurately computed and subtracted or added as required.

- **Memory Management**:
  By using arrays and lists only as needed and avoiding the creation of all subsets simultaneously, the algorithm prevents out-of-memory errors. This is achieved with a memory complexity of \(O(n)\), manageable even with 100,000 elements.

- **Optimized for Large Datasets**:
  The divide-and-conquer approach reduces redundant calculations and limits the size of intermediate data stored, making the algorithm efficient for large datasets.
  Minimizes memory usage, avoiding the need to hold all subsets in memory at once.

### Prerequisites
- Java 8 or higher
- JUnit 5 for testing

## Features
- **Efficient Calculation**: Computes the result of a complex equation based on the inclusion-exclusion principle using a divide-and-conquer approach.
- **Equation Formatting**: Constructs and formats the equation by systematically combining input values.
- **Modular Design**: Uses separate classes to handle calculation and equation formatting, ensuring clear separation of concerns.

## Running the Application
1. Compile the project.
2. Run the main class `Main`:
   ```bash
   java com.Main
   ```
3. Enter values separated by spaces. For example: 
   ```bash
   2.0 4.0 6.0
   ```
4. View the result in the console.
5. To log the equation, check the file equation_log.txt in the logs folder.
6. To exit the application, type q and press Enter.

## Testing
This project includes JUnit tests to verify functionality:
- **`EquationCalculatorTest`**: Validates calculation accuracy using various input arrays, including single-element, multiple-element, and empty arrays.
- **`EquationFormulatorTest`**: Verifies that the equation formatting logic correctly represents the equation components in a readable string format.

### Sample Test Cases
1. **Simple Calculation**: For input `[2.0, 4.0, 6.0]`, verifies that the result is `16.0` and the formatted equation is as expected.
2. **Multiple Elements**: For input `[2.0, 4.0, 6.0, 8.0]`, verifies the result with multiple levels of inclusion-exclusion products.
3. **Edge Cases**: Tests with empty and single-element arrays to ensure the application handles these cases gracefully.