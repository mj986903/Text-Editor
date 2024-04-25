<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page trimDirectiveWhitespaces="true"%>


<%
	String output = request.getAttribute("output").toString();
	output = output.trim();
%>   
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Text Converter</title>
    <link rel="stylesheet" href="style.css" />
  </head>
  <body>
    <header>
      <div class="logo">
        <a href="index.jsp">
          <img
            class="logo"
            src="images/logo.jpg"
            alt="logo"
            height="40px"
            width="40px"
          />
        </a>
        <p id="logoText">
          <a href="index.jsp"><b>Text Converter</b></a>
        </p>
      </div>
    </header>
    <main>
      <div class="text">
        <p>Case Converter</p>
      </div>
      <form action="TextConverter" method="post">
        <div class="container">
          <textarea
          	id="textarea"
            name="input"
            cols="80"
            rows="12"
            placeHolder=""
          ><%= output %>
          </textarea>
        </div>
        <div class="count">
          <p>Character Count : <%= request.getAttribute("charCount") %></p>
          <p>Word Count : <%= request.getAttribute("wordCount") %></p>
        </div>
        <div class="buttonContainer">
          <input id="button" type="submit" name="button" value="tOGGLE cASE" />
          <input id="button" type="submit" name="button" value="lower case" />
          <input id="button" type="submit" name="button" value="UPPER CASE" />
          <input
            id="button"
            type="submit"
            name="button"
            value="Sentence Case"
          />
          <input
            id="button"
            type="submit"
            name="button"
            value="Capitalize Word"
          />
          <input
            id="button"
            type="submit"
            name="button"
            value="aLtErNaTe cAsE"
          />
        </div>
        <div class="buttonContainer">
        	<input
            	id="copy"
            	type="submit"
            	name="button"
            	value="Copy To Clipboard"
          />
        </div>
      </form>
    </main>
  </body>
</html>