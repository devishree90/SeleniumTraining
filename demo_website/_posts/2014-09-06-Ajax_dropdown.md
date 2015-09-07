---
title: Ajax DropDown
layout: post
---
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
  <script src="//cdn.datatables.net/1.10.5/js/jquery.dataTables.min.js"></script>

<script> 
var dataSet = [
    [ "Tiger Nixon", "System Architect", "Edinburgh", "5421", "2011/04/25", "$320,800" ],
    [ "Garrett Winters", "Accountant", "Tokyo", "8422", "2011/07/25", "$170,750" ]
];   
function showCustomer(value) {
    $('#example').DataTable( {
        data: dataSet,
        columns: [
            { title: "Name" },
            { title: "Position" },
            { title: "Office" },
            { title: "Extn." },
            { title: "Start date" },
            { title: "Salary" }
        ]
    } );
    document.getElementById('example').style.display = 'block';
}

</script>
<style>
table, td {
    border: 3px solid black;
}
</style>
</head>
<body>
    <form id="form1">
	<select name="customers" onchange="showCustomer(this.value)" runat="server">
	<option value="">Select a customer:</option>
	<option value="ALFKI">Alfreds Futterkiste</option>
	<option value="NORTS ">North/South</option>
	<option value="WOLZA">Wolski Zajazd</option>
	</select>
	<br>
	<table id="example" class="table" cellspacing="0" width="100%" border="2" style="display: none;">
	      <td>Name</td>
	      <td>Position</td>
	      <td>Office</td>
	      <td>Extn</td>
	      <td>Start date</td>
	      <td>Salary</td>
	  </table>
	 </form>
</body>
</html>


