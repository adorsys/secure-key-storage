package de.adorsys.cse.crypt;

import de.adorsys.cse.jwt.JWE;
import de.adorsys.cse.jwt.JWS;
import de.adorsys.cse.jwt.JWT;

public interface JWTDecryptor {
    JWS decryptSigned(JWE encrypted) throws JWTEncryptionException;

    JWT decryptUnsigned(JWE encrypted) throws JWTEncryptionException;

    JWS decryptSigned(String encryptedBase64) throws JWTEncryptionException;

    JWT decryptUnsigned(String encryptedBase64) throws JWTEncryptionException;
}
