package com.takarazuka.customer.domain;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;

import lombok.Data;

@Entity
@Data
public class Login {
	//パスワード
	@Column(name="password")
	private String password;
}
