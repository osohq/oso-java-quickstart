package quickstart;

import java.util.HashMap;
import java.util.Map;

public class Models {
    public static class Repository {
        public String name;
        public boolean isPublic;

        public Repository(String name, boolean isPublic) {
            this.name = name;
            this.isPublic = isPublic;
        }

        public static Repository byName(String name) {
            return Models.reposDb.get(name);
        }
    }

    public static class Role {
      public String name;
      public Repository repository;

      public Role(String name, Repository repository) {
          this.name = name;
          this.repository = repository;
      }
    }

    public static class User {
        public Role[] roles;

        public User(Role[] roles) {
            this.roles = roles;
        }

        public static User getCurrentUser() {
            return Models.usersDb.get("larry");
        }
    }

    static Map<String, Repository> reposDb = Map.of(
        "gmail", new Repository("gmail", false),
        "react", new Repository("react", true), // react is public
        "oso", new Repository("oso", false)
    );

    static Map<String, User> usersDb = Map.of(
        "larry", new User(new Role[] {new Role("admin", reposDb.get("gmail"))}),
        "anne", new User(new Role[] {new Role("maintainer", reposDb.get("react"))}),
        "graham", new User(new Role[] {new Role("contributor", reposDb.get("oso"))})
    );
}
