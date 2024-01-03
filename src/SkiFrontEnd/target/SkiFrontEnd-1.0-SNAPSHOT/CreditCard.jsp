<%-- 
    Document   : buy
    Created on : Mar 14, 2022, 11:09:45 AM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>

body {
  background-color: #00B9FF;

}
</style>

<center><h2>Finalize Buy</h2></center>


    
 
<form action="Credit" method="post">

<table border="2" align="center" cellpadding="5" cellspacing="5">
<tr>

<td> Enter creditcard :</td>
<td> <input type="text" name="creditcard" size="30"> </td>
</tr>
<tr>
 
<td> Enter name :</td>
<td> <input type="text" name="name" size="30"> </td>
</tr>
<tr>
    
<td> Enter expiry date :</td>
<td> <input type="text" name="expirydate" size="30"> </td>
</tr>
<tr>    
    

<td></td>
<td>
<input type="submit" name ="button1" value="confirm buy" >
</td>
</tr>
</table>
</form>

    
</body>
</html>