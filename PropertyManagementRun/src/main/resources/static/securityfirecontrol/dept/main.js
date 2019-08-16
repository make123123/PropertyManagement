/**
 * 保安部门js
 * 模块：securityfire
 * 业务对象：保安
 * 
 */
$(function(){
	var securityId=null;
	
	var securityno=null;
	var securityname=null;
	var securitysex=null;
	var securityage=null;
	
	//设置系统页面标题
	$("span#mainpagetille").html("保安部门管理");
	
	
	//显示员工列表
	$("table#EmployeeGrid").jqGrid({
		url: 'securitydept/list/condition/page',
		datatype: "json",
		colModel: [
			{ label: '编号', name: 'securityno', width: 70 },
			{ label: '姓名', name: 'securityname', width: 70 },
			{ label: '性别', name: 'securitysex', width: 70 },
			{ label: '年龄', name: 'securityage', width: 70 }
		],
		caption:"保安部门列表",
		viewrecords: true,
		autowidth: true,
		height: 400,
		rowNum: 20,
		rowList:[10,20,30],
		jsonReader : { 
		      root: "list", 
		      page: "page", 
		      total: "pageCount", 
		      records: "count", 
		      repeatitems: true, 
		      id: "securityno"},
		pager: "#EmployeeGridPager",
		multiselect:false,
		onSelectRow:function(securityno){
			securityId=securityno;
		}
	});
	
	
	
	
	
});