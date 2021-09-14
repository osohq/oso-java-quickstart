package quickstart;

import java.io.IOException;
import io.javalin.Javalin;
import com.osohq.oso.Oso;
import com.osohq.oso.Exceptions.NotFoundException;
import quickstart.Models.Repository;
import quickstart.Models.User;

public class Server {
    public static void main(String[] args) throws IOException {
        Javalin app = Javalin.create().start(5000);
        Oso oso = new Oso();
        oso.registerClass(User.class, "User");
        oso.registerClass(Repository.class, "Repository");
        oso.loadFile("src/main/java/quickstart/main.polar");
        app.get("/repo/{name}", ctx -> {
            ctx.contentType("text/html");
            String name = ctx.pathParam("name");
            Repository repo = Repository.byName(name);
            User user = User.getCurrentUser();

            try {
                oso.authorize(user, "read", repo);
                ctx.result(String.format("<h1>A Repo</h1><p>Welcome to repo %s</p>", repo.name));
            } catch (NotFoundException e) {
                ctx.status(404);
                ctx.result(String.format("<h1>Whoops!</h1><p>Repo named %s was not found</p>", name));
            }
        });
    }
}
