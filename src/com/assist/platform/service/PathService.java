package com.assist.platform.service;

import com.assist.platform.model.Path;

public interface PathService extends GenericService<Path, Integer> {

	public abstract Path getPathByPathsign(String pageSign);

}
