package com.takarazuka.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.takarazuka.customer.dao.LoginDao;

@Service
public class LoginService {
	@Autowired
	LoginDao loginDao;

	@Autowired
	MessageSource
	messageSource;

	//ユーザIDからDBに登録されているパスワードを取得
	public String selectPassword(String user_id){
		return loginDao.selectPassword(user_id);
	}

	//正しいハスワードか認証
	public boolean loginAuthentication(String inputUserId,String inputPassword) {
		//渡されたユーザーIDから正しいパスワードを取得
		String correctPassword = selectPassword(inputUserId);
		//正しいパスワードと入力されたパスうワードを比較
		if(correctPassword.equals(inputPassword)) {
			return true;
		}else {
			return false;
		}
	}
}
