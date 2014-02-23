<%@ taglib tagdir="/WEB-INF/tags/"  prefix="custom"%>
<aside class="menu">
	<div class="ui fluid vertical menu">
		<div class="header item">
			<i class="user icon"></i>
			Administration
		</div>
		<div class="item">
			Users
			<div class="menu">
				<custom:menu key="users" href="/users/" text="Users"/>
				<custom:menu key="admins" href="/users/" text="Administrators"/>
			</div>
		</div>
	</div>
</aside>