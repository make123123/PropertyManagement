package run.superMonkey.pm.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import run.superMonkey.pm.model.entity.AccesscardEntity;
import run.superMonkey.pm.model.entity.EmployessEntity;
import run.superMonkey.pm.service.AccesscardService;
import run.superMonkey.pm.service.impl.AccesscardServiceImpl;
import run.superMonkey.pm.utils.ResultMessage;

/*客户服务：出入证的增删查改*/
@RestController
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
		@RequestMapping("/get/listall")
		public List<AccesscardEntity> getListByAll()throws Exception{
			List<AccesscardEntity> result=as.getListByAll();
			return result;
		}
		//分页查找
		@RequestMapping("/get/list")
		public ResultMessage<AccesscardEntity> getListByPage(
				@RequestParam(required = false,defaultValue ="")String grantno,
				@RequestParam(required = false,defaultValue ="") String cardtype,
				@RequestParam(required = false,defaultValue ="") String carno,
			    @RequestParam(required = false,defaultValue = "1") int page,
			    @RequestParam(required = false,defaultValue ="10") int rows)throws Exception{
			ResultMessage<AccesscardEntity> result=new ResultMessage<AccesscardEntity>("OK","取得车辆出入证列表分页成功");
		    result.setCount(as.getCountByCondition(grantno,cardtype,carno));
		    result.setPageCount(as.getPageCountByCondition(grantno,cardtype, carno, rows));
			System.out.println("-------------------");
			System.out.println(grantno);
			System.out.println(cardtype);
			System.out.println(carno);
			System.out.println(page);
			System.out.println(rows);
			result.setList(as.getListByPage(grantno,cardtype,carno,page,rows));
			result.setPage(page);
			result.setRows(rows);
			return result;
		}
		
		
}
