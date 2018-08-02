#include <stdio.h>
#include <unistd.h>
#include <errno.h>
#include <cutils/sockets.h>
#include <fcntl.h>
#include <poll.h>
#include <signal.h>
#include <stdio.h>
#include <string.h>


#define SOCKET_ADDRESS  "AppSocketAddress"

int main()
{
    int socket = socket_local_client(SOCKET_ADDRESS, ANDROID_SOCKET_NAMESPACE_ABSTRACT, SOCK_STREAM);
    if(socket < 0) {
        perror("socket error");
        return -1;
    }

    char buffer[50] = "make a test";
    int ret = write(socket, buffer, sizeof(buffer));
    if(ret < 0) {
        perror("write error");
        close(ret);
        return -1;
    }

    close(ret);
    return 0;
}
