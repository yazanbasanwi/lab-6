package sa.edu.kau.fcit.cpit252.logger.handlers;

public class FileLogger extends BaseLogger {

    public FileLogger(){
        label = "File logger";
    }

    public String getLevel() {
        return "warning";
    }
}
