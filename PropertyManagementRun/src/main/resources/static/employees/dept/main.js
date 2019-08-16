/*
 * 部门管理JS
 *  作者：赖伟森
 */
$(function(){
	var deptId=null;
	//设置系统页面标题
	$("span#mainpagetille").html("部门管理");
	
	$("table#Grid").jqGrid({
        url: 'employees/dept/get/list',
        mtype: "GET",
		styleUI : 'Bootstrap',
        datatype: "json",
        colModel: [
            { label: '部门号', name: 'deptno', key: true, width:50 },
            { label: '部门名', name: 'deptname', width: 50 }
        ],
        caption:"部门列表",     //设置表格标题
        autowidth: true,       //自动宽度
		viewrecords: true,     //记录总数
        height: 350,           //高度
        rowNum: 20,            //每页显示多少记录
        rowList:[10,20,30],    //每页显示多少记录（可选记录）
        jsonReader: {         //json解析器
		      root: "list",    //列表的属性
		      page: "page",    //页号的属性
		      total: "pageCount", //页数的属性 
		      records: "count",   //总个数属性
		      repeatitems: true,  //循环记录
		      id: "deptno"},       //主键
        pager: "#GridPager",  //控件栏
        multiselect:false,   //false只允许选中一条记录(默认) true能选中多条记录
        onSelectRow:function(deptno){
        	deptId=deptno;
        }
    });
});