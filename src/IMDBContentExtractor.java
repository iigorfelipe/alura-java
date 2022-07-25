import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IMDBContentExtractor implements ContentExtractor{
  
  public List<Content> contentExtractor(String json) {
  
    JsonParser parser = new JsonParser();
    List<Map<String, String>> attributeList = parser.parse(json);

    List<Content> contents = new ArrayList<>();

    for (Map<String, String> attributes : attributeList) {
      
      String title = attributes.get("title");
      String image = attributes.get("image");
      String urlImage = image.replaceAll("(@+)(.*).jpg$", "$1.jpg");
    
      var content = new Content(title, urlImage);

      contents.add(content);
    }

    return contents;
  }
}
