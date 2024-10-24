<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<head>
<meta charset="UTF-8">
<title>Sản phẩm</title>

<style type="text/css">
.pagination {
	display: inline-block;
	display: flex;
	justify-content: center;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border-radius: 5px;
}

.pagination a:hover:not (.active ){
	background-color: #ddd;
	border-radius: 5px;
}
</style>
</head>
<body>
	<div class="row">
		<div id="sidebar" class="span3">
			<div class="well well-small">
				<ul class="nav nav-list">
					<c:forEach items="${categories}" var="item">
						<li><a href="<c:url value="/product/${ item.id }"></c:url>"><span
								class="icon-circle-blank"></span>${ item.name }</a></li>
					</c:forEach>
				</ul>
			</div>

			<div class="well well-small alert alert-warning cntr">
				<h2>50% Discount</h2>
				<p>
					only valid for online order. <br> <br> <a
						class="defaultBtn" href="#">Click here </a>
				</p>
			</div>
			<div class="well well-small">
				<a href="#"><img src="assets/img/paypal.jpg"
					alt="payment method paypal"></a>
			</div>

			<a class="shopBtn btn-block" href="#">Upcoming products <br>
				<small>Click to view</small></a> <br> <br>
			<ul class="nav nav-list promowrapper">
				<li>
					<div class="thumbnail">
						<a class="zoomTool" href="product_details.html"
							title="add to cart"><span class="icon-search"></span> QUICK
							VIEW</a> <img src="assets/img/bootstrap-ecommerce-templates.png"
							alt="bootstrap ecommerce templates">
						<div class="caption">
							<h4>
								<a class="defaultBtn" href="product_details.html">VIEW</a> <span
									class="pull-right">$22.00</span>
							</h4>
						</div>
					</div>
				</li>
				<li style="border: 0">&nbsp;</li>
				<li>
					<div class="thumbnail">
						<a class="zoomTool" href="product_details.html"
							title="add to cart"><span class="icon-search"></span> QUICK
							VIEW</a> <img src="assets/img/shopping-cart-template.png"
							alt="shopping cart template">
						<div class="caption">
							<h4>
								<a class="defaultBtn" href="product_details.html">VIEW</a> <span
									class="pull-right">$22.00</span>
							</h4>
						</div>
					</div>
				</li>
				<li style="border: 0">&nbsp;</li>
				<li>
					<div class="thumbnail">
						<a class="zoomTool" href="product_details.html"
							title="add to cart"><span class="icon-search"></span> QUICK
							VIEW</a> <img src="assets/img/bootstrap-template.png"
							alt="bootstrap template">
						<div class="caption">
							<h4>
								<a class="defaultBtn" href="product_details.html">VIEW</a> <span
									class="pull-right">$22.00</span>
							</h4>
						</div>
					</div>
				</li>
			</ul>

		</div>
		<div class="span9">
			<!-- 
New Products
-->
			<div class="well well-small">
				<div class="row">
					<span style="margin-left: 25px">Sort</span> <select
						class="pull-right">
						<option>A-Z</option>
						<option>High-Low</option>
						<option>Low-High</option>
					</select>
				</div>
				<h3>List Products</h3>


				<c:if test="${ products.size() > 0 }">
					<div class="row-fluid">
						<ul class="thumbnails">
							<c:forEach items="${ products }" var="item" varStatus="status">
								<li class="span4">
									<div class="thumbnail">
										<a href="#" class="overlay"></a> <a class="zoomTool" href="#"
											title="add to cart"><span class="icon-search"></span>
											QUICK VIEW</a> <a
											href="<c:url value="/detailProduct/${ item.idProduct }"/>"><img
											src="<c:url value="/assets/user/img/${ item.img }"/>" alt=""></a>
										<div class="caption cntr">
											<p>${ item.nameProduct }</p>
											<p>
												<strong> <fmt:formatNumber type="number"
														groupingUsed="true" value="${ item.price }" />₫
												</strong>
											</p>
											<h4>
												<a class="shopBtn" href="#" title="add to cart"> Add to
													cart </a>
											</h4>
											<div class="actionList">
												<a class="pull-left" href="#">Add to Wish List </a> <a
													class="pull-left" href="#"> Add to Compare </a>
											</div>
											<br class="clr">
										</div>
									</div>
								</li>


								<c:if
									test="${ (status.index + 1) % 3 == 0 || (status.index + 1) == products.size()}">
						</ul>
					</div>
					<c:if test="${ (status.index + 1) < products.size()}">
						<div class="row-fluid">
							<ul class="thumbnails">
					</c:if>
				</c:if>
				</c:forEach>
				</c:if>
			</div>
		</div>
	</div>

	<div class="pagination">

		<a href="#">&laquo;</a>
		<c:forEach begin="1" end="${ pagination.totalPage }" var="item"
			varStatus="status">
			<a
				class="${ status.index == pagination.currentPage ? 'active' : '' }"
				href="<c:url value="/product/${ idCategory }/${ status.index }"/>">${status.index}</a>
		</c:forEach>
		<a href="#">&raquo;</a>
	</div>



	<!-- 
Clients 
-->
	<section class="our_client">
		<hr class="soften" />
		<h4 class="title cntr">
			<span class="text">Manufactures</span>
		</h4>
		<hr class="soften" />
		<div class="row">
			<div class="span2">
				<a href="#"><img alt="" src="assets/img/1.png"></a>
			</div>
			<div class="span2">
				<a href="#"><img alt="" src="assets/img/2.png"></a>
			</div>
			<div class="span2">
				<a href="#"><img alt="" src="assets/img/3.png"></a>
			</div>
			<div class="span2">
				<a href="#"><img alt="" src="assets/img/4.png"></a>
			</div>
			<div class="span2">
				<a href="#"><img alt="" src="assets/img/5.png"></a>
			</div>
			<div class="span2">
				<a href="#"><img alt="" src="assets/img/6.png"></a>
			</div>
		</div>
	</section>
</body>
</html>