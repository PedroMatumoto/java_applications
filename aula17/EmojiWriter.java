package aula17;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EmojiWriter {
    public static void main(String[] args) {
        Map<Character, String> alphabetEmojiMap = new HashMap<>();
        alphabetEmojiMap.put('a', "😀");
        alphabetEmojiMap.put('b', "😂");
        alphabetEmojiMap.put('c', "😍");
        alphabetEmojiMap.put('d', "🥰");
        alphabetEmojiMap.put('e', "🤩");
        alphabetEmojiMap.put('f', "😎");
        alphabetEmojiMap.put('g', "🥳");
        alphabetEmojiMap.put('h', "😇");
        alphabetEmojiMap.put('i', "🤪");
        alphabetEmojiMap.put('j', "😜");
        alphabetEmojiMap.put('k', "🤓");
        alphabetEmojiMap.put('l', "😋");
        alphabetEmojiMap.put('m', "😷");
        alphabetEmojiMap.put('n', "🤒");
        alphabetEmojiMap.put('o', "🥺");
        alphabetEmojiMap.put('p', "😢");
        alphabetEmojiMap.put('q', "😡");
        alphabetEmojiMap.put('r', "🤯");
        alphabetEmojiMap.put('s', "🥴");
        alphabetEmojiMap.put('t', "🤮");
        alphabetEmojiMap.put('u', "🤢");
        alphabetEmojiMap.put('v', "🤬");
        alphabetEmojiMap.put('w', "🤠");
        alphabetEmojiMap.put('x', "🤡");
        alphabetEmojiMap.put('y', "🤖");
        alphabetEmojiMap.put('z', "�");
        Path file = Paths.get("/Users/basilbourque/emojis.txt");
        Charset charset = StandardCharsets.UTF_8;

        String[] emojis = {
            "😀", "😂", "😍", "🥰", "🤩", "😎", "🥳", "😇",
            "🤪", "😜", "🤓", "😋", "😷", "🤒", "🥺", "😢",
            "😡", "🤯", "🥴", "🤮", "🤢", "🤬", "🤠", "🤡",
            "🤖", "�"
        };

        try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
            Random random = new Random();

            for (int i = 0; i < 26; i++) {
                int index = random.nextInt(emojis.length);
                writer.write(emojis[index]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
