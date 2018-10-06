package brewczynskib.Forms;

import org.springframework.stereotype.Repository;

@Repository
public class TextForm {

    private String Area;

    private String word;

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
