package wjh.graduationproject.entity;

/**
 * Created by Administrator on 2019/4/14.
 */
public class DownloadFileName {
    private String url;
    private String name;

    public DownloadFileName() {
    }

    public DownloadFileName(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public String toString() {
        return "DownloadFileName{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
