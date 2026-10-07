package parser;

import java.io.IOException;
import java.nio.file.Path;
import org.treesitter.TSLanguage;
import org.treesitter.TSParser;
import org.treesitter.TSTree;
import org.treesitter.TreeSitterJava;
import org.treesitter.TreeSitterPython;
import utils.SourceFileReader;

/**
 * Universal parser meant to parse any supported code to a Tree-sitter syntax tree
 */
public class UniversalParser {

  /**
   * Parses the code into a Tree-sitter syntax tree
   *
   * @param code    code to parse
   * @param supportedLanguage  supported language used to determine the parser's grammar
   * @return the parsed syntax tree
   */
  public static TSTree parse(String code, SupportedLanguage supportedLanguage) {
    TSParser parser = buildParser(supportedLanguage);
    return parser.parseString(null, code);
  }

  /**
   * Parses a source file into a Tree-sitter syntax tree
   *
   * @param filePath    file's code to parse
   * @return the parsed syntax tree
   */
  public static TSTree parseFile(String filePath) throws IOException {
    String code = SourceFileReader.read(filePath);
    SupportedLanguage language = LanguageResolver.fromPath(Path.of(filePath));
    return parse(code, language);
  }

  /**
   * Builds a parser according to the provided supported language
   *
   * @param supportedLanguage language used to determine the parser's grammar
   * @return a parser with the language grammar set
   */

  private static TSParser buildParser(SupportedLanguage supportedLanguage) {
    TSParser parser = new TSParser();

    TSLanguage languageGrammar = null;

    switch (supportedLanguage) {
      case JAVA ->
          languageGrammar = new TreeSitterJava();
      case PYTHON ->
          languageGrammar = new TreeSitterPython();
    }

    parser.setLanguage(languageGrammar);

    return parser;
  }
}
