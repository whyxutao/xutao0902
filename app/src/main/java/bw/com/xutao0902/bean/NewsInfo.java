package bw.com.xutao0902.bean;

import java.util.List;

public class NewsInfo {

    private List<ResultInfo> result;

    public List<ResultInfo> getResult() {
        return result;
    }

    public void setResult(List<ResultInfo> result) {
        this.result = result;
    }

    public class ResultInfo{

      private String imageUrl;
      private String title;

      public String getImageUrl() {
          return imageUrl;
      }

      public void setImageUrl(String imageUrl) {
          this.imageUrl = imageUrl;
      }

      public String getTitle() {
          return title;
      }

      public void setTitle(String title) {
          this.title = title;
      }
  }

}
