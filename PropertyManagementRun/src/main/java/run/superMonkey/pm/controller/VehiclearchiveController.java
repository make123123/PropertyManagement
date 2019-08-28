package run.superMonkey.pm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import run.superMonkey.pm.model.entity.VehiclearchiveEntity;
import run.superMonkey.pm.service.VehiclearchiveService;
import run.superMonkey.pm.utils.ResultMessage;

@RestController
@RequestMapping("/customerservice/vehiclearchive")
public class VehiclearchiveController {
	@Autowired
	VehiclearchiveService vs=null;
	
	@RequestMapping("/add")
	public ResultMessage<VehiclearchiveEntity> add(
			@RequestParam(required=false)String carno,//RequestParam 设置各值不能为空
			@RequestParam(required = false)double customerno,
			@RequestParam(required = false)String vechicletype,
			@RequestParam(required = false)String parkinglot,
			@RequestParam(required = false)String state)throws Exception{
			VehiclearchiveEntity vehiclearchiveEntity=new VehiclearchiveEntity();
			vehiclearchiveEntity.setCarno(carno);
			vehiclearchiveEntity.setCustomerno(customerno);
			vehiclearchiveEntity.setVechicletype(vechicletype);
			vehiclearchiveEntity.setParkinglot(parkinglot);
			vehiclearchiveEntity.setState(state);
			vs.register(vehiclearchiveEntity);
		return new ResultMessage<VehiclearchiveEntity>("Accpet","增加车辆档案成功！");
	}
	
	@RequestMapping("/delete")
	public ResultMessage<VehiclearchiveEntity> delete(
			@RequestParam(required=false)String carno)throws Exception{
			VehiclearchiveEntity vehiclearchiveEntity=vs.getbyNo(carno);
			vs.delete(vehiclearchiveEntity);
			return new ResultMessage<VehiclearchiveEntity>("Accept","删除车辆档案成功！");
			
	}
	
	@RequestMapping("/modify")
	public ResultMessage<VehiclearchiveEntity> modify(
			@RequestParam(required=false)String carno,
			@RequestParam(required = false)double customerno,
			@RequestParam(required = false)String vechicletype,
			@RequestParam(required = false)String parkinglot,
			@RequestParam(required = false)String state)throws Exception{
			VehiclearchiveEntity vehiclearchiveEntity=vs.getbyNo(carno);
			vehiclearchiveEntity.setCustomerno(customerno);
			vehiclearchiveEntity.setParkinglot(parkinglot);
			vehiclearchiveEntity.setState(state);
			vehiclearchiveEntity.setVechicletype(vechicletype);
			vs.modify(vehiclearchiveEntity);
		return new ResultMessage<VehiclearchiveEntity>("Accept","修改车辆档案成功！");
	}
	
	@RequestMapping("/listall")
	public List<VehiclearchiveEntity> getListByAll()throws Exception{
		return vs.getListByAll();
	}
	
	@RequestMapping("/listpage")
	public ResultMessage<VehiclearchiveEntity> getListByPage(
			@RequestParam(required = false,defaultValue ="")String carno,
			@RequestParam(required = false,defaultValue = "0")String customerno,
			@RequestParam(required = false,defaultValue = "")String state,
			@RequestParam(required = false,defaultValue = "1")int page,
			@RequestParam(required = false,defaultValue = "10")int rows
			)throws Exception{
		ResultMessage<VehiclearchiveEntity> result=new ResultMessage<VehiclearchiveEntity>("Accept","取得车辆出入证列表分页成功");
		double Coustomerno=Double.parseDouble(customerno);
		result.setCount(vs.getCountByCondition(carno,Coustomerno,state));
	    result.setPageCount(vs.getPageCountByCondition(carno,Coustomerno,state,rows));
		result.setList(vs.getListByPage(carno,Coustomerno,state,page,rows));
		result.setPage(page);
		result.setRows(rows);
		return result;
	}
	
	@RequestMapping("/getno")
	public VehiclearchiveEntity getByNo(
			@RequestParam(required = false,defaultValue = "")String carno)throws Exception{
		return vs.getbyNo(carno);
	}
	
	@RequestMapping("/checknoexist")
	public boolean checkNoExist(
			@RequestParam(required = false,defaultValue = "")String carno)throws Exception{
		boolean res=false;
		if(vs.getbyNo(carno)!=null)res=true;
		return res;
	}
}
