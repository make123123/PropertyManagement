/*
 * 员工管理JS
 */
$(function(){
	var employeeId=null;
	//设置系统页面标题
	$("span#mainpagetille").html("员工管理");
	$("#EmployeeGrid").jqGrid({
        url: 'employees/emp/get/list',
        mtype: "GET",
		styleUI : 'Bootstrap',
        datatype: "jsonp",
        colModel: [
            { label: '工号', name: 'empid', key: true, width: 10 },
            { label: '部门', name: 'deptno', width: 10 },
            { label: '姓名', name: 'empname', width: 10 },
            { label: '性别', name: 'sex', width: 10 },
            { label: '年龄', name: 'age', width: 10 }
            { label: '入职日期', name: 'joindate', width: 10 },
            { label: '职位', name: 'job', width: 10 }
            { label: '微信', name: 'wx', width: 10 }
        ],
        caption:"员工列表",     //设置表格标题
        autowidth: true,       //自动宽度
		viewrecords: true,     //记录总数
        height: 250,           //高度
        rowNum: 20,            //每页显示多少记录
        rowList:[10,20,30],    //每页显示多少记录（可选记录）
        jsonReader : {         //json解析器
		      root: "list",    //列表内容
		      page: "page",    //当前页数
		      total: "pageCount", //页数总数
		      records: "count",   //记录总数
		      repeatitems: true,  //循环记录
		      id: "empid"},       //主键
        pager: "#EmployeeGridPager"  //控件栏
        multiselect:false,   //false只允许选中一条记录(默认) true能选中多条记录
        onSelectRow:function(empid){
        	employeeId=empid;
        }
    });
});