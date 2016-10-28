#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
using namespace std;

int main() {
	pid_t pid;
	pid = fork();
	if (pid < 0) {
		cout << "For failed\n";
		exit(-1);
	} else if(pid == 0) { //Child process
		cout << "Executing Child Process\n";
		char *name[2];
		name[0] = "/home/swe404/Desktop/even.out"; //make this file wherever
		name[1] = NULL;
		execvp(name[0], name);
	} else {
		wait(NULL); //Wait for child process to compelte. Short hand for waitpid(-1, NULL, 0);
		printf("Child complete. Executing parent\n");
		for(int i = 1; i <= 20; i += 2) {
			printf("%d ", i);
		}
		printf("\n");
		exit(0);
	}
	return 0;
}