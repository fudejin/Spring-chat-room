<html>
<head>
<title>Oops!</title>
<link rel="stylesheet" th:href="@{/style.css}"></link>
</head>
<html>
<div class="errorPage">
	<span class="oops">Oops!</span><br /> <img th:src="@{/MissingPage.png}"></img>
	<p>
		There seems to be a problem with the page you requested (<span
			th:text="${path}"></span>).
	</p>
	Show requested path
	<p th:text="${'Details: ' + message}"></p>
</div>
</html>
</html>
