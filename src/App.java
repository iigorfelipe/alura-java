import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        // IMDBContentExtractor extractor = new IMDBContentExtractor();

        String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
        NASAContentExtractor extractor = new NASAContentExtractor();

        ClientHTTP HTTP = new ClientHTTP();
        String json = HTTP.fetchDate(url);

        List<Content> contents = extractor.contentExtractor(json);
        
        var stickerGenerator = new StickerGenerator();

        for (int i = 0; i < 3; i += 1) {

            Content content = contents.get(i);

            InputStream inputStream = new URL(content.getUrlImage()).openStream();
            String nameFile = "output/" + content.getTitle() + ".png";

            stickerGenerator.createSticker(inputStream, nameFile);

            System.out.println(content.getTitle());
            System.out.println();
        }
    }
}
