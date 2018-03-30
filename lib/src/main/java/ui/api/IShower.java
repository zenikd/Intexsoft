package ui.api;

import java.util.List;

import dao.entity.Lib;

public interface IShower {
	void show(List<Lib> libs, String command);
}
