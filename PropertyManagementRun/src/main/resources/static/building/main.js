/**
 * 员工前端主管理JS
 * 模块：HR
 * 业务对象：员工
 * 作者:吕海东
 * 
 */
$(function(){
	var buildingNo=0;
	var bcode=null;
	var baddress=null;
	var direction=null;
	var totalhome=0;
	var totalhouse=0;
	var areano=0;
	var buildingTypeno=0;
	//设置系统页面标题
	$("span#mainpagetille").html("楼宇管理");
	//设置日期的格式和选择
	
	//显示小区信息列表
	$("table#EmployeeGrid").jqGrid({
		url: host+'building/list/condition/page',
		datatype: "json",
		colModel: [
			{ label: '楼宇序号', name: 'buildingno', width: 75 },
			{ label: '楼号', name: 'bcode', width: 90 },
			{ label: '楼宇地址', name: 'baddress', width: 100 },
			{ label: '楼宇朝向', name: 'direction', width: 40 },
			{ label: '居民数', name: 'totalhome', width: 50},
			{ label: '公建数', name: 'totalhouse', width: 70 },
		],
		caption:"楼宇信息列表",
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
		      id: "buildingno"},
		pager: "#EmployeeGridPager",
		multiselect:false,
		onSelectRow:function(no){
			buildingNo=no;
		}
		
	});
	
	//取得小区名列表，填充小区名下拉框
	$.getJSON(host+"area/get/list",function(departmentList){
		if(departmentList){
			$.each(departmentList,function(index,dm){
				$("select#ArSelection").append("<option value='"+dm.areano+"'>"+dm.areano+"</option>");
			});
		}
	});
	//取得楼宇类型地址列表，填充小区地址下拉框
	$.getJSON(host+"buildingtype/get/list",function(roleList){
		
		if(roleList){
			$.each(roleList,function(index,rm){
				$("select#ArSelection1").append("<option value='"+rm.typeno+"'>"+rm.typeno+"</option>");
			});
		}
	});
	
//	设置检索参数，更新jQGrid的列表显示
	function reloadBuildingList()
	{
		$("table#EmployeeGrid").jqGrid('setGridParam',{postData:{areaNo:areano,buildingtypeNo:buildingTypeno}}).trigger("reloadGrid");
		//对于控制层显示列表的条件
	}
	//点击检索事件处理
	$("a#EmployeeSearchButton").on("click",function(){
		areano=$("select#ArSelection").val();
		buildingTypeno=$("select#ArSelection1").val();
		reloadBuildingList();

	});
	//===========================增加小区信息处理================================================
	$("a#EmployeeAddLink").off().on("click",function(){
		$("div#EmployeeDialog").load("building/add.html",function(){
			//取得小区列表
			$.getJSON(host+"area/get/list",function(departmentList){
				if(departmentList){
					$.each(departmentList,function(index,dm){
						$("select[name='area.areano']").append("<option value='"+dm.areano+"'>"+dm.areano+"</option>");
					});
				}
			});
			//取得建筑类型列表
			$.getJSON(host+"buildingtype/get/list",function(departmentList){
				if(departmentList){
					$.each(departmentList,function(index,dm){
						$("select[name='buildingType.typeno']").append("<option value='"+dm.typeno+"'>"+dm.typeno+"</option>");
					});
				}
			});
			
			
			
			
			//验证员工提交数据
			$("form#EmployeeAddForm").validate({
				  rules: {
					buildingno: {
				      required: true,
				      remote: host+"building/checkbuildingnoexist"
				      
				    },
				    bcode:{
				    	required: true
				    },
				    baddress:{
				    	required: true
				    },
				    direction:{
				    	required:true,
				    }
				  },
				  messages:{
					buildingno: {
					     required: "楼宇编号为空",
					     remote:"楼宇编号已经存在"
					    },
					bcode:{
					     required:"楼号为空"
					},
					baddress:{
						 required:"楼宇地址为空"
					},
					direction:{
				    	required:"楼宇朝向开发商为空",
				    }
				 }
			});
			//拦截增加提交表单
			$("form#EmployeeAddForm").ajaxForm(function(result){
				if(result.status=="OK"){
					reloadBuildingList();//更新员工列表
				}
				//alert(result.message);
				//BootstrapDialog.alert(result.message);
				BootstrapDialog.show({
		            title: '楼宇操作信息',
		            message:result.message
		        });
				$("div#EmployeeDialog").dialog( "close" );
				$("div#EmployeeDialog").dialog( "destroy" );
				$("div#EmployeeDialog").html("");
				
			});
			
			$("div#EmployeeDialog").dialog({
				title:"楼宇增加",
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
		if(buildingNo==0){
			BootstrapDialog.show({
	            title: '楼宇操作信息',
	            message:"请选择要修改的楼宇",
	            buttons: [{
	                label: '确定',
	                action: function(dialog) {
	                    dialog.close();
	                }
	            }]
	        });
		}
		else{
			$("div#EmployeeDialog").load("building/modify.html",function(){
				
				//取得小区列表
				$.getJSON(host+"area/get/list",function(departmentList){
					if(departmentList){
						$.each(departmentList,function(index,dm){
							$("select[name='area.areano']").append("<option value='"+dm.areano+"'>"+dm.areano+"</option>");
						});
					}
				});
				//取得建筑类型列表
				$.getJSON(host+"buildingtype/get/list",function(departmentList){
					if(departmentList){
						$.each(departmentList,function(index,dm){
							$("select[name='buildingType.typeno']").append("<option value='"+dm.typeno+"'>"+dm.typeno+"</option>");
						});
					}
				});
				//取得指定的员工信息
				$.getJSON(host+"/building/get",{buildingno:buildingNo},function(am){
					
					if(am){
						$("input[name='buildingno']").val(am.buildingno);
						$("input[name='bcode']").val(am.bcode);
						$("input[name='baddress']").val(am.baddress);
						$("input[name='direction']").val(am.direction);
						$("input[name='totalhome']").val(am.totalhome);
						$("input[name='totalhouse']").val(am.totalhouse);
						$("select[name='area.areano']").val(am.areano);
						$("select[name='buildingType.typeno']").val(am.buildingTypeno);
					}
				});
				
				//拦截增加提交表单
				$("form#BuildingEmployeeModifyForm").ajaxForm(function(result){
					if(result.status=="OK"){
						reloadBuildingList();//更新员工列表
					}
					//alert(result.message);
					//BootstrapDialog.alert(result.message);
					BootstrapDialog.show({
			            title: '楼宇操作信息',
			            message:result.message
			        });
					$("div#EmployeeDialog").dialog( "close" );
					$("div#EmployeeDialog").dialog( "destroy" );
					$("div#EmployeeDialog").html("");
					
				});
			
				
				$("div#EmployeeDialog").dialog({
					title:"楼宇修改",
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
		if(buildingNo==0){
			BootstrapDialog.show({
	            title: '楼宇操作信息',
	            message:"请选择要删除的楼宇",
	            buttons: [{
	                label: '确定',
	                action: function(dialog) {
	                    dialog.close();
	                }
	            }]
	        });
		}
		else{
			 BootstrapDialog.confirm('确认删除此楼宇?', function(result){
	             if(result) {
	              $.post("building/delete",{buildingno:buildingNo},function(result){
	               if(result.status=="OK"){
	                reloadBuildingList(); 
	      }
	      BootstrapDialog.show({
	                title: '楼宇操作信息',
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
		if(buildingNo==0){
			BootstrapDialog.show({
	            title: '楼宇操作信息',
	            message:"请选择要查看的楼宇",
	            buttons: [{
	                label: '确定',
	                action: function(dialog) {
	                    dialog.close();
	                }
	            }]
	        });
		}
		else{
			$("div#EmployeeDialog").load("building/view.html",function(){
				
				//取得指定的员工信息
				$.getJSON(host+"/building/get",{buildingno:buildingNo},function(am){
					if(am){
						$("span#buildingNo").html(am.buildingno);
						$("span#bcode").html(am.bcode);
						$("span#baddress").html(am.baddress);
						$("span#direction").html(am.direction);
						$("span#totalhome").html(am.totalhome);
						$("span#totalhouse").html(am.totalhouse);
						$("span#areano").html(am.areano);
						$("span#buildingNo").html(am.buildingTypeno);
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