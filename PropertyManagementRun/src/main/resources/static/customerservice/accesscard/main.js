/*
 * 员工管理JS
 * 作者：赖伟森
 */
$(function(){
	var cardno="";
	var grantno="";
	var carno="";
	var cardtype="";
	//设置系统页面标题
	$("span#mainpagetille").html("车辆出入证管理");
	
	//显示列表
	getListInfo();
	//显示列表函数
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
	        rowList:[10,20,30],    //每页显示多少记录（可选记录）
	        jsonReader: {         //json解析器
			      root: "list",    //列表的属性
			      page: "page",    //页号的属性
			      total: "pageCount", //页数的属性
			      records: "count",   //记录个数属性
			      repeatitems: true,  //循环记录
			      id: "cardno"},       //主键
        	pager: "#GridPager",  //控件栏
	        multiselect:false,   //false只允许选中一条记录(默认) true能选中多条记录
	        onSelectRow:function(cardno){
	        	cardno=cardno;
	        }
	    });
	}
	//设置检索参数，更新jQGrid的列表显示
	function reloadEmployeeList()
	{
		$("table#Grid").jqGrid('setGridParam',{postData:{grantno:grantno,cardtype:cardtype,carno:carno}}).trigger("reloadGrid");
	}
	//点击增加按钮弹出增加员工对话框
	$("a#AddLink").off().on("click",function(event){
		$("div#DialogArea").load("customerservice/accesscard/add.html",function(){
			$("div#DialogArea").dialog({
				title:"添加车辆出入证",
				width:600
			});
			//验证员工提交数据
			$("form#AddForm").validate({
				rules:{
					cardno:{
						required:true
						//remote:host+"employees/emp/checkidexist"
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
					granttime:{
						required:true,
						date:true
					},
					vechicletype:{
						required:true
					},
					overduetime:{
						required:true,
						date:true
					}
				},
			messages:{
						cardno:{
							required:"证件号码不能为空！"
							//remote: "输入非法，工号已存在"  
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
						granttime:{
							required:"发放日期不能为空！",
							date:'输入非法，请输入日期类型"年-月-日"'
						},
						cardtype:{
							required:"证件类型不能为空！"
						},
						overduetime:{
							required:"失效日期不能为空！",
							date:'输入非法，请输入日期类型"年-月-日"'
						}
			  }
			});
			//添加出入证保单
			$("form#AddForm").ajaxForm(function(result){
				/*if(result.status=="OK"){
					reloadEmployeeList();
				}*/
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
	//定义证件类型单选按钮更改事件
	$("select#cardtype").off().on("change",function(){
		cardtype=$("select#cardtype").val();
		//reloadEmployeeList();
	});
	//点击查找事件处理
	$("a#AccesscardSearchButton").on("click",function(){
		grantno=$("input#grantno").val();
		carno=$("input#carno").val();
		if(grantno==null) grantno='';
		if(carno==null)carno='';
		reloadEmployeeList();
	});
	
	
});