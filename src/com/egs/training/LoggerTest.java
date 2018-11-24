package com.egs.training;

import com.egs.training.logger.Logger;
import com.egs.training.logger.LoggerFactory;
import sun.awt.image.ImageFormatException;

public class LoggerTest {

    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger("my_third_logger");
        logger.warn("uploading image problem",new ImageFormatException("must be PNG"));
    }
}
