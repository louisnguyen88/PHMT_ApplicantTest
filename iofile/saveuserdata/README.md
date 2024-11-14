# SaveUserData Program

A Java Swing application that provides a GUI for users to input text and save it to a file. This application uses validation to ensure that input is not empty and provides feedback on successful or unsuccessful save operations.

## Features

- Simple GUI with a text area for input.
- A "Save" button that triggers file saving functionality.
- Input validation to check for empty text.
- Dialog messages to inform users about success, error, or canceled operations.

## Technology Stack

- **Java 11**: The core programming language used.
- **Java Swing**: Provides the graphical user interface components such as `JFrame`, `JTextArea`, `JButton`, and `JFileChooser` for displaying dialogs and handling user interactions.
- **Java IO (Input/Output) Library**: Used for handling file operations, specifically for reading from and writing to files. Classes like `File` and other I/O classes are used to save text data into files.
- **JUnit 5**: Used for unit testing to validate the functionality of various components.
- **Mockito**: Used to mock dependencies and isolate units for testing, especially for GUI components and dialog services.

## Installation and Setup

1. **Prerequisites**: Ensure that you have the following installed:
    - Java Development Kit (JDK) 11 or later.

2. **Download or copy the Project**: Download or copy the project files to a local directory.

3. **Build the Project**:
    - Compile the application using the following command:
      ```bash
      javac -d out src/iofile/saveuserdata/src/main/**/*.java
      ```

4. **Execute the Application**:
    - Run the application with this command:
      ```bash
      java -cp out iofile.saveuserdata.src.main.gui.SaveData
      ```

## Running Tests

The project includes unit tests to validate core functionality and ensure the application behaves as expected.

### How to Run Tests

1. **Compile the Tests**:
   ```bash
   javac -d out -cp path_to_junit.jar;path_to_mockito.jar;out src/iofile/saveuserdata/src/test/**/*.java
