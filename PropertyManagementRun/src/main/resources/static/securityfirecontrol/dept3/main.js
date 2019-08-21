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
		height: 750,
		rowNum: 20,
		rowList:[10,20,30,40],
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
	
	
	
	//设置检索参数，更新jQGrid的列表显示
	function reloadEmployeeList()
	{
		$("table#EmployeeGrid").jqGrid('setGridParam',{postData:{securityno:securityno,securityname:securityname,securitysex:securitysex,securityage:securityage}}).trigger("reloadGrid");
		
	};
	
	
	//----------------------------增加-------------------------------
	$("a#SecurityAddLink").off().on("click",function(){
		$("div#SecurityDialog").load("securityfirecontrol/dept/add.html",function(){
			
			
			//验证保安提交数据
			$("form#SecurityAddForm").validate({
				  rules: {
				    securityno: {
				      required: true,
				      remote: "securitydept/checkidexist"
				    },
				    securityname:{
				    	required: true
				    },
				    securityage:{
				    	number: true,
				    	min:18,
				    	max:70,
				    	range: [18, 70]
				    }
				  },
				  messages:{
					securityno: {
					      required: "编号为空",
					      remote:"编号已经存在"
					    },
					securityname:{
					    	required:"保安名称为空"
					},
					securityage:{
						number: "年龄必须是数值",
				    	range:"年龄需要在18和70之间"
					}
				 }
			});
			
			//拦截增加提交表单
			$("form#SecurityAddForm").ajaxForm(function(result){
				if(result.status=="OK"){
					reloadEmployeeList();//更新员工列表
				}
				//alert(result.message);
				//BootstrapDialog.alert(result.message);
				BootstrapDialog.show({
		            title: '部门操作信息',
		            message:result.message
		        });
				$("div#SecurityDialog").dialog( "close" );
				$("div#SecurityDialog").dialog( "destroy" );
				$("div#SecurityDialog").html("");
				
			});
			
			$("div#SecurityDialog").dialog({
				title:"保安增加",
				width:400
			});
			
			
			//点击取消按钮，管理弹出窗口
			$("input[value='取消']").off().on("click",function(){
				$("div#SecurityDialog").dialog("close");
				$("div#SecurityDialog").dialog("destroy")
				$("div#SecurityDialog").html("");
			});
		});
	});
	
	
	//===============================修改员工处理===============================================================
	$("a#SecurityeModifyLink").off().on("click",function(){
		if(securityId==null){
			BootstrapDialog.show({
	            title: '保安操作信息',
	            message:"请选择要修改的保安",
	            buttons: [{
	                label: '确定',
	                action: function(dialog) {
	                    dialog.close();
	                }
	            }]
	        });
		}
		else{
			$("div#SecurityDialog").load("securityfirecontrol/dept/modify.html",function(){
				//取得指定的员工信息
				$.getJSON("/securitydept/get",{securityno:securityId},function(em){
					if(em){
						$("input#no").val(em.securityno);
						$("input#name").val(em.securityname);
						$("input#age").val(em.securityage);
						$("span#sex").html(em.securitysex);
						
					}
				});
				$("form#SecurityModifyForm").ajaxForm(function(result){
					if(result.status=="OK"){
						reloadEmployeeList();//更新员工列表
					}
					//alert(result.message);
					//BootstrapDialog.alert(result.message);
					BootstrapDialog.show({
			            title: '部门操作信息',
			            message:result.message
			        });
					$("div#SecurityDialog").dialog( "close" );
					$("div#SecurityDialog").dialog( "destroy" );
					$("div#SecurityDialog").html("");
					
				});
				$("div#SecurityDialog").dialog({
					title:"保安修改",
					width:400
				});
				//点击取消按钮，管理弹出窗口
				$("input[value='取消']").off().on("click",function(){
					$("div#SecurityDialog").dialog("close");
					$("div#SecurityDialog").dialog("destroy")
					$("div#SecurityDialog").html("");
				});
				
				
			});
		}
	});
	
	
	//===============================删除员工处理===============================================================
	$("a#SecurityeDeleteLink").off().on("click",function(){
		if(securityId==null){
			BootstrapDialog.show({
	            title: '保安操作信息',
	            message:"请选择要删除的保安",
	            buttons: [{
	                label: '确定',
	                action: function(dialog) {
	                    dialog.close();
	                }
	            }]
	        });
		}
		else{
			$("div#SecurityDialog").load("securityfirecontrol/dept/delete.html",function(){
				$.getJSON("/securitydept/get",{securityno:securityId},function(em){
					if(em){
						$("input#no").val(em.securityno);
						$("input#name").val(em.securityname);				
					}
				});
				$("form#SecurityDeleteForm").ajaxForm(function(result){
					if(result.status=="OK"){
						reloadEmployeeList();//更新员工列表
					}
					//alert(result.message);
					//BootstrapDialog.alert(result.message);
					BootstrapDialog.show({
			            title: '部门操作信息',
			            message:result.message
			        });
					$("div#SecurityDialog").dialog( "close" );
					$("div#SecurityDialog").dialog( "destroy" );
					$("div#SecurityDialog").html("");
					
				});
				$("div#SecurityDialog").dialog({
					title:"保安删除",
					width:400
				});
				//点击取消按钮，管理弹出窗口
				$("input[value='取消']").off().on("click",function(){
					$("div#SecurityDialog").dialog("close");
					$("div#SecurityDialog").dialog("destroy")
					$("div#SecurityDialog").html("");
				});
				
				
				
			});
		
		
		}
		
	});
	
	
	
	
	
	
});