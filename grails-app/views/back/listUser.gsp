<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main" />
    <title></title>
</head>

<body>
<table>
    <div class="container">
        <div class="row justify-content-md-center" >
            <div class="col col-lg-2">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Username</th>
                    <th scope="col">Role</th>
                </tr>
                </thead>
                <tbody>
                <g:each in="${listUser}">
                    <tr>
                        <th scope="row">${it.id}</th>
                        <td>${it.username}</td>
                        <td>${it.getAuthorities()}</td>
                    </tr>
                </g:each>
                </tbody>
            </table>
            </div>
        </div>
    </div>

</body>
</html>