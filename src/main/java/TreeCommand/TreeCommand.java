package TreeCommand;

import com.sun.source.tree.Tree;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.EnumSet;

public class TreeCommand {
    public static void main(String[] args) throws IOException {
        TreeCommand treeCommand = new TreeCommand();
        TreeCommand.printFileTree("C:\\Users\\Simon Jørgensen\\Desktop\\Datamatiker uddannelse\\DSA\\TreeCommand");
    }

    public static void printFileTree(String directoryPath) throws IOException {
        Path path = Paths.get(directoryPath);
        printFileTree(path, 0);
    }

    private static void printFileTree(Path path, int depth) throws IOException {
        String indent = getIndent(depth);
        System.out.println(indent + path.getFileName());
        if (Files.isDirectory(path)) {
            try {
                Files.list(path).forEach(p -> {
                    try {
                        printFileTree(p, depth + 1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String getIndent(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("|   ");
        }
        sb.append("|-- ");
        return sb.toString();
    }

}
