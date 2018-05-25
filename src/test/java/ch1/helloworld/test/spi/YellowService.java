package ch1.helloworld.test.spi;

public class YellowService implements DubboService{

	@Override
	public void sayHello() {
		System.out.println("我是YellowService服务实现");
	}

}
