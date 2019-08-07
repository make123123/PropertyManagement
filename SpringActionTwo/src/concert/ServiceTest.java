package concert;

import org.springframework.stereotype.Service;

@Service
public class ServiceTest {
	
	

	public void service2(Integer param1, String param2) {
		System.out.println("I am services 2 and I have param:"+param1+"     "+param2);
	}
	public void service3(Integer param1) {
		System.out.println("I am services 3" + param1);
	}
	public void service4() {
		System.out.println("I am services 1");
	}
}
