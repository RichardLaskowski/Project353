package DAO;

import Model.ImageBean;
import java.util.ArrayList;
import org.primefaces.model.UploadedFile;

public interface ImageDAO {
    public int createImage(UploadedFile file, String username);
    public ArrayList selectImageByImageId(int targetImageId);
}