<%@ include file="header.jsp" %>

<div class="container">    
  <div class="row">
  
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading"> ${product.name} </div>
        <div class="panel-body">
        <p>Price : <input type="text" id="price"></input>${product.price}  </p>
		<p>GST :  <input type="text" id="gst"></input>${product.gst} %</p>  
        </div>
        <div class="panel-footer"> <button type="button" class="btn btn-primary btn-md"
           onClick="save()">Save</button></div>
      </div>
    </div>
   
  </div>
</div><br>

</body>
<script>
  function save() {
    var newprice = $("#price").val();
    var newgst = $("#gst").val();
    $.post('/products/update/${product.id}',{price: newprice, gst: newgst}, function(data) {
    	alert(data);
    	$.get('/products/all');
    });
    }
</script>
</html>
