package com.takarazuka.customer.model;

import lombok.Data;

@Data
public class LoginForm {
	//ユーザーID
	private String user_id;

	//パスワード
	private String password;
}
