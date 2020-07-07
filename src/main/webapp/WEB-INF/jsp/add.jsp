<%@ include file="header.jsp" %>

<div class="container">    
  <div class="row">
  
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading"> Add Product </div>
        <div class="panel-body">
        <p>Name : <input type="text" id="name"></input></p>
        <p>Price : <input type="text" id="price"></input></p>
		<p>GST :  <input type="text" id="gst"></input></p>  
        </div>
        <div class="panel-footer"> <button type="button" class="btn btn-primary btn-md"
           onClick="submit()">Submit</button></div>
      </div>
    </div>
   
  </div>
</div><br>

</body>
<script>
  function submit() {
    var name = $("#name").val();
	var price = $("#price").val();
    var gst = $("#gst").val();
    $.post('/products/addnewproduct',{name: name, price: price, gst: gst}, function(data) {
    	alert(data);
    	$.get('/products/all');
    });
    }
</script>
</html>
