package parser;

import java.nio.file.Path;

public class LanguageResolver {
  public static SupportedLanguage fromPath(Path path) {
    String fileName = path.getFileName().toString();

    if (fileName.endsWith(".java")) {
      return SupportedLanguage.JAVA;
    }

    if (fileName.endsWith(".py")) {
      return SupportedLanguage.PYTHON;
    }

    throw new IllegalArgumentException("Unsupported file type: " + fileName);
  }
}
