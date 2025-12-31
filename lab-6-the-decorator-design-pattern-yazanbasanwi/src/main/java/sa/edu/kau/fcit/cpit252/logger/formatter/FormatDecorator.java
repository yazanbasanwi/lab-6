package sa.edu.kau.fcit.cpit252.logger.formatter;

import sa.edu.kau.fcit.cpit252.logger.handlers.BaseLogger;

public abstract class FormatDecorator extends BaseLogger {
    BaseLogger logger;
    // All format decorators have to reimplement the getLabel method
    public  abstract String getLabel();
}
