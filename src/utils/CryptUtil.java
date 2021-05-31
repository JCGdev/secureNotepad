package utils;


import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class CryptUtil {

	public static final int AES_128 = 128;
	public static final int AES_256 = 256; 
	public static final int AES_512 = 512;
	
	public static final String ECB_MODE = "AES/ECB/PKCS5Padding";
	public static final String CBC_MODE = "AES/CBC/PKCS5Padding";
	
	/**
	 * 			 (PKBDF2)
	 * 
	 * num of iterations 	time(ms)
	 *
	 *		100				2
	 *		1000			16
	 *		10.000			196
	 *		50.000			807
	 *		100.000			1474
   	 *		200.000			2892
	 *		500.000			7172
	 *
	 */
	
	
	
	
	
	// n --> (128, 192, and 256)
	public static SecretKey genSecretKeyAES(int n) {
	
		SecretKey key = null;
		
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(n);
			key = keyGenerator.generateKey();
			
		}catch(Exception e) {utils.MessageUtil.showErrorMessage("ERROR",
																"Error creating secret key for AES",
																utils.MessageUtil.ROUNDED_DENIED,
																e);}
		
	    return key;
	}
	
	public static byte[] genSalt() {
		
		byte[] salt = null;
		
		try {
			SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
			salt = new byte[16];
			sr.nextBytes(salt);

		}catch(Exception e) {utils.MessageUtil.showErrorMessage("ERROR",
																"Error generating salt",
																utils.MessageUtil.ROUNDED_DENIED,
																e);}
		
		return salt;
	}
	

	public static IvParameterSpec genIVSpec() {
		
		byte[] iv = null;
		
		try {
			iv = new byte[16];
			new SecureRandom().nextBytes(iv);

		}catch(Exception e) {utils.MessageUtil.showErrorMessage("ERROR",
																"Error generating IV",
																utils.MessageUtil.ROUNDED_DENIED,
																e);}
		
		return new IvParameterSpec(iv);
	}
	
	public static byte[] genIVBuffer() {
		
		byte[] iv = null;
		
		try {
			iv = new byte[16];
			new SecureRandom().nextBytes(iv);

		}catch(Exception e) {utils.MessageUtil.showErrorMessage("ERROR",
																"Error generating IV",
																utils.MessageUtil.ROUNDED_DENIED,
																e);}
		
		return iv;
	}
	
	public static SecretKey hashKeyWithPKBDF2(char[] password, byte[] salt) {
		    
		SecretKey hashedKey = null;
		
		try {
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			KeySpec spec = new PBEKeySpec(password, salt, 66000, 256);
			hashedKey = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
		
		}catch(Exception e) {utils.MessageUtil.showErrorMessage("ERROR",
															"Error hashing the password",
															utils.MessageUtil.ROUNDED_DENIED,
															e);}
			
		return hashedKey;
	}
	
	public static SecretKey hashKeyWithPKBDF2(char[] password, int iterations, byte[] salt) {
		SecretKey hashedKey = null;
		
		try {
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			KeySpec spec = new PBEKeySpec(password, salt, iterations, 256);
			hashedKey = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
		
		}catch(Exception e) {utils.MessageUtil.showErrorMessage("ERROR",
																"Error hashing the password",
																utils.MessageUtil.ROUNDED_DENIED,
																e);}
		
		return hashedKey;
	}
	
	
	
	public static SecretKey hashKeyWithPKBDF2(char[] password,
												   byte[] salt,
												   int iterations,
												   int shaAlgo) throws NoSuchAlgorithmException, InvalidKeySpecException {
		SecretKey hashedKey = null;
		
		try {
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			KeySpec spec = new PBEKeySpec(password, salt, iterations, shaAlgo);
			hashedKey = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
		
		}catch(Exception e) {utils.MessageUtil.showErrorMessage("ERROR",
																"Error hashing the password",
																utils.MessageUtil.ROUNDED_DENIED,
																e);}
		
		return hashedKey;
	}
	
	
	public static String encodeToBase64String(byte[] cipherText) {
		return Base64.getEncoder().encodeToString(cipherText);
		
	}
	
	public static byte[] encodeToBase64Buffer(byte[] cipherText) {
		return Base64.getEncoder().encode(cipherText);
		
	}
	
	
	public static byte[] decodeFromBase64String(String cipherText) {
		return Base64.getDecoder().decode(cipherText);
		
	}
	
	public static byte[] decodeFromBase64Buffer(byte[] cipherText) {
		return Base64.getDecoder().decode(cipherText);
		
	}
	
	
	
	
	public static String encryptWithCBCMode(byte[] plainText, char[] password) {
		
		byte[] cipherText = null;
		byte[] salt = null;
		byte[] ivBuffer = null;
		

		
		try {
			
			salt = genSalt();
			ivBuffer = genIVBuffer();
			SecretKey key = hashKeyWithPKBDF2(password, salt);

			Cipher cipher = Cipher.getInstance(CBC_MODE);
			cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(ivBuffer));
			cipherText = cipher.doFinal(plainText);
			
		    
			

		}catch(Exception e) {utils.MessageUtil.showErrorMessage("ERROR",
																"Error encrypting the note",
																utils.MessageUtil.ROUNDED_DENIED,
																e);}
		
		password = null;
		
		return encodeToBase64String(salt) + encodeToBase64String(ivBuffer) + encodeToBase64String(cipherText);
		
		}
	
	
	
	public static String decryptWithCBCMode(String encodedCipherText, char[] password, String encodedSalt, String encodedIV) {
		
		byte[] plainText = null;
		
		try {
			
			byte[] decodedCiphertext = decodeFromBase64String(encodedCipherText);
		    byte[] decodedSalt = decodeFromBase64String(encodedSalt);
		    byte[] decodedIV = decodeFromBase64String(encodedIV);
			
			SecretKey key = hashKeyWithPKBDF2(password, decodedSalt);
			
		    Cipher cipher = Cipher.getInstance(CBC_MODE);
		    cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(decodedIV));
		    plainText = cipher.doFinal(decodedCiphertext);
		    
		   
		}catch(Exception e) {utils.MessageUtil.showErrorMessage("ERROR",
																"Error decrypting the note",
																utils.MessageUtil.ROUNDED_DENIED,
																e);}
	
		password = null;
		
	    return new String(plainText);
	}
	
	
	/**		(How a file should be read, into chunks)		
	  * 
	  *		byte[] buff = new byte[BUFFERSIZE];
	  *		for(int readBytes=in.read(buff); readBytes>-1;readBytes=in.read(buff)) {
  	  *			out.write(cipher.update(buff,0, readBytes);
	  *		}
	  *		out.write(cipher.doFinal());
	  *
	  */
	
	
	
	@Deprecated
	public static SealedObject encryptObjectWithECB(Serializable object, SecretKey key) {
		    
		SealedObject sealedObject = null;
		
		try {
		
			Cipher cipher = Cipher.getInstance(ECB_MODE);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			sealedObject = new SealedObject(object, cipher);

		}catch(Exception e) {utils.MessageUtil.showErrorMessage("ERROR",
															"Error decrypting the object " + object.getClass(),
															utils.MessageUtil.ROUNDED_DENIED,
															e);}
			
		return sealedObject;
	}
	
	@Deprecated
	public static Serializable decryptObjectWithECB(SealedObject sealedObject,SecretKey key) {
			
	Serializable unsealObject = null;
	
	try {
			
		Cipher cipher = Cipher.getInstance(ECB_MODE);
		cipher.init(Cipher.DECRYPT_MODE, key);
		unsealObject = (Serializable) sealedObject.getObject(cipher);
		    
	}catch(Exception e) {utils.MessageUtil.showErrorMessage("ERROR",
															"Error decrypting the object " + sealedObject.getClass(),
															utils.MessageUtil.ROUNDED_DENIED,
															e);}
	
	return unsealObject;
	
	}
	
	public static SealedObject encryptObjectWithECB(Serializable object,SecretKey key, IvParameterSpec iv) {
		    
		SealedObject sealedObject = null;
		
		try {
		
			Cipher cipher = Cipher.getInstance(CBC_MODE);
		    cipher.init(Cipher.ENCRYPT_MODE, key, iv);
		    sealedObject = new SealedObject(object, cipher);

		}catch(Exception e) {utils.MessageUtil.showErrorMessage("ERROR",
																"Error decrypting the object " + object.getClass(),
																utils.MessageUtil.ROUNDED_DENIED,
																e);}
		
	    return sealedObject;
	}
	
	public static Serializable decryptObjectWithCBC(SealedObject sealedObject, SecretKey key, IvParameterSpec iv) {
		    
		Serializable unsealObject = null;
		
		try {
		
		    Cipher cipher = Cipher.getInstance(CBC_MODE);
		    cipher.init(Cipher.DECRYPT_MODE, key, iv);
		    unsealObject = (Serializable) sealedObject.getObject(cipher);

		 
		}catch(Exception e) {utils.MessageUtil.showErrorMessage("ERROR",
																"Error decrypting the object " + sealedObject.getClass(),
																utils.MessageUtil.ROUNDED_DENIED,
																e);}
	    return unsealObject;
	}
}
