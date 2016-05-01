#include <iostream>
#include <queue>
#include <utility>

using namespace std;

class comparator {
public:
    bool operator()(pair<int, string> n1,pair<int, string> n2) {
        return n1.first > n2.first;
    }
};

int main() {
	int ch;
	pair<int, string> tasks[4];
	tasks[0] = make_pair(15, "PowerPoint");
	tasks[1] = make_pair(20, "Excel");
	tasks[2] = make_pair(5 , "Access");
	tasks[3] = make_pair(10, "Paint");
	cout << "Enter\n1 for FCFS \n2 for SJT";
	cin >> ch;
	if (ch == 1) {
		queue<pair<int, string> > q;
		int ftime[4];
		int ptime = 0;
		double turnaround_time = 0.0;
		for(int i = 0; i < 4; i++) {
			q.push(tasks[i]);
		}
		for (int i = 0; i < 4; i++) {
			pair<int, string> curr_task = q.front();
			q.pop();
			cout << "Idle time for Task "<< curr_task.second <<"is" << ptime << endl;
			ptime += curr_task.first;
			if (i == 0) {
				ftime[0] = curr_task.first;
			} else {
				ftime[i] = curr_task.first + ftime[i-1];
			}
			cout << "Individial turnaround time for " << curr_task.second << " is " << ftime[i] <<"\n\n";
			turnaround_time += ftime[i];	
		}
		turnaround_time /= 4.0;
		cout << "Average turnaround time is" << turnaround_time <<endl;
	} else if (ch == 2) {
		int ftime[4];
		int ptime = 0;
		double turnaround_time = 0.0;
		priority_queue<pair<int, string>, vector<pair<int, string> >, comparator> pq;
		for(int i = 0; i < 4; i++) {
			pq.push(tasks[i]);
		}
		for (int i = 0; i < 4; i++) {
			pair<int, string> curr_task = pq.top();
			pq.pop();
			cout << "Idle time for Task "<< curr_task.second <<"is" << ptime << endl;
			ptime += curr_task.first;
			if (i == 0) {
				ftime[0] = curr_task.first;
			} else {
				ftime[i] = curr_task.first + ftime[i-1];
			}
			cout << "Individial turnaround time for " << curr_task.second << " is " << ftime[i] <<"\n\n";
			turnaround_time += ftime[i];	
		}
		turnaround_time /= 4.0;
		cout << "Average turnaround time is" << turnaround_time <<endl;
	} else {
		cout << "Sorry\n";
	}
	return 0;
}