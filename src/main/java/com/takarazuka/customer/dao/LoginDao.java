package com.takarazuka.customer.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface LoginDao {
	//ユーザIDからDBに登録されているパスワードを取得
	@Select
	public String selectPassword(String user_id);
}
