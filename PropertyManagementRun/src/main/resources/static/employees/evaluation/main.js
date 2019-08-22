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
	//定义工号的更新事件的处理
	$("input#EmpidSelection").off().on("change",function(){
		empid=$("input#EmpidSelection").val();
		reloadList();
	});
	
	//定义等级下拉框的更新事件的处理
	$("select#EvaluationGradeSelection").off().on("change",function(){
		evaluationgrade=$("select#EvaluationGradeSelection").val();
		reloadList();
	});

	//定义考评日期的更新事件的处理
	$("input#EvaluationDate").off().on("change",function(){
		evaluationdate=$("input#EvaluationDate").val();
		reloadList();
	});
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
//点击增加按钮弹出增加员工考评对话框++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	$("a#AddLink").off().on("click",function(event){
		$("div#DialogArea").load("employees/evaluation/add.html",function(){
			$("div#DialogArea").dialog({
				title:"增加员工考评记录",
				width:600
			});
			$.getJSON(host+"employees/emp/get/listall",function(result){
				if(result){
					$.each(result.list,function(index,dm){
						$("select#EmpnameSelection").append("<option value='"+dm.empid+"'>"+dm.empname+"</option>");
					});
				}
			});
			//验证员工提交数据
			$("form#AddForm").validate({
				rules:{
					evaluationno:{
						required:true,
						number:true,
						min:1,
						remote:host+"employees/evaluation/checkidexist"
					},
					empname:{
						required:true
					},
					grade:{
						required:true
					},
					evaluationdate:{
						required:true,
						date:true
					}
				},
			messages:{
				evaluationno:{
							required:"考评编号不能为空，请输入考评编号",
							number:"输入非法，请输入数字",
							min:"不能为0和负数",
							remote: "输入非法，考评编号已存在"  
						},
						empname:{
							required:"员工姓名不能为空，请选择员工姓名"
						},
						grade:{
							required:"等级不能为空，请选择等级"
						},
						evaluationdate:{
							required:"考评日期不能为空，请输入考评日期",
							date:"输入非法，请输入日期类型yyyy-MM-dd"
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
		            title: '员工考评操作信息',
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
//点击删除按钮，删除员工考评信息-------------------------------------------------------------------------------------------------------------------
	$("a#DeleteLink").off().on("click",function(){
		if(no==null){
			BootstrapDialog.show({
	            title: '删除员工考评记录',
	            message:"请选择要删除的员工考评记录",
	            buttons: [{
	                label: '确定',
	                action: function(dialog) {
	                    dialog.close();
	                }
	            }]
	        });
		}else{
			BootstrapDialog.show({
	            title: '删除员工考评记录',
	            message:"是否删除",
	            buttons: [
	            	{
		                label: '是',
		                action: function(dialog) {
		                	 $.post(host+"employees/evaluation/delete",{evaluationno:no},function(result){
		                		 if(result.status=="OK"){
		                			 BootstrapDialog.show({
			                			 title: '删除员工考评记录',
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
//点击修改按钮，修改员工信息**********************************************************************************************
	$("a#ModifyLink").off().on("click",function(){
		if(no==null){
			BootstrapDialog.show({
	            title: '修改员工考评记录',
	            message:"请选择要修改的员工考评记录",
	            buttons: [{
	                label: '确定',
	                action: function(dialog) {
	                    dialog.close();
	                }
	            }]
	        });
		}else{
			$("div#DialogArea").load("employees/evaluation/modify.html",function(){
				//取得指定的员工信息
				$.getJSON(host+"employees/evaluation/get",{evaluationno:no},function(em){
							$("input#evaluationno").val(em.evaluationno);
							$("select#grade").val(em.evaluationgrade);
					        $("select#EmpnameSelection").val(em.ee.empname);  //呼叫海王滴滴滴滴滴滴滴滴滴滴滴滴滴滴滴滴滴滴滴滴
							//$("select#EmpnameSelection option[value='"+em.ee.empname+"']").attr("selected","selected");
							//$("#param").find("option[value="+param+"]").attr('selected','selected');
							$("input#evaluationdate").val(em.evaluationdate);
	           });
				$("div#DialogArea").dialog({
					title:"修改员工考评记录",
					width:600
				});
				//验证员工提交数据
				$("form#ModifyForm").validate({
					rules:{
						empname:{
							required:true
						},
						grade:{
							required:true
						},
						evaluationdate:{
							required:true,
							date:true
						}
					},
				messages:{
							empname:{
								required:"员工姓名不能为空，请选择员工姓名"
							},
							grade:{
								required:"等级不能为空，请选择等级"
							},
							evaluationdate:{
								required:"考评日期不能为空，请输入考评日期",
								date:"输入非法，请输入日期类型yyyy-MM-dd"
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
		    }
	           });
//查询员工信息..................................................................................
	$("a#ViewLink").off().on("click",function(){
		if(no==null){
			BootstrapDialog.show({
	            title: '查看员工考评记录信息',
	            message:"请选择要查看的员工考评记录",
	            buttons: [{
	                label: '确定',
	                action: function(dialog) {
	                    dialog.close();
	                }
	            }]
	        });
		}else{
			$("div#DialogArea").load("employees/evaluation/view.html",function(){
				//取得指定的员工信息
				$.getJSON(host+"employees/evaluation/get",{evaluationno:no},function(em){
					$("input#evaluationno").val(em.evaluationno);
					$("select#grade").val(em.evaluationgrade);
					$("input#EmpnameSelection").val(em.ee.empname);
					$("input#evaluationdate").val(em.evaluationdate);
	           });
				$("div#DialogArea").dialog({
					title:"查看员工考评记录",
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