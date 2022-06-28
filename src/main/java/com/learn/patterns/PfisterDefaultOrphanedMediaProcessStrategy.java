package com.learn.patterns;


import java.io.File;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PfisterDefaultOrphanedMediaProcessStrategy extends AbstractPfisterOrphanedMediaFileProcessStrategy {

	@Override
	public void process(final String mediaFile) {
		log.info("PfisterDefaultOrphanedMediaProcessStrategy working");
	}
}
