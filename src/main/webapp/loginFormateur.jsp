<%--
  Created by IntelliJ IDEA.
  User: yc
  Date: 09/11/2022
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="h-screen bg-gradient-to-br from-blue-600 to-indigo-600 flex justify-center items-center w-full">
    <form action="${pageContext.request.contextPath}/Formateur/login" method="post">
        <div class="bg-white px-10 py-8 rounded-xl w-screen shadow-md max-w-sm">
            <div class="space-y-4">
                <h1 class="text-center text-2xl font-semibold text-gray-600">Login</h1>
                <div>
                    <label for="email" class="block mb-1 text-gray-600 font-semibold">Email</label>
                    <input type="text" class="bg-indigo-50 px-4 py-2 outline-none rounded-md w-full" id="email"/>
                </div>
                <div>
                    <label for="password" class="block mb-1 text-gray-600 font-semibold">Password</label>
                    <input type="text" class="bg-indigo-50 px-4 py-2 outline-none rounded-md w-full" id="password"/>
                </div>
            </div>
            <button type="submit" class="mt-4 w-full bg-gradient-to-tr from-blue-600 to-indigo-600 text-indigo-100 py-2 rounded-md text-lg tracking-wide">Login</button>
        </div>
    </form>
</div>
</body>
</html>
