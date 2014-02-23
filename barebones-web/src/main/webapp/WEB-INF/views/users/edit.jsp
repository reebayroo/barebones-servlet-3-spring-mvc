<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="custom"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h3 class="ui  header">New User</h3>
<section class="edit ui segment">
	<c:url var="actionUrl" value="/users/save" />
	<form:form method="POST" class="ui form" action="${actionUrl}" id="userForm">
		<div class="three fields">
			<div class="field">
				<label>Login</label>
				<form:input path="login" placeholder="Login" autocomplete="false"  cssClass="required" />
			</div>
			<div class="field">
				<label>Password</label>
				<form:password placeholder="Password" path="rawPassword" autocomplete="false"  cssClass="required"/>
			</div>
		</div>
		<div class="three fields">
			<div class="field">
				<label for="firstName" class="control-label">First Name </label>
				<form:input path="firstName" placeholder="First Name"  cssClass="required" data-msg-required="If it has a Last Name must have a First" />
			</div>
			<div class="field">
				<label for="lastName" class="control-label">Last Name</label>
				<form:input placeholder="Last Name" path="lastName" autocomplete="false"  cssClass="required" auto-complete="false" />
			</div>
		</div>

		<div class="field">
			<button class="ui blue submit button">Save</button>
			<custom:anchor cssClass="ui right  submit red button" text="Back" href="/users/" />
		</div>

	</form:form>
</section>