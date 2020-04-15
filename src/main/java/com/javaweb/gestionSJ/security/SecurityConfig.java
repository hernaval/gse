package com.javaweb.gestionSJ.security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private PasswordEncoder pass;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth ) throws Exception{
		//configuration des requêtes dans la base de données
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select code_resp as principal,password as credentials,active from Responsables where code_resp=?" )
			.authoritiesByUsernameQuery("select code_resp as principal, role as role from Responsables where code_resp=?" )
			.passwordEncoder(pass);
			
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		//configuration des paramètres de l'auth
		//autorisation des routes
		http.formLogin().loginPage("/login").defaultSuccessUrl("/gse/activites");
		http.authorizeRequests().antMatchers("/gse/*").authenticated()
		.and()
		.csrf().disable();
	}
	
	
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new PasswordEncoder(){

			@Override
			public String encode(CharSequence charseq) {
				// TODO Auto-generated method stub
				return getMd5(charseq.toString());
			}

			@Override
			public boolean matches(CharSequence charseq, String arg1) {
				// TODO Auto-generated method stub
				return getMd5(charseq.toString()).equals(arg1);
			}
			
		};
	}
	public static String getMd5(String input){
		MessageDigest md;
		String hashtext ="";
		try {
			md = MessageDigest.getInstance("MD5");
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