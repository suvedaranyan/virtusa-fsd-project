<%@ include file="header.jsp" %>

<div class="container">    
  <div class="row">
  <c:forEach items="${products}" var="product">
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading"> ${product.name} </div>
        <div class="panel-body">
        <p>Price : ${product.price}  </p>
		<p>GST :  ${product.gst} %</p>  
        </div>
        <div class="panel-footer">
           <button type="button" class="btn btn-primary btn-md"
           onClick="location.href='/products/${product.id} ' ">Browse</button>
           <button type="button" class="btn btn-primary btn-md"
           onClick="location.href='/products/edit/${product.id} ' ">Edit</button>
           <button type="button" class="btn btn-primary btn-md"
           onClick="$.get('/products/delete/${product.id}');alert('Deleted');$.get('/products/all')">Delete</button>
        </div>
      </div>
    </div>
    </c:forEach>
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading"><br>  </div>
        <div class="panel-body">
        <button onclick="location.href='/products/add'">Add</button>
		<br><br><br>
        </div>
        <div class="panel-footer">
           <br><br>
        </div>
      </div>
    </div>
  </div>
</div><br>

</body>
</html>
