
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><%@ page isELIgnored="false" %>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="https://editor.datatables.net/extensions/Editor/js/dataTables.editor.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<%--    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>--%>

    <meta charset="ISO-8859-1">
    <style>
        <%@include file="/css/table.css" %>
    </style>
    <jsp:include page="navBar.jsp" />
</head>
<Title>User Table</Title>
<body>
<table id="userTable" class="display" style="width:100%">
    <thead>
    <tr>
        <th>Login ID</th>
        <th>Email</th>
        <th>Username</th>
        <th>Age</th>
        <th>Gender</th>
        <th>Last Login</th>
        <th>Delete</th>
    </tr>
    </thead>

    <tfoot>
    <tr>
        <th>Login ID</th>
        <th>Email</th>
        <th>Username</th>
        <th>Age</th>
        <th>Gender</th>
        <th>Last Login</th>
        <th>Delete</th>
    </tr>
    </tfoot>
</table>
</body>

<script type="text/javascript">

    var token = "${_csrf.token}";

    $.ajaxSetup({
        beforeSend: function (xhr) {
            xhr.setRequestHeader('X-CSRF-TOKEN', token)
        }
    });

    $(document).ready(function () {
        var table = $('#userTable').DataTable({
            ajax: {
                url: 'showTable',
                dataSrc: ''
            },
            columns: [
                {data : "loginID"},
                {data : "email" },
                {data : "username"},
                {data : "age" },
                {data : "gender"},
                {data : "lastLogin",
                    render: function(data, type, row) {
                        if (type === "sort" || type === "type") {
                            return data;
                        }
                        return moment(data).format("MM-DD-YYYY || HH:mm");
                    }
                },
                {data:null, defaultContent:'<a href="" class="editor_remove">Delete</a>'} // future button will pass meta
            ],
            responsive: true
        });

        $('#userTable').on('click', 'a.editor_remove', function () {
            var row =  table.cell($(this).closest('tr').index(),0).data()
            alert(row);
            $.ajax({
                type: 'POST',
                url: 'delete',
                data: {data:row},
                success: function(data) {
                    alert("Login ID: " + row);
                    $(this).closest('tr').remove();
                    alert("Row deleted");
                },
                error: function(data) {
                    alert("It didn't work");
                },
            });
        });
    });

</script>

</html>
