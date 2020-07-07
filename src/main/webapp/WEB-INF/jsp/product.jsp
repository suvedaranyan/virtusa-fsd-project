<%@ include file="header.jsp" %>

<div class="container">    
  <div class="row">
  
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading"> ${product.name} </div>
        <div class="panel-body">
        <p>Price : ${product.price}  </p>
		<p>GST :  ${product.gst} %</p>  
        </div>
        <div class="panel-footer"> <button type="button" class="btn btn-primary btn-md"
           onClick="location.href=' ';calculate()">Buy</button></div>
      </div>
    </div>
   
  </div>
</div><br>

</body>
<script>
  function calculate() {
    var price = ${product.price};
    var gst = ${product.gst};
    var t = price + (gst/100)*price;
    alert("Total price = "+t);
    }
</script>
</html>
