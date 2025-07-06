package com.filehandling;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.concurrent.*;

public class ParallelFilePipeline {

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Usage: java ParallelFilePipelineSimple <inputDir> <outputDir>");
            return;
        }

        Path inputDir = Paths.get(args[0]);
        Path outputDir = Paths.get(args[1]);
        Files.createDirectories(outputDir);

        ExecutorService readPool = Executors.newFixedThreadPool(8);
        ExecutorService writePool = Executors.newFixedThreadPool(4);

        Files.walk(inputDir)
                .filter(Files::isRegularFile)
                .forEach(path -> readPool.submit(() -> {
                    try {
                        byte[] data = Files.readAllBytes(path);
                        String content = new String(data, StandardCharsets.UTF_8);
                        String transformed = content.toUpperCase();
                        byte[] outputData = transformed.getBytes(StandardCharsets.UTF_8);

                        Path outFile = outputDir.resolve(path.getFileName().toString() + ".out");
                        writePool.submit(() -> {
                            try {
                                Files.write(outFile, outputData);
                            } catch (IOException e) {
                                System.err.println("Failed to write: " + outFile);
                                e.printStackTrace();
                            }
                        });
                    } catch (IOException e) {
                        System.err.println("Failed to read: " + path);
                        e.printStackTrace();
                    }
                }));

        readPool.shutdown();
        readPool.awaitTermination(1, TimeUnit.HOURS);

        writePool.shutdown();
        writePool.awaitTermination(1, TimeUnit.HOURS);

        System.out.println("Processing complete.");
    }
}

