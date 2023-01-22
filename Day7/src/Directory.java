import java.util.HashMap;
import java.util.Map;

public class Directory {

    private String name = "";
    private Integer size = 0;
    private Map<String, Directory> subdirectories = new HashMap<String, Directory>();
    private boolean sizeCalculated = false;

    public boolean isSizeCalculated() {
        return sizeCalculated;
    }

    public void setSizeCalculated(boolean sizeWasCalculate) {
        this.sizeCalculated = sizeWasCalculate;
    }

    public void addSubdirectory(String name, Directory directory) {
        subdirectories.put(name, directory);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size += size;
    }

    public Map<String, Directory> getSubdirectories() {
        return subdirectories;
    }
}
