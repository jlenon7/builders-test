package br.com.sec;

import lombok.Getter;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Getter
public class Greeting {
    private final String path;
    private final String content;
    private final String commitId;

    public Greeting(String path, String content) throws IOException {
        ProcessBuilder builder = new ProcessBuilder();

        builder.command("sh", "-c", "git rev-parse HEAD");

        this.path = path;
        this.content = content;

        Process process = builder.start();

        this.commitId = IOUtils.toString(process.getInputStream(), StandardCharsets.UTF_8);
    }
}
