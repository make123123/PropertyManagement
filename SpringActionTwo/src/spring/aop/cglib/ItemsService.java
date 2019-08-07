package spring.aop.cglib;

/**
 * 目标类
 * @author Administrator
 *
 */
public interface ItemsService {
	
	public void addItems(int i, int b)throws Exception;
	public void updateItems()throws Exception;
	public void deleteItems()throws Exception;
}
