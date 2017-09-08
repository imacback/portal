package com.imac.enumpackage;

/**
 * Created by ab054857 on 2017/9/1.
 */
public enum CommonIdentifer implements Identifier {
	Admin,Reader,Author;

	@Override
	public boolean identifer() {
		switch (this) {
			case Admin:
				return true;
			case Author:
				return false;
			case Reader:
				return false;
			default:
				throw  new AssertionError("参数错误");
		}
	}
}
