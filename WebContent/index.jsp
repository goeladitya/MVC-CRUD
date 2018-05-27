<%@page import="com.bmpl.crud.dto.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>CRUD</title>
</head>
<body>
<div class="container">
        <h2>Item CRUD Operations</h2>
        <div class="form-horizontal">
  <form>
  <div class="form-group">
    <label for="name" class="col-sm-2 control-label">Name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control cleardata" name="name" placeholder="Item Name" required>
    </div>
  </div>
  <div class="form-group">
    <label for="desc" class="col-sm-2 control-label">Desc</label>
    <div class="col-sm-10">
     <textarea cols="20" row="6" name="desc" class="form-control cleardata" placeholder="Desc of object" required></textarea>
     Char Left<span id="charleft"></span>
    </div>
  </div>
  <div class="form-group">
    <label for="price" class="col-sm-2 control-label">Price</label>
    <div class="col-sm-10">
      <input type="text" class="form-control cleardata" name="price" placeholder="Enter Price" required>
    </div>
  </div>
  <div class="form-group">
    <label for="id" class="col-sm-2 control-label">ID</label>
    <div class="col-sm-10">
      <input type="text" class="form-control cleardata" name="id" placeholder="Enter id" required>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button id="add" class="btn btn-success" formaction="addData"><span class="glyphicon glyphicon-plus"></span>Add</button>
      <!-- <button id="load" class="btn btn-default" formaction="controller">Load</button> -->
      
    </div>
  </div>
  </form>
  <form>
      <button id="load" class="btn btn-default" formaction="controller">Load</button>
      
 </form>
</div>
 <%
ArrayList<ProductDTO> productList =  (ArrayList<ProductDTO>) request.getAttribute("prodlist");
if(productList!=null){
if(productList.size()>0){
%> 
   <form>
   <div class="col-sm-10">
      <input type="text" class="form-control cleardata" placeholder="Enter id to delete" name="del" style="display:inline-block; width:40%" required>
      <button class="btn btn-danger" formaction="deleteData"><span class="glyphicon glyphicon-trash" style="display:inline-block;">Delete</span></button>
    </div>
   	<br>
   	<br>
   </form>
   <fieldset><legend>Item List</legend>
   <table class="table table-bordered table-striped" >
      <thead>
          <tr>
              
              <th>Name</th>
              <th>Desc</th>
              <th>Price</th>
              <th>Id</th>
              
          </tr>
      </thead>
       <tbody id="itembody">
           <%
           for(ProductDTO product : productList){
		   %>
		<tr>
		<td><%=product.getName() %></td>
		<td><%=product.getDesc() %></td>
		<td><%=product.getPrice() %></td>
		<td><%=product.getId() %></td>
		</tr>
		<%
		}
		%>
       </tbody>
   </table>
   </fieldset>
   <%
	}
	else{	
	%>
	<h1>No Record Found....</h1>
	<%	
	}
	}
	
	%>
    </div>
</body>
</html>