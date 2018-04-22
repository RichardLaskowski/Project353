import Model.ImageBean;
import java.util.ArrayList;

public interface ImageDAO
{
    public int createImage(ImageBean imageModel);
    public ArrayList selectImageByImageId(int targetImageId);
}