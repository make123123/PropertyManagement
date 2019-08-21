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
        height: 300,           //高度
        rowNum: 5,            //每页显示多少记录
        rowList:[5,10,15],    //每页显示多少记录（可选记录）
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
	//更新jQGrid的列表显示
	function reloadList()
	{
		$("table#Grid").jqGrid().trigger("reloadGrid");
	}
//增加部门+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	$("a#AddLink").off().on("click",function(event){
		$("div#DialogArea").load("employees/dept/add.html",function(){
			//弹出对话框
			$("div#DialogArea").dialog({
				title:"增加部门",
				width:600
			});
			//验证员工提交数据
			$("form#AddForm").validate({
				rules:{
					deptno:{
						required:true,
						number:true,
						min:1,
						remote:host+"employees/dept/checkidexist"
					},
					deptname:{
						required:true
					}
				},
			messages:{
						deptno:{
							required:"部门编码不能为空，请输入部门编码",
							number:"输入非法，请输入数字",
							min:"不能为0和负数",
							remote: "输入非法，部门编码已存在"  
						},
						deptname:{
							required:"部门名称不能为空，请输入部门名称"
						}
			  }
			});
			//表单拦截器
			$("form#AddForm").ajaxForm(function(result){
				if(result.status=="OK"){
					reloadList();
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
	
//删除部门---------------------------------------------------------------------------------------------------------
	$("a#DeleteLink").off().on("click",function(){
		if(deptId==null){
			BootstrapDialog.show({
	            title: '删除部门信息',
	            message:"请选择要删除的部门",
	            buttons: [{
	                label: '确定',
	                action: function(dialog) {
	                    dialog.close();
	                }
	            }]
	        });
		}else{
			BootstrapDialog.show({
	            title: '删除部门信息',
	            message:"是否删除",
	            buttons: [
	            	{
		                label: '是',
		                action: function(dialog) {
		                	 $.post(host+"employees/dept/delete",{deptno:deptId},function(result){
		                		 if(result.status=="OK"){
		                			 BootstrapDialog.show({
			                			 title: '删除部门信息',
			             	            message:result.message
			                		 });
				    					reloadList();
				    				}
		                	 });
		                	dialog.close();
		                }
		            },{
		            	label: '否',
		            	action: function(dialog) {
		            		dialog.close();
		            	}
		               }     
	            ]
	        });
		}
	});
//修改部门信息******************************************************************************************************************
	$("a#ModifyLink").off().on("click",function(){
		if(deptId==null){
			BootstrapDialog.show({
	            title: '修改部门信息',
	            message:"请选择要修改的部门",
	            buttons: [{
	                label: '确定',
	                action: function(dialog) {
	                    dialog.close();
	                }
	            }]
	        });
		}else{
			$("div#DialogArea").load("employees/dept/modify.html",function(){
				//取得指定的部门信息
				$.getJSON(host+"employees/dept/get",{deptno:deptId},function(em){
							$("input#deptno").val(em.deptno);
							$("input#deptname").val(em.deptname);
	           });
				$("div#DialogArea").dialog({
					title:"修改部门",
					width:600
				});
				//验证员工提交数据
				$("form#ModifyForm").validate({
					rules:{
						deptno:{
							required:true,
							number:true
						},
						deptname:{
							required:true
						}
					},
				messages:{
							deptno:{
								required:"部门编码不能为空，请输入部门编码"	,
								number:"部门编码为数字"
							},
							deptname:{
								required:"部门名称不能为空，请输入部门名称"
							}
				  }
				});
				//表单拦截器
				$("form#ModifyForm").ajaxForm(function(result){
					if(result.status=="OK"){
						reloadList();
					}
					//修改默认的alert对话框
					BootstrapDialog.show({
			            title: '部门操作信息',
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
		    }
	           });
//查询部门信息............................................................................................................
	$("a#ViewLink").off().on("click",function(){
		if(deptId==null){
			BootstrapDialog.show({
	            title: '查看部门信息',
	            message:"请选择要查看的部门",
	            buttons: [{
	                label: '确定',
	                action: function(dialog) {
	                    dialog.close();
	                }
	            }]
	        });
		}else{
			$("div#DialogArea").load("employees/dept/view.html",function(){
				//取得指定的员工信息
				$.getJSON(host+"employees/dept/get",{deptno:deptId},function(em){
							$("input#deptno").val(em.deptno);
							$("input#deptname").val(em.deptname);
	           });
				$("div#DialogArea").dialog({
					title:"查看人员",
					width:600
				});
				//点击取消按钮，管理弹出窗口
				$("input[value='关闭']").off().on("click",function(){
					$("div#DialogArea").dialog( "close" );
					$("div#DialogArea").dialog( "destroy" );
					$("div#DialogArea").html("");
				});
				
		});
	}
	});
	
});