package com.imac.enumpackage;

/**
 * Created by ab054857 on 2017/9/1.
 */
@Access(level = CommonIdentifer.Author)
public class Foo {

	public static void main(String[] args) {
		Foo foo = new Foo();
		//获取注解
		Access access = foo.getClass().getAnnotation(Access.class);

		//没有注解或鉴权失败
		if (access == null || !access.level().identifer()) {
			System.out.println(access.level().result_word);
		}
	}
}
