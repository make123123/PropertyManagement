package run.superMonkey.pm.service;

import java.util.List;


import run.superMonkey.pm.model.entity.Room;

public interface IRoomService {
	public List<Room> getListByAllWithoutPage() throws Exception;
}
