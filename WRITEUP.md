We used the provided shell script (threadtest.sh in our src folder) to test out the speed of interactions between the client and server. Our results line up with our expectations for the behavior of a threaded client-server pair.

Trial 1:
- 1 client
- textTest.txt (a small file)
- This trial finished almost instantly.

Trial 2:
- 100 clients
- textTest.txt (a small file)
- This trial took about one second.

Trial 3:
- 1 client
- Words.txt (a large file)
- This trial took about two seconds

Trial 4:
- 100 clients
- Words.txt (a large file)
- This trial took about forty seconds.
  - Notably, this is quicker than running Trial 3 100 times would have been.

Trial 5:
- 1 client
- pumpkins.jpg (an image)
- This trial took about one second.

Trial 6:
- 100 clients
- pumpkins.jpg (an image)
- This trial took about 20 seconds.
  - Notably, this is quicker than running Trial 5 100 times would have been.  
