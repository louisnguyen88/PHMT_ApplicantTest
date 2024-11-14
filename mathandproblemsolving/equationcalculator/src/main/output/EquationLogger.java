package mathandproblemsolving.equationcalculator.src.main.output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EquationLogger {
    private static final Logger logger = Logger.getLogger(EquationLogger.class.getName());
    private static final String DIRECTORY = "./mathandproblemsolving/equationcalculator/src/logs";
    private static final String FILENAME = "equation_log.txt";

    public static void logEquation(String equation) {
        try {
            // Define the path for the log file within the project directory
            Path logDirPath = Paths.get(DIRECTORY);
            Path logFilePath = logDirPath.resolve(FILENAME);

            // Ensure the directory exists
            File logDir = logDirPath.toFile();
            if (!logDir.exists()) {
                logDir.mkdirs();
            }

            // Write the equation to the file
            try (FileWriter writer = new FileWriter(logFilePath.toFile())) {
                writer.write(equation);
                System.out.println("Equation logged to '" + logFilePath.toAbsolutePath() + "'.");
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error writing to log file: " + e.getMessage(), e);
        }
    }
}





