package study.clone.common;

import java.security.SecureRandom;

public class RandomHash {

    /**
     * 랜덤 해시 생성
     * @return 32자로 구성된 랜덤한 해시값
     */
    public static String generateRandomHash32() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] randomBytes = new byte[16]; // 32자 만들려면 배열 길이를 16만큼
        secureRandom.nextBytes(randomBytes);

        // 바이트 배열을 16진수 문자열로 변환
        StringBuilder hexString = new StringBuilder();
        for (byte b : randomBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }
}
