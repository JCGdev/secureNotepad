package utils;

import java.util.Arrays;

public class ArrayUtil {

	
	public static byte[] splitArray(byte[] array, int initialPos, int endPos) {
	
		byte[] splittedArray = null;
		
		try {
			splittedArray = Arrays.copyOfRange(array, initialPos, endPos);
	
		}catch(Exception e) {utils.MessageUtil.showErrorMessage("ERROR",
																"Something gone wrong while splitting arrays",
																utils.MessageUtil.ROUNDED_DENIED,
																e);;}
	
		return splittedArray;
	
	}
	
	public static int[] splitArray(int[] array, int initialPos, int endPos) {
		
		int[] splittedArray = null;
		
		try {
			splittedArray = Arrays.copyOfRange(array, initialPos, endPos);
	
		}catch(Exception e) {utils.MessageUtil.showErrorMessage("ERROR",
																"Something gone wrong while splitting arrays",
																utils.MessageUtil.ROUNDED_DENIED,
																e);;}
	
		return splittedArray;
		
	}
	
	public static String[] splitArray(String[] array, int initialPos, int endPos) {
		
		String[] splittedArray = null;
		
		try {
			splittedArray = Arrays.copyOfRange(array, initialPos, endPos);
	
		}catch(Exception e) {utils.MessageUtil.showErrorMessage("ERROR",
																"Something gone wrong while splitting arrays",
																utils.MessageUtil.ROUNDED_DENIED,
																e);;}
	
		return splittedArray;
	}
	
	public static String splitArrayToString(String[] array, int initialPos, int endPos) {
		
		String[] splittedArray = null;
		
		try {
			splittedArray = Arrays.copyOfRange(array, initialPos, endPos);
	
		}catch(Exception e) {utils.MessageUtil.showErrorMessage("ERROR",
																"Something gone wrong while splitting arrays",
																utils.MessageUtil.ROUNDED_DENIED,
																e);;}
	
		return splittedArray.toString();
	}
	
	public static Object[] splitArray(Object[] array, int initialPos, int endPos) {
		
		Object[] splittedArray = null;
		
		try {
			splittedArray = Arrays.copyOfRange(array, initialPos, endPos);
	
		}catch(Exception e) {utils.MessageUtil.showErrorMessage("ERROR",
																"Something gone wrong while splitting arrays",
																utils.MessageUtil.ROUNDED_DENIED,
																e);;}
	
		return splittedArray;
		
	}
	
	
	
	public static byte[] concatenateArrays(byte[] array1, byte[] array2) {

		byte[] resultingArray = null;
		
		try {
		
			int array1Len = array1.length;
			int array2Len = array2.length;
			resultingArray = new byte[array1Len + array2Len];

			System.arraycopy(array1, 0, resultingArray, 0, array1Len);
			System.arraycopy(array2, 0, resultingArray, array1Len, array2Len);
			

		}catch(Exception e) {utils.MessageUtil.showErrorMessage("ERROR",
																"Something gone wrong while splitting arrays",
																utils.MessageUtil.ROUNDED_DENIED,
																e);;}
			
		return resultingArray;
	}
	
	public static byte[] concatenateArrays(byte[] array1, byte[] array2, byte[] array3) {

		byte[] resultingArray = null;
		
		try {
		
			int array1Len = array1.length;
			int array2Len = array2.length;
			int array3Len = array3.length;
		
			resultingArray = new byte[array1Len + array2Len + array3Len];

			System.arraycopy(array1, 0, resultingArray, 0, array1Len);
			System.arraycopy(array2, 0, resultingArray, array1Len, array2Len);
			System.arraycopy(array3, 0, resultingArray, array1Len+array2Len, array3Len);
		
		}catch(Exception e) {utils.MessageUtil.showErrorMessage("ERROR",
																"Something gone wrong while splitting arrays",
																utils.MessageUtil.ROUNDED_DENIED,
																e);;}
			
		return resultingArray;
	}
	
	
	
	public static int[] concatenateArrays(int[] array1, int[] array2) {

		int[] resultingArray = null;
		
		try {
		
			int array1Len = array1.length;
			int array2Len = array2.length;
			resultingArray = new int[array1Len + array2Len];

			System.arraycopy(array1, 0, resultingArray, 0, array1Len);
			System.arraycopy(array2, 0, resultingArray, array1Len, array2Len);

		}catch(Exception e) {utils.MessageUtil.showErrorMessage("ERROR",
																"Something gone wrong while splitting arrays",
																utils.MessageUtil.ROUNDED_DENIED,
																e);;}
		
		return resultingArray;
	}
	
	public static int[] concatenateArrays(int[] array1, int[] array2, int[] array3) {
		
		int[] resultingArray = null;
		
		try {
		
			int array1Len = array1.length;
			int array2Len = array2.length;
			int array3Len = array3.length;
		
			resultingArray = new int[array1Len + array2Len + array3Len];

			System.arraycopy(array1, 0, resultingArray, 0, array1Len);
			System.arraycopy(array2, 0, resultingArray, array1Len, array2Len);
			System.arraycopy(array3, 0, resultingArray, array1Len+array2Len, array3Len);
			
		}catch(Exception e) {utils.MessageUtil.showErrorMessage("ERROR",
																"Something gone wrong while splitting arrays",
																utils.MessageUtil.ROUNDED_DENIED,
																e);;}
		
		return resultingArray;
	}
	
	
	public static String[] concatenateArrays(String[] array1, String[] array2) {

		String[] resultingArray = null;
		
		try {
		
			int array1Len = array1.length;
			int array2Len = array2.length;
			resultingArray = new String[array1Len + array2Len];

			System.arraycopy(array1, 0, resultingArray, 0, array1Len);
			System.arraycopy(array2, 0, resultingArray, array1Len, array2Len);
		
		}catch(Exception e) {utils.MessageUtil.showErrorMessage("ERROR",
																"Something gone wrong while splitting arrays",
																utils.MessageUtil.ROUNDED_DENIED,
																e);;}
		
		return resultingArray;
	}
	
	public static String[] concatenateArrays(String[] array1, String[] array2, String[] array3) {

		String[] resultingArray = null;
		
		try {
			int array1Len = array1.length;
			int array2Len = array2.length;
			int array3Len = array3.length;
		
			resultingArray = new String[array1Len + array2Len + array3Len];

			System.arraycopy(array1, 0, resultingArray, 0, array1Len);
			System.arraycopy(array2, 0, resultingArray, array1Len, array2Len);
			System.arraycopy(array3, 0, resultingArray, array1Len+array2Len, array3Len);
		
		}catch(Exception e) {utils.MessageUtil.showErrorMessage("ERROR",
																"Something gone wrong while splitting arrays",
																utils.MessageUtil.ROUNDED_DENIED,
																e);;}
			
		return resultingArray;
	}
	
	
	public static String concatenateArraysToString(String[] array1, String[] array2) {

		String[] resultingArray = null;
		
		try {
		
			int array1Len = array1.length;
			int array2Len = array2.length;
			resultingArray = new String[array1Len + array2Len];

			System.arraycopy(array1, 0, resultingArray, 0, array1Len);
			System.arraycopy(array2, 0, resultingArray, array1Len, array2Len);
		
		}catch(Exception e) {utils.MessageUtil.showErrorMessage("ERROR",
																"Something gone wrong while splitting arrays",
																utils.MessageUtil.ROUNDED_DENIED,
																e);;}
		
		return resultingArray.toString();
	}
	
	public static String concatenateArraysToString(String[] array1, String[] array2, String[] array3) {

		String[] resultingArray = null;
		
		try {
			int array1Len = array1.length;
			int array2Len = array2.length;
			int array3Len = array3.length;
		
			resultingArray = new String[array1Len + array2Len + array3Len];

			System.arraycopy(array1, 0, resultingArray, 0, array1Len);
			System.arraycopy(array2, 0, resultingArray, array1Len, array2Len);
			System.arraycopy(array3, 0, resultingArray, array1Len+array2Len, array3Len);
		
		}catch(Exception e) {utils.MessageUtil.showErrorMessage("ERROR",
																"Something gone wrong while splitting arrays",
																utils.MessageUtil.ROUNDED_DENIED,
																e);;}
			
		return resultingArray.toString();
	}
	
}
	
