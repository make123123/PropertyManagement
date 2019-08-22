$(function(){
	var cardnpo="";
	var grantno="";
	var carno="";
	var cardtype="";
	//设置系统页面标题
	$("span#mainpagetille").html("车辆出入证管理");
	
	//显示列表
	getListInfo();
//分页显示总列表*******************************************************************
	function getListInfo(){
		$("table#Grid").jqGrid({
	        url:host+'customerservice/accesscard/get/list',
	        mtype: "POST",
			styleUI : 'Bootstrap',
	        datatype: "json",
	        colModel: [
	            { label: '证件号码', name: 'cardno', key: true, width: 10 },
	            { label: '车牌号', name: 'carno', width: 10 },
	            { label: '车主名字', name: 'customerno', width: 10 },
	            { label: '车型', name: 'vechicletype', width: 10 },
	            { label: '发放人ID', name: 'grantno', width: 10 },
	            { label: '发放时间', name: 'granttime', width: 10 },
	            { label: '证件类型', name: 'cardtype', width: 10 },
	            { label: '过期时间', name: 'overduetime', width: 10 }
	        ],
	        caption:"出入证列表",     //设置表格标题
	        autowidth: true,       //自动宽度
			viewrecords: true,     //记录总数
	        height:500,           //高度
	        rowNum: 10,            //每页显示多少记录
	        jsonReader: {         //json解析器
			      root: "list",    //列表的属性
			      page: "page",    //页号的属性
			      total: "pageCount", //页数的属性
			      records: "count",   //记录个数属性
			      repeatitems: true,  //循环记录
			      id: "cardno"},       //主键
        	pager: "#GridPager",  //控件栏
	        multiselect:false,   //false只允许选中一条记录(默认) true能选中多条记录
	        onSelectRow:function(cardno){//选中行赋值
	        	cardnpo=cardno;
	        }
	    });
	}
//设置检索参数，更新jQGrid的列表显示，增加新出入证***********************************************************************************************增
	function reloadAccesscardList()
	{
		$("table#Grid").jqGrid('setGridParam',{postData:{grantno:grantno,cardtype:cardtype,carno:carno}}).trigger("reloadGrid");
	}
	//点击增加按钮弹出增加员工对话框
	$("a#AddLink").off().on("click",function(event){
		$("div#DialogArea").load("customerservice/accesscard/add.html",function(){
			$("div#DialogArea").dialog({
				title:"添加车辆出入证",
				width:300
			});
			//验证员工提交数据
			$("form#AddForm").validate({
				rules:{
					cardno:{
						required:true,
						remote:host+"customerservice/accesscard/checkidexist"
					},
					carno:{
						required:true
					},
					customerno:{
						required:true
					},
					cardtype:{
						required:true
					},
					grantno:{
						required:true
					},
					vechicletype:{
						required:true
					},
					granttime:{
						required:true,
						date:true
					},
					
					overduetime:{
						required:true,
						date:true
					}
				},
			messages:{
						cardno:{
							required:"证件号码不能为空！",
							remote: "输入非法，工号已存在"  
						},
						carno:{
							required:"车牌号码不能为空!"
						},
						customerno:{
							required:"申请人ID不能为空!"
						},
						vechicletype:{
							required:"车辆型号不能为空！"
						},
						grantno:{
							required:"发放人ID不能为空！"
						},
						cardtype:{
							required:"证件类型不能为空！"
						},
						granttime:{
							required:"发放日期不能为空！",
							date:'输入非法，请输入日期类型"年-月-日"'
						},
						
						overduetime:{
							required:"失效日期不能为空！",
							date:'输入非法，请输入日期类型"年-月-日"'
						}
			  }
			});
			//添加出入证保单
			$("form#AddForm").ajaxForm(function(result){
				if(result.status=="Accpet"){
					reloadAccesscardList();
				}
				//修改默认的alert对话框
				BootstrapDialog.show({
		            title: '出入证操作信息',
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
//下方按类型查找模块功能***********************************************************************************查
	
	$("select#cardtype").off().on("change",function(){
		cardtype=$("select#cardtype").val();
	});
	//点击查找事件处理
	$("a#AccesscardSearchButton").on("click",function(){
		grantno=$("input#grantno").val();
		carno=$("input#carno").val();
		if(grantno==null) grantno='';
		if(carno==null)carno='';
		reloadAccesscardList();
	});
//根据选中栏按cardno删除资料******************************************************************************************************************************************************删
	$("a#DeleteLink").off().on("click",function(){
		if(cardnpo!=''&&cardnpo!=null){
			BootstrapDialog.show({
	            title: '删除车辆出入证',
	            message:"删除？",
	            buttons: [
	            	{
		                label: '是',
		                action: function(dialog) {
		                	 $.post(host+"customerservice/accesscard/delete",{cardno:cardnpo},function(result){
		                		 if(result.status=="Accept"){
		                			 BootstrapDialog.show({
			                			 title: '删除车辆出入证',
			             	            message:result.message,
				             	        buttons:[
				           					{
				           						label:"确定",
				           						action:function(dialog){
				           							dialog.close();
				           						}
				           					}
			           					]
			                		 });
		                			 reloadAccesscardList();
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
		else
			{
			BootstrapDialog.show({
				title:"信息",
				message:"请选择要删除的证件。",
				buttons:[
					{
						label:"确定",
						action:function(dialog){
							dialog.close();
						}
					}
				]
			})
			}
	});
//修改出入证信息**********************************************************************改
	$("a#ModifyLink").off().on("click",function(){
		if(cardnpo!=''&&cardnpo!=null){
			$("div#DialogArea").load("customerservice/accesscard/modify.html",function(){
				//先查看该出入证的信息
				$.getJSON(host+"customerservice/accesscard/get",{cardno:cardnpo},function(as){
					$("input#cardnoInput").val(as.cardno);
					$("input#carnoInput").val(as.carno);
					$("input#customernoInput").val(as.customerno);
					$("select#cardtypeInput").append("<option value='"+as.cardtype+"'>"+as.cardtype+"</option>");
					$("input#grantnoInput").val(as.grantno);
					$("input#vechicletypeInput").val(as.vechicletype);
					$("input#granttimeInput").val(as.granttime);
					$("input#overduetimeInput").val(as.overduetime);
				});
				$("div#DialogArea").dialog({
					title:"修改车辆出入证",
					width:300
				});
				//验证员工提交数据
				$("form#AddForm").validate({
					rules:{
						cardnoInput:{
							required:true
						},
						carnoInput:{
							required:true
						},
						customernoInput:{
							required:true
						},
						cardtypeInput:{
							required:true
						},
						grantnoInput:{
							required:true
						},
						vechicletypeInput:{
							required:true
						},
						granttimeInput:{
							required:true,
							date:true
						},
						
						overduetimeInput:{
							required:true,
							date:true
						}
					},
				messages:{
							cardnoInput:{
								required:"证件号码不能为空！"
							},
							carnoInput:{
								required:"车牌号码不能为空!"
							},
							customernoInput:{
								required:"申请人ID不能为空!"
							},
							vechicletypeInput:{
								required:"车辆型号不能为空！"
							},
							grantnoInput:{
								required:"发放人ID不能为空！"
							},
							cardtypeInput:{
								required:"证件类型不能为空！"
							},
							granttimeInput:{
								required:"发放日期不能为空！",
								date:'输入非法，请输入日期类型"年-月-日"'
							},
							
							overduetimeInput:{
								required:"失效日期不能为空！",
								date:'输入非法，请输入日期类型"年-月-日"'
							}
				  }
				});
				//表单拦截器
				$("form#ModifyForm").ajaxForm(function(result){
					if(result.status=="Accept"){
						reloadAccesscardList();
						
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
	
//详细*******************************************************************	
	$("a#DetailLink").off().on("click",function(){
			$("div#DialogArea").load("customerservice/accesscard/detail.html",function(){
				//先查看该出入证的信息
				$.getJSON(host+"customerservice/accesscard/get",{cardno:cardnpo},function(as){
					$("input#cardnoInput").val(as.cardno);
					$("input#carnoInput").val(as.carno);
					$("input#customernoInput").val(as.customerno);
					$("select#cardtypeInput").append("<option value='"+as.cardtype+"'>"+as.cardtype+"</option>");
					$("input#grantnoInput").val(as.grantno);
					$("input#vechicletypeInput").val(as.vechicletype);
					$("input#granttimeInput").val(as.granttime);
					$("input#overduetimeInput").val(as.overduetime);
				});
				$("div#DialogArea").dialog({
					title:"修改车辆出入证",
					width:300
				});
				//验证员工提交数据
				$("form#AddForm").validate({
					rules:{
						cardnoInput:{
							required:true
						},
						carnoInput:{
							required:true
						},
						customernoInput:{
							required:true
						},
						cardtypeInput:{
							required:true
						},
						grantnoInput:{
							required:true
						},
						vechicletypeInput:{
							required:true
						},
						granttimeInput:{
							required:true,
							date:true
						},
						
						overduetimeInput:{
							required:true,
							date:true
						}
					},
				messages:{
							cardnoInput:{
								required:"证件号码不能为空！"
							},
							carnoInput:{
								required:"车牌号码不能为空!"
							},
							customernoInput:{
								required:"申请人ID不能为空!"
							},
							vechicletypeInput:{
								required:"车辆型号不能为空！"
							},
							grantnoInput:{
								required:"发放人ID不能为空！"
							},
							cardtypeInput:{
								required:"证件类型不能为空！"
							},
							granttimeInput:{
								required:"发放日期不能为空！",
								date:'输入非法，请输入日期类型"年-月-日"'
							},
							
							overduetimeInput:{
								required:"失效日期不能为空！",
								date:'输入非法，请输入日期类型"年-月-日"'
							}
				  }
				});
				//表单拦截器
				$("form#ModifyForm").ajaxForm(function(result){
					if(result.status=="Accept"){
						reloadAccesscardList();
						
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

