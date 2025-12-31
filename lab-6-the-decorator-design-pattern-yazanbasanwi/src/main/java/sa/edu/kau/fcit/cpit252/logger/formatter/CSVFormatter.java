package sa.edu.kau.fcit.cpit252.logger.formatter;

import sa.edu.kau.fcit.cpit252.logger.handlers.BaseLogger;

public class CSVFormatter extends FormatDecorator {

    public CSVFormatter (BaseLogger logger){
        super.logger = logger;
    }   
    public String getLabel() {
        return  logger.getLabel() + ", CSVFormatter";
    }

    public String getLevel() {
        return "Info " +logger.getLevel();
    }
}