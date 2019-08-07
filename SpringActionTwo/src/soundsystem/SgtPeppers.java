package soundsystem;

import org.springframework.stereotype.Component;

//实现类
@Component
//可以是用@Name标签,两者区别不会太大,但是建议使用Componet,因为@name不能表明此标签到底式干什么的
public class SgtPeppers implements CompactDisc{
	
	private String title = "Sgt. Peppers Lonely Hearts Club Band";
	private String artist =  "The Beatles";
	
	@Override
	public void play() {
		System.out.println("Playing" + title + " by "+artist);	
	}

}
