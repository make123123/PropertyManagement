/**
 * 员工前端主管理JS
 * 模块：HR
 * 业务对象：员工
 * 作者:吕海东
 * 
 */
$(function(){
	var areaNo=0;
	var areaname=null;
	var aaddress=null;
	var developer=null;
	var totalbuidingarea=0;
	var totalusearea=0;
	var totalpackarea=0;
	var totalhome=0;
	var totalhouse=0;
	var totalpack=0;
	//设置系统页面标题
	$("span#mainpagetille").html("小区管理");
	//设置日期的格式和选择
	
	//显示小区信息列表
	$("table#EmployeeGrid").jqGrid({
		url: host+'area/list/condition/page',
		datatype: "json",
		colModel: [
			{ label: '小区编号', name: 'areano', width: 75 },
			{ label: '小区名称', name: 'areaname', width: 90 },
			{ label: '小区地址', name: 'aaddress', width: 100 },
			{ label: '开发商', name: 'developer', width: 40 },
			{ label: '总建筑面积', name: 'totalbuidingarea', width: 50},
			{ label: '总使用面积', name: 'totalusearea', width: 70 },
			{ label: '车位面积', name: 'totalpackarea', width: 70 },
			{ label: '总居民数', name: 'totalhome', width: 40 },
			{ label: '总公建数', name: 'totalhouse', width: 40 },
			{ label: '车位数', name: 'totalpack', width: 40 }
		],
		caption:"小区信息列表",
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
		      id: "areano"},
		pager: "#EmployeeGridPager",
		multiselect:false,
		onSelectRow:function(no){
			areaNo=no;
		}
		
	});
	
	//取得小区名列表，填充小区名下拉框
	$.getJSON(host+"area/get/list",function(departmentList){
		if(departmentList){
			$.each(departmentList,function(index,dm){
				$("select#ArSelection").append("<option value='"+dm.areaname+"'>"+dm.areaname+"</option>");
			});
		}
	});
	//取得小区地址列表，填充小区地址下拉框
	$.getJSON(host+"area/get/list",function(roleList){
		if(roleList){
			$.each(roleList,function(index,rm){
				$("select#AdSelection").append("<option value='"+rm.aaddress+"'>"+rm.aaddress+"</option>");
			});
		}
	});
	//取得开发商，填充开发商下拉框
	$.getJSON(host+"area/get/list",function(roleList){
		if(roleList){
			$.each(roleList,function(index,rm){
				$("select#DeSelection").append("<option value='"+rm.developer+"'>"+rm.developer+"</option>");
			});
		}
	});
//	设置检索参数，更新jQGrid的列表显示
	function reloadAreaList()
	{
		$("table#EmployeeGrid").jqGrid('setGridParam',{postData:{areaname:areaname,aaddress:aaddress,developer:developer}}).trigger("reloadGrid");
		//对于控制层显示列表的条件
	}
	//点击检索事件处理
	$("a#EmployeeSearchButton").on("click",function(){
		areaname=$("select#ArSelection").val();
		aaddress=$("select#AdSelection").val();
		developer=$("select#DeSelection").val();
		reloadAreaList();
	});
	//===========================增加小区信息处理================================================
	$("a#EmployeeAddLink").off().on("click",function(){
		$("div#EmployeeDialog").load("area/add.html",function(){
			//验证员工提交数据
			$("form#EmployeeAddForm").validate({
				  rules: {
					areano: {
				      required: true,
				      remote: host+"area/checkareanoexist"
				      
				    },
				    areaname:{
				    	required: true
				    },
				    aaddress:{
				    	required: true
				    },
				    developer:{
				    	required:true,
				    }
				  },
				  messages:{
					areano: {
					     required: "小区编号为空",
					     remote:"小区编号已经存在"
					    },
					areaname:{
					     required:"小区名称为空"
					},
					aaddress:{
						 required:"小区地址为空"
					},
					developer:{
				    	required:"开发商为空",
				    }
				 }
			});
			//拦截增加提交表单
			$("form#EmployeeAddForm").ajaxForm(function(result){
				if(result.status=="OK"){
					reloadAreaList();//更新员工列表
				}
				//alert(result.message);
				//BootstrapDialog.alert(result.message);
				BootstrapDialog.show({
		            title: '小区操作信息',
		            message:result.message
		        });
				$("div#EmployeeDialog").dialog( "close" );
				$("div#EmployeeDialog").dialog( "destroy" );
				$("div#EmployeeDialog").html("");
				
			});
			
			$("div#EmployeeDialog").dialog({
				title:"小区增加",
				width:950
			});
			//点击取消按钮，管理弹出窗口
			$("input[value='取消']").off().on("click",function(){
				$("div#EmployeeDialog").dialog("close");
				$("div#EmployeeDialog").dialog("destroy")
				$("div#EmployeeDialog").html("");
			});
			
			
		});
		
	});
	
	//===============================修改小区处理===============================================================
	$("a#EmployeeModifyLink").off().on("click",function(){
		if(areaNo==0){
			BootstrapDialog.show({
	            title: '小区操作信息',
	            message:"请选择要修改的小区",
	            buttons: [{
	                label: '确定',
	                action: function(dialog) {
	                    dialog.close();
	                }
	            }]
	        });
		}
		else{
			$("div#EmployeeDialog").load("area/modify.html",function(){
				
				//取得指定的员工信息
				$.getJSON(host+"/area/get",{areano:areaNo},function(am){
					if(am){
						$("input[name='areano']").val(areaNo);
						$("input[name='areaname']").val(am.areaname);
						$("input[name='aaddress']").val(am.aaddress);
						$("input[name='developer']").val(am.developer);
						$("input[name='totalbuidingarea']").val(am.totalbuidingarea);
						$("input[name='totalusearea']").val(am.totalusearea);
						$("input[name='totalpackarea']").val(am.totalpackarea);
						$("input[name='totalhome']").val(am.totalhome);
						$("input[name='totalhouse']").val(am.totalhouse);
						$("input[name='totalpack']").val(am.totalpack);
						
					}
				});
				
				//拦截增加提交表单
				$("form#EmployeeModifyForm").ajaxForm(function(result){
					if(result.status=="OK"){
						reloadAreaList();//更新员工列表
					}
					//alert(result.message);
					//BootstrapDialog.alert(result.message);
					BootstrapDialog.show({
			            title: '小区操作信息',
			            message:result.message
			        });
					$("div#EmployeeDialog").dialog( "close" );
					$("div#EmployeeDialog").dialog( "destroy" );
					$("div#EmployeeDialog").html("");
					
				});
			
				
				$("div#EmployeeDialog").dialog({
					title:"小区修改",
					width:800
				});

				//点击取消按钮，管理弹出窗口
				$("input[value='取消']").off().on("click",function(){
					$("div#EmployeeDialog").dialog("close");
					$("div#EmployeeDialog").dialog("destroy")
					$("div#EmployeeDialog").html("");
				});
				
				
			});
		}
	});
	
	//===============================小区删除处理===============================================================
	
	$("a#EmployeeDeleteLink").off().on("click",function(){
		if(areaNo==0){
			BootstrapDialog.show({
	            title: '小区操作信息',
	            message:"请选择要删除的小区",
	            buttons: [{
	                label: '确定',
	                action: function(dialog) {
	                    dialog.close();
	                }
	            }]
	        });
		}
		else{
			 BootstrapDialog.confirm('确认删除此客户?', function(result){
	             if(result) {
	              $.post("area/delete",{areano:areaNo},function(result){
	               if(result.status=="OK"){
	                reloadAreaList(); 
	      }
	      BootstrapDialog.show({
	                title: '客户操作信息',
	                message:result.message,
	                buttons: [{
	                    label: '确定',
	                    action: function(dialog) {
	                        dialog.close();
	                    }
	                }]
	            });
	              });
	             }
	   });


				
		}
	});
	//===============================小区详细处理===============================================================
	$("a#EmployeeViewLink").off().on("click",function(){
		if(areaNo==0){
			BootstrapDialog.show({
	            title: '小区操作信息',
	            message:"请选择要查看的小区",
	            buttons: [{
	                label: '确定',
	                action: function(dialog) {
	                    dialog.close();
	                }
	            }]
	        });
		}
		else{
			$("div#EmployeeDialog").load("area/view.html",function(){
				
				//取得指定的员工信息
				$.getJSON(host+"/area/get",{areano:areaNo},function(em){
					if(em){
						$("span#areaNo").html(areaNo);
						$("span#areaName").html(em.areaname);
						$("span#aaddress").html(em.aaddress);
						$("span#developer").html(em.developer);
						$("span#totalBuidingArea").html(em.totalbuidingarea);
						$("span#totalUsearea").html(em.totalusearea);
						$("span#totalPackarea").html(em.totalpackarea);
						$("span#totalHome").html(em.totalhome);
						$("span#totalHouse").html(em.totalhouse);
						$("span#totalPack").html(em.totalpack);
						
					}
				});
				
				$("div#EmployeeDialog").dialog({
					title:"小区详情",
					width:800
				});

				//点击取消按钮，管理弹出窗口
				$("input[value='关闭']").off().on("click",function(){
					$("div#EmployeeDialog").dialog("close");
					$("div#EmployeeDialog").dialog("destroy")
					$("div#EmployeeDialog").html("");
				});
				
				
			});
		}
	});
	
	
	
	
	
});