package sa.edu.kau.fcit.cpit252.logger.formatter;

import sa.edu.kau.fcit.cpit252.logger.handlers.BaseLogger;

public class JSONFormatter extends FormatDecorator {

public JSONFormatter(BaseLogger logger) {
        super.logger = logger;
    }
    public String getLabel() {
        return logger.getLabel() +", JSONFormatter";
    }


    public String getLevel() {
        return  "Info " +logger.getLevel() ;
    }
}