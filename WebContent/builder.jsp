<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="includes/header.jsp" %> 
<body>

<%
	Connection conn = (Connection) session.getAttribute("conn");	
	String action = request.getParameter("action");
	String error = "";
	String importResults = "";

	DecimalFormat formatter = new DecimalFormat("###,###,###,###.##");

	if(action != null && action.equals("placeholder")) {
		
	}
	else if(action != null && action.equals("importData")) {
		Properties prop = new Properties();
		ServletContext servletContext = session.getServletContext();
		prop.load(new FileInputStream(servletContext.getRealPath("/global.properties")));	

		String tomcatLocation = prop.getProperty("tomcatLocation");
	    String fileName = request.getParameter("fileName");
	   	String filePath = tomcatLocation + "webapps/data/feed.xls";
		if(!filePath.trim().equals("")){

			ExcelReader excelBook = new ExcelReader();
			try{
				int importCount = excelBook.ingestExcelFile(filePath, fileName, conn);
				if(importCount>0){
					importResults = new Integer(importCount).toString() + " items were imported.";
%>
<div id="dialog-message" title="Import Successful">
	<p>
		<span class="ui-icon ui-icon-circle-check" style="float:left; margin:0 7px 50px 0;"></span>
		<%=importResults %>
	</p>
</div>
<script>
	$(function() {
		$( "#dialog-message" ).dialog({
			modal: true,
			buttons: {
				OK: function() {
					$( this ).dialog( "close" );
				}
			}
		});
	});
</script>
<%
				} // end if(importCount>0){
			} // end try{
			catch(Exception ex){
				importResults = ex.getMessage();
%>
<div id="dialog-message" title="Import Failed">
	<p>
		<span class="ui-icon ui-icon-notice" style="float:left; margin:0 7px 50px 0;"></span>
		<%=importResults %>
	</p>
</div>
<script>
	$(function() {
		$( "#dialog-message" ).dialog({
			modal: true,
			buttons: {
				OK: function() {
					$( this ).dialog( "close" );
				}
			}
		});
	});
</script>
<%				
			} // end catch(Exception ex){			
		} // end if(!filePath.trim().equals("")){	
	} // end else if(action != null && action.equals("importData")) {
	
%>
<form action="builder.jsp" method="post" accept-charset="utf-8">
<input type="hidden" name="action" value="searchPart">
<table class="cleartable" >
	<tr>
		<td>
			<table class="gridtable" style="display:inline-block;table-layout:fixed;width:380px;">
				<col style="overflow:hidden;width:100px;" id="colSearchTitle"/>
				<col style="overflow:hidden;width:250px;" id="colSearchValue"/>
				<tr>
					<th colspan="2"><div style="overflow:hidden;">SEARCH PARTS</div>
					</th>
				</tr>
				<tr>
					<th><div class="criteria">CATEGORY:</div>
					</th>
					<td><div class="criteria">
						<select style="width:165px;" name="brand">

							<option value="" <%=(true)?"selected":"" %>>ASD</option>

						</select></div>
					</td>
				</tr>
				<tr>
					<th><div class="criteria">PART NO.:</div>
					</th>
					<td><div class="criteria">
						<select style="width:165px;" name="brand">

							<option value="" <%=(true)?"selected":"" %>>ASD</option>

						</select></div>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>
<br />

<table id="results" class="gridtable" style="table-layout:fixed;width:520px;">
	<col style="overflow:hidden;width:170px;" id="colPartNo"/>

	<tr>
		<th rowspan="2" >PART NO.
		</th>
		
	</tr>

	<tr>
		<td>ASD
		</td>
	</tr>

</table>



<%
	if(userLogin!=null && userLogin.getAccType().equals(LoginModel.CONST_ACC_TYPE_ADMIN)){
%>
<br />
<form action="file_upload.jsp" method="post" accept-charset="utf-8" enctype="multipart/form-data">
<input type="hidden" name="action" value="importData">
<table class="gridtable">
	<tr>
		<td colspan="2">Import New Data File
		</td>
	</tr>
	<tr>
		<td>Select file to import: 
		</td>
		<td><input type='file' name="filepath"/>
		</td>
	</tr>
	<tr>
		<td>&nbsp;
		</td>
		<td><input type="submit" value="Import" />
		</td>
	</tr>
	<tr>
		<td colspan="2"><%=(GeneralConfigManager.getConfig(GeneralConfigModel.CONFIG_LAST_IMPORTED_FILENAME, conn)!=null)?"The last imported file was " + GeneralConfigManager.getConfig(GeneralConfigModel.CONFIG_LAST_IMPORTED_FILENAME, conn).getContents():"This database is empty." %>
		</td>
	</tr>
<%
		if(!importResults.trim().equals("")){
%>
	<tr>
		<td colspan="2"><%=importResults %>
		</td>
	</tr>
<%
		}
%>
</table>
</form>
<%
	} // if(userLogin.getAccType().equals(LoginModel.CONST_ACC_TYPE_ADMIN)){
%>
</body>
<%@include file="includes/footer.jsp" %>   
</html>