package com.javaweb.gestionSJ.security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
	
	public  String getMd5(String input){
		MessageDigest md;
		String hashtext ="";
		try {
			md = MessageDigest.getInstance("md5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger no = new BigInteger(1,messageDigest);
			
			 hashtext = no.toString();
			
			while(hashtext.length() < 32){
				hashtext = "0" + hashtext;
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hashtext;
	}
    
}
