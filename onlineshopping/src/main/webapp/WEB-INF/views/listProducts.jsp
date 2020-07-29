<div class="container">
	<div class="row">
		<div class="col-md-3">
			<!-- SIDEBAR SECTION -->
			<%@include file="./shared/sidebar.jsp"%>
		</div>

		<div class="col-md-9">
			<div class="row">
				<div class="col-xs-12">
					<!-- BREADCRUMB  -->
					<c:if test="${userClickAllProducts == true}">
						<script>
							window.categoryId = '';
						</script>

						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li>All Products</li>
						</ol>
						<!-- To display the actual products -->
						<div class="row">
							<div class="col-xs-12">
								<table id="productListTable"
									class="table table-striped table-borded">
									<thead>

										<tr>
											<th></th>
											<th>Name</th>
											<th>Brand</th>
											<th>Price</th>
											<th>Qty. Available</th>
											<th></th>
										</tr>

									</thead>
								</table>
							</div>
						</div>
					</c:if>

					<c:if test="${userClickCategoryProducts == true}">

						<script>
							window.categoryId = '${category.id}';
						</script>

						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li>Category</li>
							<li>${category.name}</li>
						</ol>
						<!-- To display the actual products -->
						<div class="row">
							<div class="col-xs-12">
								<table id="productListTable"
									class="table table-striped table-borded">
									<thead>

										<tr>
											<th></th>
											<th>Name</th>
											<th>Brand</th>
											<th>Price</th>
											<th>Qty. Available</th>
											<th></th>
										</tr>

									</thead>
								</table>
							</div>
						</div>
					</c:if>
				</div>


			</div>
		</div>
	</div>
</div>