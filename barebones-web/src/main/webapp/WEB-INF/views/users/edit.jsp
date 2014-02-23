<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="custom"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

  <h3 class="ui  header">
  	New User
   </h3>
<section class="edit ui segment">

	<form class="ui form">
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
			<label>Password</label>
			<input type="password">
		</div>
		<div class="field">
			<button class="ui blue submit button">Save</button>
						<custom:anchor cssClass="ui right  submit red anchor " text="Back" href="/users/" />
			
		</div>

	</form>
</section>