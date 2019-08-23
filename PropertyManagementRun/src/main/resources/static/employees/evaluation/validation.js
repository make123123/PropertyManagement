/**
 * 自定义的验证规则
 */
//验证微信
$.validator.addMethod("wx",function(value,element,params){
	var wxPattern = /^[a-zA-Z]([-_a-zA-Z0-9]{5,19})+$/;
	return this.optional(element)||wxPattern.test(value);
},"非法的微信号");
