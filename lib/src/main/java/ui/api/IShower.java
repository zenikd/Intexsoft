package ui.api;

import java.util.List;

import dao.entity.AbstactLib;
import service.impl.AbstarctLiBService;

public interface IShower {
	void show(List<AbstarctLiBService> libServices, String command);
}
