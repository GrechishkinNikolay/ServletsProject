package ru.rsreu.Grechishkin;

import java.util.ResourceBundle;

public class Resourcer {
	private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources");
	private Resourcer() { }
	public static String getProperty(String key) {
		return resourceBundle.getString(key);
	}
}