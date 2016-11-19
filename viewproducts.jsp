<%@ include file="header.jsp"%>




<div class="container" ng-app="myApp" ng-controller="MyController" ng-init="getDataFromServer()">

  <form>
 <!--  Search option -->
    <div class="form-group">
      <div class="input-group">
        <div class="input-group-addon"><i class="fa fa-search"></i></div>
       <input type="text" class="form-control" placeholder="Search Product Name" ng-model="searchPTitle">      
       </div>      
    </div>
  </form>
  <table class="table table-hover" style="min-width:1200px">
  <!--  Table header section -->
   <thead>
      <tr>
      <td>
          <a href="#" ng-click="sortType = 'prod_id'; sortReverse = !sortReverse">
            Product Id 
            <span ng-show="sortType == 'prod_id' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'prod_id' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
         <td>
          <a href="#" ng-click="sortType = 'prod_name'; sortReverse = !sortReverse">
            Product Name 
            <span ng-show="sortType == 'prod_name' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'prod_name' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
         <td>
          <a href="#" ng-click="sortType = 'quantity'; sortReverse = !sortReverse">
          Quantity
            <span ng-show="sortType == 'quantity' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'quantity' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'prod_price'; sortReverse = !sortReverse">
          Price
            <span ng-show="sortType == 'prod_price' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'prod_price' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
         <td>
          <a href="#" ng-click="sortType = 'more'; sortReverse = !sortReverse">
          Image
            <span ng-show="sortType == 'more' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'more' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
         </tr>
    </thead>
    
    <!-- showing product details -->
     <tbody>
      <tr ng-repeat="p1 in prod | orderBy:sortType:sortReverse | filter:searchPTitle">
           		<td>{{p1.prod_id}}</td>
           		<td>{{p1.prod_name}}</td>
           		<td>{{p1.quantity}}</td>
           		<td>{{p1.prod_price}}</td>
           		<td><img src="resources/images/{{p1.prod_name}}.jpg" style="height:100px;width:100px"></td>
           		
   
      <!--  <td><a href="Deleteproduct&{{p1.id}}">Delete</a></td>
        <td><a href="Updateprod&{{p1.id}}">Edit</a></td>  
 
 <td><a href="viewDetail?{{p1.id}}">view</a>   -->     	
     
      </tr>
    </tbody>
    
  </table>
  <a href="addproduct"><h1 align="center"><h2><font color="white">Back</a></center>
</div>



<%-- <div>
	<div class="container">
		<div ng-app="myApp" ng-controller="dataCtrl">
			<hr>
			<table class="table table-striped">
				<tr>
					<th>Id</th>
					<th>Product Name</th>
					<th>Product Price</th>
					<th>Quantity</th>
					<th>Product Image</th>
				</tr>
				<tr>
					<td>${product.prod_id }</td>
					<td>${product.prod_name }</td>
					<td>${product.prod_price }</td>
					<td>${product.quantity }</td>
					<!-- ALL THE PRODUCTS CAN BE VIEWED -->
					<td><img src="resources/images/${product.prod_name}.jpg"
						style="height: 100px; width: 100px;"></td>
					<td><a href="viewdetails?name{product.prod_name}">View</a></td>
				</tr>

			</table>

		</div>
	</div>
</div>
 --%><%@ include file="footer.jsp"%>
