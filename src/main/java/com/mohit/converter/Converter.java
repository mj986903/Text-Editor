package com.mohit.converter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;

@WebServlet("/TextConverter")
public class Converter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	private String toAlternateCase(String input) {
		String result = "";
		for(int i=0;i<input.length();i++) {
			if(i%2 == 0) {
				result = result + Character.toLowerCase(input.charAt(i));
			}else {
				result = result + Character.toUpperCase(input.charAt(i));
			}
		}
		return result;
	}
	
	private String toCapitalizeCase(String input) {
		String result = "";
		for(int i=0;i<input.length();i++) {
			if(i==0) {
				result = result + Character.toUpperCase(input.charAt(i));
				continue;
			}
			if(input.charAt(i-1) == ' ') {
				result = result + Character.toUpperCase(input.charAt(i));
			}else {
				result = result + Character.toLowerCase(input.charAt(i));
			}
		}
		return result;
	}
	
	private String toSentenceCase(String input) {
		String result = "";
		for(int i=0;i<input.length();i++) {
			if(i==0) {
				result = result + Character.toUpperCase(input.charAt(i));
				continue;
			}
			if(input.charAt(i-1) == '.') {
				result = result + Character.toUpperCase(input.charAt(i));
			}else if(i>1 && input.charAt(i-1) == ' ' && input.charAt(i-2) == '.') {
				result = result + Character.toUpperCase(input.charAt(i));
			}else {
				result = result + Character.toLowerCase(input.charAt(i));
			}
		}
		return result;
	}
	
	private String toToggleCase(String input) {
		String result = "";
		for(int i=0;i<input.length();i++) {
			if(i==0) {
				result = result + Character.toLowerCase(input.charAt(i));
				continue;
			}
			if(input.charAt(i) == ' ') {
				result = result + " ";
				continue;
			}
			if(input.charAt(i-1) == ' ') {
				result = result + Character.toLowerCase(input.charAt(i));
				continue;
			}
			result = result + Character.toUpperCase(input.charAt(i));
		}
		return result;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String input;
		String button;
		String charCount;
		String wordCount;
		StringBuilder output = null;
		
		input = request.getParameter("input").trim();
		button = request.getParameter("button");
		
		charCount = String.valueOf(input.length());
		wordCount = String.valueOf(input.split(" ").length); 
		switch(button) {
			case "tOGGLE cASE" :
				output = new StringBuilder(toToggleCase(input));
				break;
			
			case "lower case" :
				output = new StringBuilder(input.toLowerCase());
				break;
				
			case "UPPER CASE" :
				output = new StringBuilder(input.toUpperCase());
				break;
			
			case "Sentence Case" :
				output = new StringBuilder(toSentenceCase(input));
				break;
			
			case "Capitalize Word" :
				output = new StringBuilder(toCapitalizeCase(input));
				break;
				
			case "aLtErNaTe cAsE" :
				output = new StringBuilder(toAlternateCase(input));
				break;
				
			case "Copy To Clipboard" :
				StringSelection stringSelection = new StringSelection(input);
				Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
				cb.setContents(stringSelection, stringSelection);
				output = new StringBuilder(input);
				break;
		}
		System.out.println(output.toString());
		request.setAttribute("output", output.toString());
		request.setAttribute("wordCount", wordCount);
		request.setAttribute("charCount", charCount);
		request.getRequestDispatcher("textConverted.jsp").forward(request, response);
	}
}
