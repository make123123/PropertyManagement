package run.superMonkey.pm.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import run.superMonkey.pm.model.entity.AccesscardEntity;
import run.superMonkey.pm.service.AccesscardService;
import run.superMonkey.pm.utils.ResultMessage;

/*客户服务：出入证的增删查改*/

@RequestMapping("/customerservice/accesscard")
public class AccesscardController {
		@Autowired
		private AccesscardService as=null;
		
		@RequestMapping("/add")
		public ResultMessage<AccesscardEntity> add(
				@RequestParam(required=false)String cardno,//RequestParam 设置各值不能为空
				@RequestParam(required = false)String carno,
				@RequestParam(required = false)double customerno,
				@RequestParam(required = false)String vechicletype,
				@RequestParam(required = false)String grantno,
				@DateTimeFormat(pattern = "YYYY-MM-DD") @RequestParam(required = false)Date granttime,
				@RequestParam(required = false)String cardtype,
				@DateTimeFormat(pattern = "YYYY-MM-DD") @RequestParam(required = false)Date overduetime)throws Exception{
				AccesscardEntity accesscardEntity=new AccesscardEntity();
				accesscardEntity.setCardno(cardno);
				accesscardEntity.setCardtype(cardtype);
				accesscardEntity.setCarno(carno);
				accesscardEntity.setCustomerno(customerno);
				accesscardEntity.setGrantno(grantno);
				accesscardEntity.setGranttime(granttime);
				accesscardEntity.setOverduetime(overduetime);
				accesscardEntity.setVechicletype(vechicletype);
			return new ResultMessage<AccesscardEntity>("Accpet","增加出入证成功！");
		}
		@PostMapping("/get/list")
		public ResultMessage<AccesscardEntity> getListByAll()throws Exception{
			ResultMessage<AccesscardEntity> result=new ResultMessage<AccesscardEntity>("Accept","获取出入证列表成功！");
			result.setList(as.getListByAll());
			return result;
		}
		
		
}
