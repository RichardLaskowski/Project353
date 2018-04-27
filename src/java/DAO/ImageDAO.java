package DAO;

import Model.ImageBean;
import java.util.ArrayList;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

public interface ImageDAO {
    public long createImage(UploadedFile file, String username);
    public StreamedContent getImage();
    public ArrayList selectImageByImageId(int targetImageId);
}