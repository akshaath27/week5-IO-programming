import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

@Author(name = "John Doe")
class Document {}

public class RetrieveAnnotations {
    public static void main(String[] args) {
        Author author = Document.class.getAnnotation(Author.class);
        System.out.println(author.name());
    }
}