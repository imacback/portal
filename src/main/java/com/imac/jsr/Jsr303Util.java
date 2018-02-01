package com.imac.jsr;

import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotEmpty;
import java.util.Iterator;
import java.util.Set;

/**
 * JSR303的校验帮助类
 */
public class Jsr303Util {
	/**
	 * 如果返回null则表示没有错误
	 * @param obj
	 * @return
	 */
	public static String check(Object obj) {
		if (null == obj) {
			return "入参vo不能为空";
		}
		//验证其中一项出项返回 failFast
		Validator validator = Validation.byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory().getValidator();
		//验证所有
//		Set<ConstraintViolation<Object>> validResult = Validation.buildDefaultValidatorFactory().getValidator().validate(obj);
		Set<ConstraintViolation<Object>> validResult = validator.validate(obj);
		if (null != validResult && validResult.size() > 0) {
			StringBuilder sb = new StringBuilder();
			for (Iterator<ConstraintViolation<Object>> iterator = validResult.iterator(); iterator.hasNext();) {
				ConstraintViolation<Object> constraintViolation = iterator.next();
				if(StringUtils.isNotBlank(constraintViolation.getMessage())) {
					sb.append(constraintViolation.getMessage()).append("、");
				} else {
					sb.append(constraintViolation.getPropertyPath().toString()).append("不合法、");
				}
			}
			if (sb.lastIndexOf("、") == sb.length() - 1) {
				sb.delete(sb.length() - 1, sb.length());
			}
			return sb.toString();
		}
		return null;
	}

	public static void main(String[] args) {
		User user = new User();
		user.setUserName("");

		System.out.println(check(user));
	}

	static class User {
		@NotEmpty(message = "用户名不能为空")
		private String userName;

		@NotEmpty(message = "密码不能为空")
		private String password;

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	}

}
