<%-- 
    Document   : frontpageWithLogin
    Created on : Mar 15, 2021, 2:00:13 AM
    Author     : student
--%>

<%@page import="java.util.Arrays"%>
<%@page import="ryerson.ca.helper.Ski"%>
<%@page import="ryerson.ca.helper.SkiXML"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            * {box-sizing: border-box;}

            body {
                margin: 0;
                font-family: Arial, Helvetica, sans-serif;
            }

            .topnav {
                overflow: hidden;
                background-color: #e9e9e9;
            }

            .topnav a {
                float: left;
                display: block;
                color: black;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
                font-size: 17px;
            }

            .topnav a:hover {
                background-color: #ddd;
                color: black;
            }

            .topnav a.active {
                background-color: #2196F3;
                color: white;
            }

            .topnav .login-container {
                float: right;
            }

            .topnav input[type=text] {
                padding: 6px;
                margin-top: 8px;
                font-size: 17px;
                border: none;
                width:120px;
            }

            .topnav .login-container button {
                float: right;
                padding: 6px 10px;
                margin-top: 8px;
                margin-right: 16px;
                background-color: #555;
                color: white;
                font-size: 17px;
                border: none;
                cursor: pointer;
            }

            .topnav .login-container button:hover {
                background-color: green;
            }

            @media screen and (max-width: 600px) {
                .topnav .login-container {
                    float: none;
                }
                .topnav a, .topnav input[type=text], .topnav .login-container button {
                    float: none;
                    display: block;
                    text-align: left;
                    width: 100%;
                    margin: 0;
                    padding: 14px;
                }
                .topnav input[type=text] {
                    border: 1px solid #ccc;  
                }
            }
       
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 60%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 15px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}

        </style>
    </head>
    <body>

        <div class="topnav">
            Hello <%=request.getAttribute("username")%>

        </div>

        <div style="padding-left:16px">
            <h2>Here is your cart.</h2> 

        </div>
        <div style="padding-left:16px">
            <p></p>
            <form action="Buy" method="post"> 
                <input type="hidden" name="pageName" value="hold"/>
              
                <table>
                    <tr><th></th><th>Ski</th><th>Price </th><th>Buy</th></tr>
                   <%  SkiXML skis = (SkiXML) request.getAttribute("skiResults");%>
                           <%  for (Ski ski : skis.getSkis()) {%>
                    <td>                                           </td>
                               <td>   <%=ski.getSkiName()%></td>
                                    <td><%=ski.getPrice()%></td>
                       
                                  <td><%if (ski.isAvailable()){%>
                        


                            <input type="submit" value="Buy"> 
                            <% }else {System.out.println("Not available for Buying");}%></td>
                        
                        
                        
                              <%  
                                  }

                                 
                        %></tr>
       
            </table>
            </form>
        
    </div>
</body>
