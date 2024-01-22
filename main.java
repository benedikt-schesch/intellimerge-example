import java.util.Map;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;

public class main {
    public void saveAll(Path root) {
        for(Map.Entry<Path, ParseResult<CompilationUnit>> 
            cu:content.entrySet()){
            final Path path=root.resolve(cu.getKey()); 
            save(cu.getValue().getResult().get(), path);
        } 
    }

    private void save(CompilationUnit cu, Path path){
        final String code=new PrettyPrinter().print(cu);
        try(PrintWriter out=
            new PrintWriter(path.toFile(), UTF8.toString())){
            out.println(code);
        }
    }

}
