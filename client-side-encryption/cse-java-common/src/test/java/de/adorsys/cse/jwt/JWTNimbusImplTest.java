package de.adorsys.cse.jwt;

import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class JWTNimbusImplTest {
    private JWT jwt;

    @Test(expected = IllegalArgumentException.class)
    public void createWithNullThrowsException() throws Exception {
        //noinspection ConstantConditions
        new JWTNimbusImpl(null);
        fail("Creation of JWT with null-String causes IllegalArgumentException");
    }

    @Test(expected = ParseException.class)
    public void createWithAStringThatNotATokenThrowsParseException() throws Exception {
        new JWTNimbusImpl("bla-bla-bla");
        fail("Creation of JWT with invalid token-String causes ParseException");
    }

    @Test
    public void serializationReturnsSameString() throws Exception {
        final String base64encodedToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWV9.TJVA95OrM7E2cBab30RMHrHDcEfxjoYZgeFONFh7HgQ";

        jwt = new JWTNimbusImpl(base64encodedToken);
        assertEquals("Serializaion/Deserializaion returns same string", base64encodedToken, jwt.toString());
    }

    @Test
    public void serializationReturnsBase64EncodedJWT() throws Exception {
        final String expectedEncodedJWTToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWV9.TJVA95OrM7E2cBab30RMHrHDcEfxjoYZgeFONFh7HgQ";

        jwt = new JWTNimbusImpl(expectedEncodedJWTToken);
        assertEquals("Serializaion/Deserializaion returns same string", expectedEncodedJWTToken, jwt.encode());
    }

}
