package de.adorsys.cse.jwt;

import java.util.Map;
import java.util.Optional;

public interface JWT {

    /**
     * Encodes data as Base64 URL-safe String according to RFC 7519
     *
     * @return String that contains Base64 encoded token
     */
    String encode();

    /**
     * Returns the String value of a claim in the token's payload
     *
     * @param claimName - name of a claim to be returned
     * @return String with a value of claim. Empty if a claim is not found
     */
    Optional<String> getClaim(String claimName);

    /**
     * Checks if token contains signature. Doesn't check signature validity
     *
     * @return true if signature block present,
     *         false otherwise
     */
    boolean isSigned();


    /**
     * Provides claims registered in JWT payload
     *
     * @return a map of claims (name->value)
     */
    Map<String, Object> getPayloadClaims();

    /**
     * Provides all claims registered in JWT
     *
     * @return a map of claims (name->value)
     */
    Map<String, Object> getAllClaims();

    /**
     * Checks token expiration time provided by "exp" claim
     *
     * @return true if token contains expiration time and expired
     */
    boolean isExpired();

    /**
     * Checks token expiration time provided by "exp" claim
     *
     * @return true if token contains expiration time and is not expired or token contains no expiration time claim
     */
    boolean isNotExpired();

    /**
     * Claims declared according to sections 4.1 and 10.1 of RFC 7519
     * Details at https://tools.ietf.org/html/rfc7519#section-4.1
     * and https://tools.ietf.org/html/rfc7519#section-10.1
     *
     * The whole list is available at https://www.iana.org/assignments/jwt/jwt.xhtml
     */
    final class Claims {
        /**
         * Claims according to section 10.1 of https://tools.ietf.org/html/rfc7519#section-10.1
         * The whole list is available at https://www.iana.org/assignments/jwt/jwt.xhtml
         */
        public static final String CLAIM_JWT_ID = "jti";
        public static final String CLAIM_ISSUER = "iss";
        public static final String CLAIM_SUBJECT = "sub";
        public static final String CLAIM_AUDIENCE = "aud";
        public static final String CLAIM_ISSUED_AT = "iat";
        public static final String CLAIM_EXPIRATION_TIME = "exp";
        public static final String CLAIM_NOT_BEFORE = "nbf";

        // Other claims
        public static final String CLAIM_ACCESS_TOKEN = "access_token";
        public static final String CLAIM_SERVER_PUBLIC_KEY = "res_pub_key";
        public static final String CLAIM_PUBLIC_KEY_ENCRYPTED_HMAC_SECRET = "pke_hmac";
        public static final String CLAIM_PAYLOAD = "pay";
    }
}
