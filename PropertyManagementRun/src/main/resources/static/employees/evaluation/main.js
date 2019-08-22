/*
 * 员工考评登记JS
 * 作者：赖伟森
 */
$(function(){
	var no=null;
	var empid=0;
	var evaluationgrade=null;
	var evaluationdate=null;
	//设置系统页面标题
	$("span#mainpagetille").html("员工考评登记");
	
	//显示列表
	getListInfo();
	//显示列表函数
	function getListInfo(){
		$("table#Grid").jqGrid({
	        url:host+'employees/evaluation/get/list',
	        mtype: "POST",
			styleUI : 'Bootstrap',
	        datatype: "json",
	        colModel: [
	        	{ label: '考评编号', name: 'evaluationno', key: true, width: 10 },
	            { label: '员工姓名', name: 'ee.empname', width: 10 },
	            { label: '等级', name: 'evaluationgrade', width: 10 },
	            { label: '考评日期', name: 'evaluationdate', width: 10 }
	        ],
	        caption:"员工考评列表",     //设置表格标题
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
			      id: "evaluationno"},       //主键
	        pager: "#GridPager",  //控件栏
	        multiselect:false,   //false只允许选中一条记录(默认) true能选中多条记录
	        onSelectRow:function(evaluationno){
	        	no=evaluationno;
	        }
	    });
	}
	//设置检索参数，更新jQGrid的列表显示
	function reloadList()
	{
		$("table#Grid").jqGrid('setGridParam',{postData:{empid:empid,evaluationgrade:evaluationgrade,evaluationdate:evaluationdate}}).trigger("reloadGrid");
		
	}
	
//	//定义部门下拉框的更新事件的处理
//	$("select#DepartmentSelection").off().on("change",function(){
//		deptno=$("select#DepartmentSelection").val();
//		reloadEmployeeList();
//	});
//	//定义性别单选按钮更改事件
//	$("input[name='empsex']").off().on("change",function(){
//		sex=$("input[name='empsex']:checked").val();
//		reloadEmployeeList();
//	});
	//点击检索事件处理
	$("a#SearchButton").on("click",function(){
		empid=$("input#EmpidSelection").val();
		evaluationgrade=$("select#EvaluationGradeSelection").val();
		evaluationdate=$("input#EvaluationDate").val();
		if(evaluationdate==""){
			evaluationdate=null;
		}
		reloadList();
	});
////点击增加按钮弹出增加员工对话框++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	$("a#AddLink").off().on("click",function(event){
//		$("div#DialogArea").load("employees/evaluation/add.html",function(){
//			$("div#DialogArea").dialog({
//				title:"增加人员",
//				width:600
//			});
//			$.getJSON(host+"employees/evaluation/get/list",function(result){
//				if(result){
//					$.each(result.list,function(index,dm){
//						$("select#DeptSelection").append("<option value='"+dm.deptno+"'>"+dm.deptname+"</option>");
//					});
//				}
//			});
//			//验证员工提交数据
//			$("form#AddForm").validate({
//				rules:{
//					empid:{
//						required:true,
//						number:true,
//						min:1,
//						remote:host+"employees/emp/checkidexist"
//					},
//					deptno:{
//						required:true
//					},
//					empname:{
//						required:true
//					},
//					sex:{
//						required:true,
//						maxlength: 1
//					},
//					age:{
//						required:true,
//						number:true,
//						min:18,
//						max:35
//					},
//					joindate:{
//						required:true,
//						date:true
//					},
//					job:{
//						required:true
//					},
//					wx:{
//						required:true,
//						wx:true
//					}
//				},
//			messages:{
//						empid:{
//							required:"工号不能为空，请输入工号",
//							number:"输入非法，请输入数字",
//							min:"不能为0和负数",
//							remote: "输入非法，工号已存在"  
//						},
//						deptno:{
//							required:"部门不能为空，请选择部门"
//						},
//						empname:{
//							required:"名字不能为空，请输入名字"
//						},
//						sex:{
//							required:"性别不能为空，请输入性别",
//							maxlength: "输入非法，请输入男或女"
//						},
//						age:{
//							required:"年龄不能为空，请输入年龄",
//							number:"输入非法，请输入数字",
//							min:"年龄最小为18",
//							max:"年龄最大为35"
//						},
//						joindate:{
//							required:"入职日期不能为空，请输入入职日期",
//							date:"输入非法，请输入日期类型yyyy-MM-dd"
//						},
//						job:{
//							required:"职位不能为空，请输入职位"
//						},
//						wx:{
//							required:"微信号不能为空，请输入微信号"
//						}
//			  }
//			});
//			//表单拦截器
//			$("form#AddForm").ajaxForm(function(result){
//				if(result.status=="OK"){
//					reloadEmployeeList();
//				}
//				//修改默认的alert对话框
//				BootstrapDialog.show({
//		            title: '员工操作信息',
//		            message:result.message
//		        });
//				$("div#DialogArea").dialog( "close" );
//				$("div#DialogArea").dialog( "destroy" );
//				$("div#DialogArea").html("");
//			});
//			//点击取消按钮处理
//			$("input[value='取消']").on("click",function(){
//				$("div#DialogArea").dialog( "close" );
//				$("div#DialogArea").dialog( "destroy" );
//				$("div#DialogArea").html("");
//			});
//			
//		});
//	});
////点击删除按钮，删除员工信息-------------------------------------------------------------------------------------------------------------------
//	$("a#DeleteLink").off().on("click",function(){
//		if(employeeId==null){
//			BootstrapDialog.show({
//	            title: '删除员工信息',
//	            message:"请选择要删除的员工",
//	            buttons: [{
//	                label: '确定',
//	                action: function(dialog) {
//	                    dialog.close();
//	                }
//	            }]
//	        });
//		}else{
//			BootstrapDialog.show({
//	            title: '删除员工信息',
//	            message:"是否删除",
//	            buttons: [
//	            	{
//		                label: '是',
//		                action: function(dialog) {
//		                	 $.post(host+"employees/emp/delete",{empid:employeeId},function(result){
//		                		 if(result.status=="OK"){
//		                			 BootstrapDialog.show({
//			                			 title: '删除员工信息',
//			             	            message:result.message
//			                		 });
//				    					reloadEmployeeList();
//				    				}
//		                	 });
//		                	dialog.close();
//		                }
//		            },{
//		            	label: '否',
//		            	action: function(dialog) {
//		            		dialog.close();
//		            	}
//		               }     
//	            ]
//	        });
//		}
//	});
////点击修改按钮，修改员工信息**********************************************************************************************
//	$("a#ModifyLink").off().on("click",function(){
//		if(employeeId==null){
//			BootstrapDialog.show({
//	            title: '修改员工信息',
//	            message:"请选择要修改的员工",
//	            buttons: [{
//	                label: '确定',
//	                action: function(dialog) {
//	                    dialog.close();
//	                }
//	            }]
//	        });
//		}else{
//			$("div#DialogArea").load("employees/emp/modify.html",function(){
//				//取得指定的员工信息
//				$.getJSON(host+"employees/emp/get",{empid:employeeId},function(em){
//							$("input#empid").val(em.empid);
//							$.getJSON(host+"employees/dept/get/list",function(result){
//								if(result){
//									$.each(result.list,function(index,dm){
//										$("select#DeptSelection").append("<option value='"+dm.deptno+"'>"+dm.deptname+"</option>");
//									});
//								}
//							});
//							$("input#empname").val(em.empname);
//							$("input[name='sex'][value="+em.sex+"]").attr("checked",true);
//							$("input#empage").val(em.age);
//							$("input#empjoindate").val(em.joindate);
//							$("select#empjob").val(em.job);
//							$("input#empwx").val(em.wx);
//	           });
//				$("div#DialogArea").dialog({
//					title:"修改人员",
//					width:600
//				});
//				//验证员工提交数据
//				$("form#ModifyForm").validate({
//					rules:{
//						deptno:{
//							required:true
//						},
//						empname:{
//							required:true
//						},
//						sex:{
//							required:true,
//							maxlength: 1
//						},
//						age:{
//							required:true,
//							number:true,
//							min:18,
//							max:35
//						},
//						joindate:{
//							required:true,
//							date:true
//						},
//						job:{
//							required:true
//						},
//						wx:{
//							required:true,
//							wx:true
//						}
//					},
//				messages:{
//							deptno:{
//								required:"部门号不能为空，请输入部门号"								
//							},
//							empname:{
//								required:"名字不能为空，请输入名字"
//							},
//							sex:{
//								required:"性别不能为空，请输入性别",
//								maxlength: "输入非法，请输入男或女"
//							},
//							age:{
//								required:"年龄不能为空，请输入年龄",
//								number:"输入非法，请输入数字",
//								min:"年龄最小为18",
//								max:"年龄最大为35"
//							},
//							joindate:{
//								required:"入职日期不能为空，请输入入职日期",
//								date:"输入非法，请输入日期类型yyyy-MM-dd"
//							},
//							job:{
//								required:"职位不能为空，请输入职位"
//							},
//							wx:{
//								required:"微信号不能为空，请输入微信号"
//							}
//				  }
//				});
//				//表单拦截器
//				$("form#ModifyForm").ajaxForm(function(result){
//					if(result.status=="OK"){
//						reloadEmployeeList();
//					}
//					//修改默认的alert对话框
//					BootstrapDialog.show({
//			            title: '员工操作信息',
//			            message:result.message
//			        });
//					$("div#DialogArea").dialog( "close" );
//					$("div#DialogArea").dialog( "destroy" );
//					$("div#DialogArea").html("");
//				});
//				//点击取消按钮处理
//				$("input[value='取消']").on("click",function(){
//					$("div#DialogArea").dialog( "close" );
//					$("div#DialogArea").dialog( "destroy" );
//					$("div#DialogArea").html("");
//				});
//				
//			});
//		    }
//	           });
////查询员工信息..................................................................................
//	$("a#ViewLink").off().on("click",function(){
//		if(employeeId==null){
//			BootstrapDialog.show({
//	            title: '查看员工信息',
//	            message:"请选择要查看的员工",
//	            buttons: [{
//	                label: '确定',
//	                action: function(dialog) {
//	                    dialog.close();
//	                }
//	            }]
//	        });
//		}else{
//			$("div#DialogArea").load("employees/emp/view.html",function(){
//				//取得指定的员工信息
//				$.getJSON(host+"employees/emp/get",{empid:employeeId},function(em){
//							$("input#empid").val(em.empid);
//							$("input#deptno").val(em.dept.deptname);
//							$("input#empname").val(em.empname);
//							$("input[name='sex'][value="+em.sex+"]").attr("checked",true);
//							$("input#empage").val(em.age);
//							$("input#empjoindate").val(em.joindate);
//							$("select#empjob").val(em.job);
//							$("input#empwx").val(em.wx);
//	           });
//				$("div#DialogArea").dialog({
//					title:"查看人员",
//					width:600
//				});
//				//点击取消按钮，管理弹出窗口
//				$("input[value='关闭']").off().on("click",function(){
//					$("div#DialogArea").dialog( "close" );
//					$("div#DialogArea").dialog( "destroy" );
//					$("div#DialogArea").html("");
//				});
//				
//		});
//	}
//	});
});