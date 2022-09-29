package Demo_bean_config;

import com.example.demo.beans.User;

public class UserDaoMySql implements UserDaoInterFace {

	@Override
	public void insert(User u) {
		System.out.println("Them mysql");
		
	}

	@Override
	public void update(User u) {
		System.out.println("Cap nhat mysql");		
	}

	@Override
	public void delete(User u) {
		System.out.println("Xoa mysql");		
	}

	@Override
	public void all() {
		System.out.println("all mysql");		
	}

}
