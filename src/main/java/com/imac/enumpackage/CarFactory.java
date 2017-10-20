package com.imac.enumpackage;

/**
 * Created by ab054857 on 2017/9/1.
 */
public enum CarFactory {
	FordCar, BuickCar;

	public Car createCar() {
		switch (this){
			case FordCar:
				return new FordCar();
			case BuickCar:
				return new BuickCar();
			default:
				throw new AssertionError("参数无效");
		}
	}

	private CarFactory() {
		System.out.println("I am cus");
	}

	public static void main(String[] args) {
		//有几个枚举类型，就会执行几次构造函数
		System.out.println(CarFactory.FordCar);
//		Car car = CarFactory.FordCar.createCar();
	}
}
