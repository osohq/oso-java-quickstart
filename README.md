# Oso Java Quickstart

Follow along [here](https://docs.osohq.com/java/getting-started/quickstart.html).

## Instructions

This project uses [Maven](https://maven.apache.org/) to manage dependencies. The
steps to get the example running are:

1. Clone this repository.
2. Install dependencies: `make install`
3. Run the server: `make run`

## Make some changes

If you visit
[http://localhost:5000/repo/gmail](http://localhost:5000/repo/gmail), you
should get a 200 response. If you visit
[http://localhost:5000/repo/react](http://localhost:5000/repo/react), you
should see a 404.

Add this code to `main.polar`:
```python
has_permission(_user: User, "read", repository: Repository) if
  repository.IsPublic;
```

Now, when you visit
[http://localhost:5000/repo/react](http://localhost:5000/repo/react), you should
see a proper 200 response, because the `react` repository is marked as public
in `models.go`.
