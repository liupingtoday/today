package cn.js.today.domain.ame;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * @Description TODO
 * @Author zhengheqi
 * @Date 2019/8/19 11:19
 * @Version 1.0.0
 */
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
//xml文件中的属性不用和对象属性完全对应
@XmlAccessorType(XmlAccessType.NONE)
// XML文件中的根标识
@XmlRootElement(name = "Manifest")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {
        "sourceFilePath",
        "destinationPath",
        "sourcePresetPath",
        "overwriteDestinationIfPresent",
        "sequenceGUID",
})
public class Manifest {
    /**
     * 工程文件路径
     */
    @JacksonXmlProperty(localName = "SourceFilePath")
    private String sourceFilePath;
    /**
     * 输出文件路径
     */
    @JacksonXmlProperty(localName = "DestinationPath")
    private String destinationPath;
    /**
     * 软件预设路径
     */
    @JacksonXmlProperty(localName = "SourcePresetPath")
    private String sourcePresetPath;
    /**
     * 是否覆盖输出目标 false | true
     */
    @JacksonXmlProperty(localName = "overwriteDestinationIfPresent")
    private String overwriteDestinationIfPresent;
    /**
     * 输出序列名称
     */
    @JacksonXmlProperty(localName = "SequenceGUID")
    private String sequenceGUID;

    public String getSourceFilePath() {
        return sourceFilePath;
    }
    @XmlElement(name = "SourceFilePath")
    public void setSourceFilePath(String sourceFilePath) {
        this.sourceFilePath = sourceFilePath;
    }


    public String getDestinationPath() {
        return destinationPath;
    }
    @XmlElement(name = "DestinationPath")
    public void setDestinationPath(String destinationPath) {
        this.destinationPath = destinationPath;
    }

    public String getSourcePresetPath() {
        return sourcePresetPath;
    }
    @XmlElement(name = "SourcePresetPath")
    public void setSourcePresetPath(String sourcePresetPath) {
        this.sourcePresetPath = sourcePresetPath;
    }

    public String getOverwriteDestinationIfPresent() {
        return overwriteDestinationIfPresent;
    }
    @XmlElement(name = "overwriteDestinationIfPresent")
    public void setOverwriteDestinationIfPresent(String overwriteDestinationIfPresent) {
        this.overwriteDestinationIfPresent = overwriteDestinationIfPresent;
    }

    public String getSequenceGUID() {
        return sequenceGUID;
    }
    @XmlElement(name = "SequenceGUID")
    public void setSequenceGUID(String sequenceGUID) {
        this.sequenceGUID = sequenceGUID;
    }

    @Override
    public String toString() {
        return "Manifest{" +
                ", sourceFilePath='" + sourceFilePath + '\'' +
                ", destinationPath='" + destinationPath + '\'' +
                ", sourcePresetPath='" + sourcePresetPath + '\'' +
                ", overwriteDestinationIfPresent='" + overwriteDestinationIfPresent + '\'' +
                ", sequenceGUID='" + sequenceGUID + '\'' +
                '}';
    }
}
