import java.io.IOException;
import org.treesitter.TSTree;
import parser.UniversalParser;

public class Main {

  public static void main(String[] args) {
    String pathJava = "src/test/resources/java/SimpleAssignement.java";
    TSTree parsedJava;

    try {
      parsedJava = UniversalParser.parseFile(pathJava);
    } catch (IOException ioe) {
      System.out.println("File: " + pathJava + " couldn't be read");
      return;
    }

    System.out.println("Parsed Java tree");
    System.out.println(parsedJava.getRootNode());

    String pathPython = "src/test/resources/python/simple_assignement.py";
    TSTree parsedPython;

    try {
      parsedPython = UniversalParser.parseFile(pathPython);
    } catch (IOException ioe) {
      System.out.println("File: " + pathPython + " couldn't be read");
      return;
    }

    System.out.println("Parsed Python tree");
    System.out.println(parsedPython.getRootNode());

  }
}
