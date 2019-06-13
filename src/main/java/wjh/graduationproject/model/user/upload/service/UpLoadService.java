package wjh.graduationproject.model.user.upload.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import wjh.graduationproject.entity.UserEntity;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2019/4/13.
 */
@Service
public class UpLoadService {
    public String saveArticelImg(UserEntity userEntity, MultipartFile articleImage,String uuid) {
            String imageName=articleImage.getOriginalFilename();
            String path="E:/upFilePosition/article/"+uuid+"/"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())
                    +"_"+imageName;
            File dest=new File(path);
            if (dest.exists()){
                return "-2";
            }
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                articleImage.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
                return "-1";
            }
        return path;
    }
    public String saveUpFile(MultipartFile[] files,UserEntity userEntity,String uuid){
        int pathNum=0;
        for (MultipartFile file:files){
            if (!file.isEmpty()){
                pathNum++;
            }
        }
        if (pathNum==0){
            return "0";
        }
        String paths[]=new String[pathNum];
        pathNum=0;
        for (MultipartFile file:files){
            if (!file.isEmpty()){
                String path=saveArticelImg(userEntity,file,uuid);
                if (path.equals("-1")||path.equals("-2")){
                    return path;
                }
                paths[pathNum]=path;
                pathNum++;
            }
        }
        String pathString="";
        for (int i=0;i<paths.length-1;i++){
            pathString+=paths[i]+";";
        }
        if (paths.length>0){
            pathString+=paths[paths.length-1];
        }
        return pathString;
    }
}
