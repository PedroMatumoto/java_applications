public class a {
    private static final int POLYNOMIAL = 0x07;
    private static final int INITIAL_VALUE = 0x00;

    public static int calculateCRC8(String input) {
        int crc = INITIAL_VALUE;
        byte[] data = input.getBytes();

        for (byte b : data) {
            crc ^= b;
            for (int j = 0; j < 8; j++) {
                if ((crc & 0x80) != 0) {
                    crc = (crc << 1) ^ POLYNOMIAL;
                } else {
                    crc <<= 1;
                }
            }
        }

        return crc & 0xFF; // Ensure the result is an 8-bit value
    }

    public static void main(String[] args) {
        String input = "Casa1";
        int crc8Checksum = calculateCRC8(input);
        System.out.println("CRC-8 checksum: 0x" + Integer.toHexString(crc8Checksum));
    }
}