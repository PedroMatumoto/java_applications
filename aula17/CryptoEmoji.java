package aula17;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CryptoEmoji {
    public static void main(String[] args) {
        String originalMessage = "hello world";
        String encryptedMessage = encryptMessage(originalMessage);
        String decryptedMessage = decryptMessage(encryptedMessage);

        System.out.println("Original Message: " + originalMessage);
        System.out.println("Encrypted Message: " + encryptedMessage);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }

    public static String encryptMessage(String message) {
        Map<Character, String> map = createMap();
        Random random = new Random();
        StringBuilder encryptedMessage = new StringBuilder();

        for (char c : message.toCharArray()) {
            String emoji = map.get(Character.toLowerCase(c));
            if (emoji != null) {
                encryptedMessage.append(emoji);
            } else {
                encryptedMessage.append(c);
            }

            // Introduce randomness by adding a random emoji
            if (random.nextBoolean()) {
                String randomEmoji = getRandomEmoji();
                encryptedMessage.append(randomEmoji);
            }
        }

        return encryptedMessage.toString();
    }

    public static String decryptMessage(String encryptedMessage) {
        Map<String, Character> emojiAlphabetMap = reverseEmojiToLetter(createMap());
        StringBuilder decryptedMessage = new StringBuilder();

        int i = 0;
        while (i < encryptedMessage.length()) {
            String currentEmoji = String.valueOf(encryptedMessage.charAt(i));

            if (i + 1 < encryptedMessage.length()) {
                currentEmoji += encryptedMessage.charAt(i + 1);
            }

            if (emojiAlphabetMap.containsKey(currentEmoji)) {
                decryptedMessage.append(emojiAlphabetMap.get(currentEmoji));
            } else {
                decryptedMessage.append(currentEmoji);
            }

            i += currentEmoji.length();
        }

        return decryptedMessage.toString();
    }

    public static Map<Character, String> createMap() {
        Map<Character, String> map = new HashMap<>();
        map.put('a', "😀");
        map.put('b', "😂");
        map.put('c', "😍");
        map.put('d', "🥰");
        map.put('e', "🤩");
        map.put('f', "😎");
        map.put('g', "🥳");
        map.put('h', "😇");
        map.put('i', "🤪");
        map.put('j', "😜");
        map.put('k', "🤓");
        map.put('l', "😋");
        map.put('m', "😷");
        map.put('n', "🤒");
        map.put('o', "🥺");
        map.put('p', "😢");
        map.put('q', "😡");
        map.put('r', "🤯");
        map.put('s', "🥴");
        map.put('t', "🤮");
        map.put('u', "🤢");
        map.put('v', "🤬");
        map.put('w', "🤠");
        map.put('x', "🤡");
        map.put('y', "🤖");
        map.put('z', "�");
        return map;
    }

    public static Map<String, Character> reverseEmojiToLetter(Map<Character, String> emojiToLetterMap) {
        Map<String, Character> reversedMap = new HashMap<>();
        for (Character letter : emojiToLetterMap.keySet()) {
            String emoji = emojiToLetterMap.get(letter);
            reversedMap.put(emoji, letter);
        }
        return reversedMap;
    }

    public static String getRandomEmoji() {
        String[] emojis = {
                "😀", "😂", "😍", "🥰", "🤩", "😎", "🥳", "😇",
                "🤪", "😜", "🤓", "😋", "😷", "🤒", "🥺", "😢",
                "😡", "🤯", "🥴", "🤮", "🤢", "🤬", "🤠", "🤡",
                "🤖", "�"
        };
        Random random = new Random();
        int index = random.nextInt(emojis.length);
        return emojis[index];
    }
}
