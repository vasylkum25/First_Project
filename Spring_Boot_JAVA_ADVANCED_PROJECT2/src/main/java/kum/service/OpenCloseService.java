package kum.service;

import kum.entity.OpenClose;
import java.time.LocalTime;
import java.util.List;

public interface OpenCloseService extends CrudService<OpenClose, Integer> {

	List<LocalTime> findAllTimes();
}
