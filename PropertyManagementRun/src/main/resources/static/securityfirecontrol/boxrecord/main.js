/**
 * 保安部门js
 * 模块：securityfire
 * 业务对象：保安
 * 
 */
$(function(){
	var boxId=null;
	
	var boxno=null;
	var carno=null;
	var boxdate=null;
	var dutyno=null;
	var visitname=null;
	var vname = null;
	//设置系统页面标题
	$("span#mainpagetille").html("岗亭登记管理");
	
	
	
	
	
	//显示员工列表
	$("table#EmployeeGrid").jqGrid({
		url: 'securityBoxRecord/list/condition/page',
		datatype: "json",
		colModel: [
			{ label: '岗亭号码', name: 'boxno', width: 70 },
			{ label: '车牌号', name: 'carno', width: 70 },
			{ label: '登记日期', name: 'boxdate', width: 70 },
			{ label: '保安编号', name: 'dutyno', width: 70 },
			{ label: '来访人名', name: 'visitname', width: 70 }
		],
		caption:"岗亭登记列表",
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
		      id: "visitname" },
		pager: "#EmployeeGridPager",
		multiselect:false,
		onSelectRow:function(boxno){
			boxId=boxno;
		}
	});
	
	
	
	//设置检索参数，更新jQGrid的列表显示
	function reloadEmployeeList()
	{
		$("table#EmployeeGrid").jqGrid('setGridParam',{postData:{boxno:boxno,carno:carno,boxdate:boxdate,dutyno:dutyno,visitname:visitname}}).trigger("reloadGrid");
		
	};
	
	
	//----------------------------增加-------------------------------
	$("a#SecurityAddLink").off().on("click",function(){
		$("div#SecurityDialog").load("securityfirecontrol/boxrecord/add.html",function(){
			
			
			//验证保安提交数据
			$("form#SecurityAddForm").validate({
				  rules: {
				    dutyno: {
				      required: true,
				    },
				    boxno: {
					  required: true,
					},
					visitname:{
					  required: true
				    }
				  },
				  messages:{
					dutyno: {
					  required: "编号为空",
					},
					boxno: {
					  required: "岗亭号为空",
					},
					visitname:{
					  required:"来访人名称为空"
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
		            title: '岗亭操作信息',
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
		if(boxId==null){
			BootstrapDialog.show({
	            title: '岗亭操作信息',
	            message:"请选择要修改的岗亭信息",
	            buttons: [{
	                label: '确定',
	                action: function(dialog) {
	                    dialog.close();
	                }
	            }]
	        });
		}
		else{
			$("div#SecurityDialog").load("securityfirecontrol/boxrecord/modify.html",function(){
				//取得指定的员工信息
				$.getJSON("/securityBoxRecord/get",{visitname:boxId},function(em){
					if(em){
						$("input#bno").val(em.boxno);
						$("input#cno").val(em.carno);
						$("input#date").val(em.boxdate);
						$("input#dno").val(em.dutyno);
						$("input#vname").val(em.visitname);
						
					}
				});
				$("form#SecurityModifyForm").ajaxForm(function(result){
					if(result.status=="OK"){
						reloadEmployeeList();//更新员工列表
					}
					//alert(result.message);
					//BootstrapDialog.alert(result.message);
					BootstrapDialog.show({
			            title: '岗亭操作信息',
			            message:result.message
			        });
					$("div#SecurityDialog").dialog( "close" );
					$("div#SecurityDialog").dialog( "destroy" );
					$("div#SecurityDialog").html("");
					
				});
				$("div#SecurityDialog").dialog({
					title:"岗亭修改",
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
		if(boxId==null){
			BootstrapDialog.show({
	            title: '岗亭操作信息',
	            message:"请选择要删除的信息",
	            buttons: [{
	                label: '确定',
	                action: function(dialog) {
	                    dialog.close();
	                }
	            }]
	        });
		}
		else{
			$("div#SecurityDialog").load("securityfirecontrol/boxrecord/delete.html",function(){
				$.getJSON("/securityBoxRecord/get",{visitname:boxId},function(em){
					if(em){
						$("input#bno").val(em.boxno);
						$("input#dno").val(em.dutyno);				
						$("input#vname").val(em.visitname);				
					}
				});
				$("form#SecurityDeleteForm").ajaxForm(function(result){
					if(result.status=="OK"){
						reloadEmployeeList();//更新员工列表
					}
					//alert(result.message);
					//BootstrapDialog.alert(result.message);
					BootstrapDialog.show({
			            title: '岗亭操作信息',
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