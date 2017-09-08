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

	public static void main(String[] args) {
		Car car = CarFactory.FordCar.createCar();
	}
}
