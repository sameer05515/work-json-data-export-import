package com.vogella.java.library.gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.p.eximport.main.pojo.Topic;

public class MainTest {

	public static void main(String[] args) {
		method2();
	}

	private static void method1() {
		List<Task> list = new ArrayList<Task>();
		for (int i = 0; i < 20; i++) {
			list.add(new Task(i, "Test1", "Test2", Task.Status.ASSIGNED, 10));
		}
		Gson gson = new Gson();
		Type type = new TypeToken<List<Task>>() {
		}.getType();
		String json = gson.toJson(list, type);
		System.out.println(json);
		List<Task> fromJson = gson.fromJson(json, type);

		for (Task task : fromJson) {
			System.out.println(task);
		}
	}

	private static void method2() {
		List<Topic> list = new ArrayList<Topic>();
		for (int i = 0; i < 2; i++) {
			list.add(new Topic(i, "title" + i, "<h1>Hello world!</h1>" + i));
		}
		Gson gson = new Gson();
		Type type = new TypeToken<List<Topic>>() {
		}.getType();
		String json = gson.toJson(list, type);
		System.out.println(json);

		System.out.println(
				"#######################################################################################################");

		List<Topic> fromJson = gson.fromJson(json, type);

		for (Topic task : fromJson) {
			System.out.println(task);
		}
	}
}