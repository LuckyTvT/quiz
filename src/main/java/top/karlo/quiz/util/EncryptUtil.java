package top.karlo.quiz.util;

import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

/**
 * 功能描述：
 *
 * @author Karlo
 * @date 2019/1/24 09:58
 */
@Slf4j
public class EncryptUtil {

    public static String getCipherText(String plainText) {
        try {
            MessageDigest sha256Digest = MessageDigest.getInstance("SHA-256");
            sha256Digest.update(plainText.getBytes(StandardCharsets.UTF_8));
            byte[] digestByteArray = sha256Digest.digest();
            final byte[] base64ByteArray = Base64.getEncoder().encode(digestByteArray);
            return DatatypeConverter.printHexBinary(base64ByteArray);
        } catch (Exception e) {
            log.error("encrypt error!",e);
        }
        return null;
    }

}
