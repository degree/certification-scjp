package io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author Yauhen Dubrouka
 */
public class TraverseFiles {
	public static void main(String[] args) {
		try {
			Files.walkFileTree(Paths.get(""), new JavaVisitor());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class JavaVisitor extends SimpleFileVisitor<Path> {

	private PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.java");

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		if (matcher.matches(file.getFileName())) {
			System.out.println(file);
		}
		return FileVisitResult.CONTINUE;
	}
}
