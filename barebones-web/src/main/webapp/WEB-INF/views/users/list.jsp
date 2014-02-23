<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="custom"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>


<h3 class="ui  header">
	System Users
	<custom:anchor cssClass="ui right  floated green  button small " text="Create New" href="/users/new" />
</h3>
<section class=" ui segment">
	<form class="ui form ">
		<div class="two fields">
			<div class="field">
				<label>First Name</label>
				<input placeholder="First Name" type="text">
			</div>
			<div class="field">
				<label>Last Name</label>
				<input placeholder="Last Name" type="text">
			</div>
		</div>
		<div class="field">
			<label>Username</label>
			<input placeholder="Username" type="text">
		</div>
		<div class="field">
			<input type="submit" class="ui blue submit button" value="search" />
		</div>
	</form>
</section>