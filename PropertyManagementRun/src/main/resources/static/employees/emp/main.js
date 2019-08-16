/*
 * 员工管理JS
 * 作者：赖伟森
 */
$(function(){
	var employeeId=null;
	//设置系统页面标题
	$("span#mainpagetille").html("员工管理");
	
	//显示列表
	getListInfo();
	//显示列表函数
	function getListInfo(){
		$("table#Grid").jqGrid({
	        url: 'employees/emp/get/list',
	        mtype: "GET",
			styleUI : 'Bootstrap',
	        datatype: "json",
	        colModel: [
	            { label: '工号', name: 'empid', key: true, width: 10 },
	            { label: '部门', name: 'dept.deptname', width: 10 },
	            { label: '姓名', name: 'empname', width: 10 },
	            { label: '性别', name: 'sex', width: 10 },
	            { label: '年龄', name: 'age', width: 10 },
	            { label: '入职日期', name: 'joindate', width: 10 },
	            { label: '职位', name: 'job', width: 10 },
	            { label: '微信', name: 'wx', width: 10 }
	        ],
	        caption:"员工列表",     //设置表格标题
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
			      id: "empid"},       //主键
	        pager: "#GridPager",  //控件栏
	        multiselect:false,   //false只允许选中一条记录(默认) true能选中多条记录
	        onSelectRow:function(empid){
	        	employeeId=empid;
	        }
	    });
	}
	//点击增加按钮弹出增加员工对话框
	$("a#AddLink").off().on("click",function(event){
		$("div#DialogArea").load("employees/emp/add.html",function(){
			$("div#DialogArea").dialog({
				title:"增加人员",
				width:600
			});
			//表单拦截器
			$("form#AddForm").ajaxForm(function(result){
				if(result.status=="OK"){
					getListInfo();
				}
				//修改默认的alert对话框
				BootstrapDialog.show({
		            title: '员工操作信息',
		            message:result.message
		        });
				$("div#DialogArea").dialog( "close" );
				$("div#DialogArea").dialog( "destroy" );
				$("div#DialogArea").html("");
			});
			//点击取消按钮处理
			$("input[value='取消']").on("click",function(){
				$("div#DialogArea").dialog( "close" );
				$("div#DialogArea").dialog( "destroy" );
				$("div#DialogArea").html("");
			});
			
		});
			
			
		
	});
});