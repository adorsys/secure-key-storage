package de.adorsys.cse.jwt;

import de.adorsys.cse.crypt.SecretCredentialEncryptor;
import de.adorsys.cse.jwk.JWK;
import de.adorsys.cse.nonce.NonceGenerator;
import de.adorsys.cse.timestamp.TimestampGenerator;

public interface JWTBuilder {
    JWTBuilder withAccessToken(JWT accessToken);

    JWTBuilder withNonceGenerator(NonceGenerator nonceGenerator);

    JWTBuilder withTimestampGenerator(TimestampGenerator timestampGenerator);

    JWTBuilder withExpirationTimeInMs(long expirationTimeInMs);

    JWTBuilder withEncryptedServerPublicKey(SecretCredentialEncryptor encryptor, JWK serverPublicKey);

    JWT build(String hMacKey);
}