package spring.aop.cglib;

public class ItemsServiceImpl implements ItemsService {

	@Override
	public void addItems(int i, int b) throws Exception {
		System.out.println("this is a:  addItems"+i+"this is b    "+b);
	}

	@Override
	public void updateItems() throws Exception {
		System.out.println("this is a:  updateItems");
		
	}

	@Override
	public void deleteItems() throws Exception {
		System.out.println("this is a:  deleteItems");
		
	}

}
