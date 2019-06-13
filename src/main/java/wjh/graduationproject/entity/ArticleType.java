package wjh.graduationproject.entity;

/**
 * Created by Administrator on 2019/4/14.
 */
public class ArticleType {
    private String typeId;
    private String typeName;
    private int typeNum;

    public int getTypeNum() {
        return typeNum;
    }

    public void setTypeNum(int typeNum) {
        this.typeNum = typeNum;
    }

    @Override
    public String toString() {
        return "ArticleType{" +
                "typeId='" + typeId + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }

    public ArticleType() {
    }

    public ArticleType(String typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
