/*
 * 员工管理JS
 * 作者：赖伟森
 */
$(function(){
	var employeeId=null;
	var joindate=null;
	var deptno=0;
	var sex="";
	//设置系统页面标题
	$("span#mainpagetille").html("员工管理");
	
	//显示列表
	getListInfo();
	//显示列表函数
	function getListInfo(){
		$("table#Grid").jqGrid({
	        url:host+'employees/emp/get/list',
	        mtype: "POST",
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
	        height: 500,           //高度
	        rowNum: 10,            //每页显示多少记录
	        rowList:[10,20,30],    //每页显示多少记录（可选记录）
	        jsonReader: {         //json解析器
			      root: "list",    //列表的属性
			      page: "page",    //页号的属性
			      total: "pageCount", //页数的属性
			      records: "count",   //记录个数属性
			      repeatitems: true,  //循环记录
			      id: "empid"},       //主键
	        pager: "#GridPager",  //控件栏
	        multiselect:false,   //false只允许选中一条记录(默认) true能选中多条记录
	        onSelectRow:function(empid){
	        	employeeId=empid;
	        }
	    });
	}
	//设置检索参数，更新jQGrid的列表显示
	function reloadEmployeeList()
	{
		$("table#Grid").jqGrid('setGridParam',{postData:{deptno:deptno,sex:sex,joindate:joindate}}).trigger("reloadGrid");
		
	}
	//点击增加按钮弹出增加员工对话框
	$("a#AddLink").off().on("click",function(event){
		$("div#DialogArea").load("employees/emp/add.html",function(){
			$("div#DialogArea").dialog({
				title:"增加人员",
				width:600
			});
			//验证员工提交数据
			$("form#AddForm").validate({
				rules:{
					empid:{
						required:true,
						number:true,
						min:1,
						remote:host+"employees/emp/checkidexist"
					},
					deptno:{
						required:true,
						number:true,
						range:[1,10]
					},
					empname:{
						required:true
					},
					sex:{
						required:true,
						maxlength: 1
					},
					age:{
						required:true,
						number:true,
						min:18,
						max:35
					},
					joindate:{
						required:true,
						date:true
					},
					job:{
						required:true
					},
					wx:{
						required:true,
						wx:true
					}
				},
			messages:{
						empid:{
							required:"工号不能为空，请输入工号",
							number:"输入非法，请输入数字",
							min:"不能为0和负数",
							remote: "输入非法，工号已存在"  
						},
						deptno:{
							required:"部门号不能为空，请输入部门号",
							number:"输入非法，请输入数字",
							range:"部门编码为1-10"
						},
						empname:{
							required:"名字不能为空，请输入名字"
						},
						sex:{
							required:"性别不能为空，请输入性别",
							maxlength: "输入非法，请输入男或女"
						},
						age:{
							required:"年龄不能为空，请输入年龄",
							number:"输入非法，请输入数字",
							min:"年龄最小为18",
							max:"年龄最大为35"
						},
						joindate:{
							required:"入职日期不能为空，请输入入职日期",
							date:"输入非法，请输入日期类型yyyy-MM-dd"
						},
						job:{
							required:"职位不能为空，请输入职位"
						},
						wx:{
							required:"微信号不能为空，请输入微信号"
						}
			  }
			});
			//表单拦截器
			$("form#AddForm").ajaxForm(function(result){
				if(result.status=="OK"){
					reloadEmployeeList();
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
	//取得部门列表，并填充部门下拉框
	$.getJSON(host+"department/list/all",function(departmentList){
		if(departmentList){
			$.each(departmentList,function(index,dm){
				$("select[name='department.no']").append("<option value='"+dm.no+"'>"+dm.name+"</option>");
			});
		}
	});
	
	//定义部门下拉框的更新事件的处理
	$("select#DepartmentSelection").off().on("change",function(){
		departmentNo=$("select#DepartmentSelection").val();
		reloadEmployeeList();
	});
	//定义性别单选按钮更改事件
	$("input[name='empsex']").off().on("change",function(){
		sex=$("input[name='empsex']:checked").val();
		reloadEmployeeList();
	});
	//点击检索事件处理
	$("a#EmployeeSearchButton").on("click",function(){
		deptno=$("select#DepartmentSelection").val();
		sex=$("input[name='empsex']:checked").val();
		joindate=$("input#JoinDate").val();
		if(joindate==""){
			joindate=null;
		}
		reloadEmployeeList();
	});
	
	
});