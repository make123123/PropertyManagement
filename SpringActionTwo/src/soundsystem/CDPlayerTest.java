package soundsystem;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)//此标签用于spring自动创建上下文
@ContextConfiguration(classes=CDPlayerConfig.class)//告诉spring要加载此配置类
public class CDPlayerTest {
	
	@Autowired
	private CompactDisc cd;
	
	@Autowired
	private MediaPlayer mp;
	
	@Test
	public void cdShouldNotBeNull() {
		//assertNotNull(cd);  //用来测试此类是否为空
		mp.play();
	}
}
