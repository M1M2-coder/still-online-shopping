<p class="lead">SHOP ONLINE</p>
<div class="list-group">
	<c:forEach items="${categories}" var="category">
		<a href="${contextRoot}/show/category/${category.id}/products"
			class="list-group-item" id="a_${category.id}">${category.name}</a>
	</c:forEach>
</div>
